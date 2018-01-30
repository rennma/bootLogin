package com.yijiupi.login.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yijiupi.login.constant.PathConstant;
import com.yijiupi.login.constant.UserConstant;
import com.yijiupi.login.threadLocal.UserSessionThreadLocal;

/**
 * 该类包含响应用户访问默认页、首页和注销登录状态的方法.
 * 
 * @author 魏阳军
 * @date 2018年1月24日 14:41
 * @since jdk1.8.0
 */
@Controller
public class UserOtherController {

	private Logger LOGGER = LoggerFactory.getLogger(UserOtherController.class);

	@Autowired
	private UserSessionThreadLocal userSessionThreadLocal;

	/**
	 * 如果浏览器发过来的url只包含服务器地址和应用名而不包含其它任何距离页面请求，则返回默认的页面index.html.
	 * 
	 * @return String类型 返回给浏览器的页面的逻辑视图名.
	 */
	@RequestMapping(PathConstant.DEFAULT_JSP_URL)
	public String indexPage(Map<String, String> map) {
		LOGGER.info("进入了默认页controller");
		map.put("hello", "我的第一个thymeleaf");
		return "/index";
	}

	/**
	 * 响应浏览器对网站首页index.html的请求.
	 * 
	 * @return String类型 返回给浏览器的页面的逻辑视图名.
	 */
	@RequestMapping(PathConstant.FIRST_JSP_URL)
	public String loginPage() {
		return "index";
	}

	/**
	 * 响应用户点击退出"登录按钮"的方法.
	 * 
	 * @param Model对象，与sessionAttribute组合可以操作session里面的键值对.
	 * @return Map<String,String> 返回给welcome.jsp页面里ajax回调函数的一个信息.
	 */
	@RequestMapping(PathConstant.LOGOUT_DO_URL)
	@ResponseBody
	public Map<String, String> logout(HttpSession session) {
		userSessionThreadLocal.removeUserSessionAttribute(UserConstant.USER_IN_SESSION);
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "logoutSuccess");
		return map;
	}

}
