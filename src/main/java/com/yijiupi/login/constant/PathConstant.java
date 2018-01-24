/*
 * Copyright (c) 2018, weiYangJun. All rights free.
 * 
 * 
 */

package com.yijiupi.login.constant;

/**
 * 路径常量类.
 * 
 * @author 魏阳军
 * @date 2018年1月24日 14:41
 * @since jdk1.8.0
 */
public class PathConstant {
	/**
	 * 登录和注册路径的公共部分.
	 */
	public static final String COMM_PATH = "/comm/";

	/**
	 * 登录的jsp页面的路径.
	 */
	public static final String LOGIN_JSP_URL = "login.html";

	/**
	 * controller处理登录的方法的路径.
	 */
	public static final String LOGIN_DO_URL = "login.do";

	/**
	 * 注册的jsp页面的路径.
	 */
	public static final String REGISTER_JSP_URL = "register.html";

	/**
	 * controller处理注册的方法的路径.
	 */
	public static final String REGISTER_DO_URL = "register.do";

	/**
	 * 登录后页面路径的公共部分.
	 */
	public static final String LOGINED_COMM_PATH = "/logined/";

	/**
	 * 欢迎的jsp页面的路径.
	 */
	public static final String WELCOME_JSP_URL = "welcome.html";

	/**
	 * 应用默认页面.
	 */
	public static final String DEFAULT_JSP_URL = "/";

	/**
	 * 应用首页.
	 */
	public static final String FIRST_JSP_URL = "index.html";

	/**
	 * controler中执行注销逻辑的方法的路径.
	 */
	public static final String LOGOUT_DO_URL = "other/logout.do";

	/**
	 * controler中验证用户名是否存在的方法的路径.
	 */
	public static final String CHECK_USERNAME_IF_EXISTS_URL = "checkUserNameIfExists.do";

}
