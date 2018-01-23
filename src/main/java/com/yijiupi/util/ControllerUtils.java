package com.yijiupi.util;

/**
 * 该类是给控制器controller使用的工具类.
 * 
 * @author 魏阳军
 * @date 2018年1月15日 16:25
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
		boolean returnValue = !(null == userName || null == password || "".equals(userName) || "".equals(password));
		return returnValue;
	}
}
