/*
 * Copyright (c) 2018, weiYangJun. All rights free.
 * 
 * 
 */

package com.yijiupi.login.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.yijiupi.login.PO.UserPO;
import com.yijiupi.login.VO.UserVO;
import com.yijiupi.login.configuration.RelativeUploadPathProperties;
import com.yijiupi.login.constant.PathConstant;
import com.yijiupi.login.constant.UserConstant;
import com.yijiupi.login.constant.UserVOCheckMessageConstant;
import com.yijiupi.login.service.LoginService;
import com.yijiupi.login.service.RegisterService;
import com.yijiupi.login.threadLocal.UserSessionThreadLocal;
import com.yijiupi.login.util.ControllerUtils;

/**
 * 该类是包含与用户登录注册行为有关的处理逻辑的类.
 * 
 * @author 魏阳军
 * @date 2018年1月15日 16:25
 * @since jdk1.8.0
 */
@EnableConfigurationProperties(RelativeUploadPathProperties.class)
@Controller
@RequestMapping(PathConstant.COMM_PATH)
public class UserCommController {
	/** 日志使用slf4j. */
	private Logger LOGGER = LoggerFactory.getLogger(UserCommController.class);

	@Autowired
	private LoginService loginService;

	@Autowired
	private RegisterService registerService;

	@Autowired
	private RelativeUploadPathProperties relativeUploadPathProperties;

	/**
	 * 响应浏览器请求登录页面的方法.
	 * 
	 * @return String类型 返回给浏览器的页面的逻辑视图名.
	 *
	 */
	@RequestMapping(PathConstant.LOGIN_JSP_URL)
	public String loginPage() {
		LOGGER.info("进入了login.html");
		return "comm/login";
	}

	/**
	 * 响应浏览器请求注册页面的方法.
	 * 
	 * @return String类型 返回给浏览器的页面的逻辑视图名.
	 *
	 */
	@RequestMapping(PathConstant.REGISTER_JSP_URL)
	public ModelAndView registerPage(ModelAndView model) {
		model.setViewName("comm/register");
		model.addObject("userVO", new UserVO());
		return model;
	}

	/**
	 * 响应用户点击登录按钮的方法.
	 * 
	 * @param userName
	 *            用户名
	 * @param password
	 *            用户密码
	 * @param model,Molde结合sessionAttribute注解将userVO对象放入HttpSession
	 * @return Map<String,String>，在springMVC配置文件中配置的json解析器会将Map解析成json对象发送给页面ajax回调函数.
	 *
	 */
	@RequestMapping(PathConstant.LOGIN_DO_URL)
	@ResponseBody
	public Map<String, String> login(String userName, String password, HttpSession session) {
		LOGGER.info("用户名：" + userName + ",密码：" + password);
		// 用户名或密码如果为空，则返回一个消息告知用户.
		HashMap<String, String> result = new HashMap<String, String>();
		if (!ControllerUtils.ifUserNameOrPasswordNull(userName, password)) {
			LOGGER.info("登录时login的验证成功");
			result.put("message", UserVOCheckMessageConstant.USERNAME_OR_PASSWORD_NULL);
			return result;
		}

		// 如果用户名或密码不为空，则验证用户名或密码是否正确.
		UserVO userVO = loginService.getUserVO(userName, password);
		if (null == userVO) {
			result.put("message", UserVOCheckMessageConstant.USERNAME_OR_PASSWORD_ERROR);
			return result;
		}

		// 如果用户名和密码也正确，则登陆成功，通知浏览器跳转到欢迎页面.
		UserSessionThreadLocal.setUserSessionAttribute(UserConstant.USER_IN_SESSION, userVO);
		result.put("message", "redirect");
		return result;
	}

	/**
	 * 响应用户点击注册按钮的方法.
	 * 
	 * @param userVO,页面表单信息封装成的UserVO对象
	 * @param file,表单唯一的一个文件项
	 * @param model,Molde结合sessionAttribute注解将userVO对象放入HttpSession
	 * @return String，根据处理逻辑产生的要返回给浏览器的页面或信息
	 *
	 */
	@RequestMapping(PathConstant.REGISTER_DO_URL)
	public String register(@Valid UserVO userVO, BindingResult result,
			@RequestParam(required = true) MultipartFile file, HttpSession session) throws IOException {
		// 先验证用户输入的信息是否全部符合条件，重复密码使用javaScript在网页中验证、其他使用jsr303在后台验证的.
		if (result.hasErrors()) {
			LOGGER.info(result.getAllErrors().toString());
			LOGGER.info("用户输入有错误");
			String basePath = new File("path.txt").getAbsolutePath();
			LOGGER.info(basePath);
			return "comm/register";
		}

		LOGGER.info("用户输入没有错误");

		// 如果用户填写的信息验证通过，则获得存储用户头像图片的路径、并将用户信息封装成UserPO对象.
		String basePath = new File("path.txt").getAbsolutePath();
		String imagePath = basePath.substring(0, basePath.indexOf("path.txt"))
				+ relativeUploadPathProperties.getImagePath();

		// 图片重命名为当前毫秒数和原文件名的和.
		String fileName = System.currentTimeMillis() + file.getOriginalFilename();
		UserPO userPO = new UserPO(userVO.getUserName(), userVO.getPassword(), userVO.getTelPhone(), userVO.getEmail(),
				fileName);

		// 如果UserPO对象持久化不成功，则返回注册页面.
		if (!registerService.insertUserPO(userPO)) {
			return "comm/register";
		}

		// 如果前面过程都通过，且上传的文件不为空，则将文件写到指定位置.
		if (!file.isEmpty()) {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(imagePath.toString(), fileName));
		}

		// 将UserVO对象添加到session中，并重定向到欢迎页面.
		userVO.setPortraitPath(fileName);
		UserSessionThreadLocal.setUserSessionAttribute(UserConstant.USER_IN_SESSION, userVO);
		return "redirect:../logined/welcome.html";
	}

	/**
	 * 响应浏览器检查用户名是否存在的请求的方法.
	 * 
	 * @param userName
	 *            用户名
	 * 
	 * @return Map<String,String>，在springMVC配置文件中配置的json解析器会将Map解析成json对象发送给页面ajax回调函数.
	 *
	 */
	@RequestMapping(PathConstant.CHECK_USERNAME_IF_EXISTS_URL)
	@ResponseBody
	public Map<String, String> checkUserNameIfExists(String userName) {
		LOGGER.info("用户名：" + userName);
		HashMap<String, String> result = new HashMap<String, String>();
		Integer queryResult = registerService.queryUserNameIfExits(userName);
		if (null == queryResult) {
			result.put("message", UserVOCheckMessageConstant.USERNAME_NOT_EXISTS);
		}

		if (null != queryResult) {
			result.put("message", UserVOCheckMessageConstant.USERNAME_EXISTS);
		}
		return result;
	}
}
