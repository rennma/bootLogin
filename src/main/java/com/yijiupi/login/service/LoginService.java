package com.yijiupi.login.service;

import com.yijiupi.login.VO.UserVO;;

/**
 * @author 魏阳军
 * @date 2018年1月24日 14:41
 * @since jdk1.8.0
 */
public interface LoginService {
	
	/**
	 * 根据用户名和密码获得一个UserPO对象.
	 * 
	 * @param userName
	 *            String类型 用户名
	 * @param password
	 *            String类型 密码
	 * @return UserVO对象.
	 */
	UserVO getUserVO(String userName, String password);
}
