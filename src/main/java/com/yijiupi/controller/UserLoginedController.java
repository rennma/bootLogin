package com.yijiupi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.yijiupi.constant.PathConstant;

/**
 * 该类用于处理用户访问登录后的页面的逻辑.
 * 
 * @author 魏阳军
 * @date 2018年1月15日 16:25
 * @since jdk1.8.0
 */
@Controller
@RequestMapping(PathConstant.LOGINED_COMM_PATH)
public class UserLoginedController {

	/**
	 * 响应浏览器请求欢迎页面的方法.
	 * 
	 * @return String类型 返回给浏览器的页面的逻辑视图名.
	 *
	 */
	@RequestMapping(PathConstant.WELCOME_JSP_URL)
	public String loginPage() {
		return "logined/welcome";
	}

}
