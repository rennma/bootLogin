package com.yijiupi.login.service;

import com.yijiupi.login.PO.UserPO;;

/**
 * @author 魏阳军
 * @date 2018年1月24日 14:41
 * @since jdk1.8.0
 */
public interface RegisterService {

	/**
	 * 持久化一个UserPO对象.
	 * 
	 * @param UserPO对象
	 * 
	 * @return 布尔值，持久化成功时返回true、否则返回false.
	 */
	boolean insertUserPO(UserPO userPO);
	
	/**
	 * 根据给定参数查询用户名是否可用
	 * 
	 * @param userName String类 用户名
	 * 
	 * @return integer，数据库中不存在该用户名则返回null.
	 */
	Integer queryUserNameIfExits(String userName);
}
