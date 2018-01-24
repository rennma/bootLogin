package com.yijiupi.login.util;

/**
 * 该类是给控制器controller使用的工具类.
 * 
 * @author 魏阳军
 * @date 2018年1月24日 14:41
 * @since jdk1.8.0
 */
public class ControllerUtils {
	/**
	 * 该方法用于检查用户名或密码是否为空
	 * 
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 * @return 布尔型，如果用户名或密码均不为空返回true，否则返回false.
	 */
	public static boolean ifUserNameOrPasswordNull(String userName, String password) {
		// 判断用户名和密码是否为null.
		boolean returnValue1 = (null != userName && null != password);

		// 判断用户名和密码是否与""值相等.
		boolean returnValue2 = (!"".equals(userName)) && !"".equals(password);

		return returnValue1 && returnValue2;
	}
}
