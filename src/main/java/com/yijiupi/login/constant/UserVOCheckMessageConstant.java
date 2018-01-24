/*
 * Copyright (c) 2018, weiYangJun. All rights free.
 * 
 * 
 */

package com.yijiupi.login.constant;

/**
 * 用户验证信息常量类.
 * 
 * @author 魏阳军
 * @date 2018年1月24日 14:41
 * @since jdk1.8.0
 */
public class UserVOCheckMessageConstant {

	/**
	 * 用户名或密码为空的消息.
	 */
	public static final String USERNAME_OR_PASSWORD_NULL = "用户名或密码不能为空，请重新输入!";

	/**
	 * 用户名或密码错误的消息.
	 */
	public static final String USERNAME_OR_PASSWORD_ERROR = "用户名或密码不正确，请重新输入!";

	/**
	 * 用户名已存在的消息.
	 */
	public static final String USERNAME_EXISTS = "用户名已存在，请换一个";

	/**
	 * 用户名不已存在的消息.
	 */
	public static final String USERNAME_NOT_EXISTS = "用户名不存在，可以使用";

}
