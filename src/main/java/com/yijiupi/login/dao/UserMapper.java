package com.yijiupi.login.dao;

import org.apache.ibatis.annotations.Param;

import com.yijiupi.login.PO.UserPO;
import com.yijiupi.login.VO.UserVO;;

/**
 * 与UserPO持久化、查询数据库获得UserVO有关的类.
 * 
 * @author 魏阳军
 * @date 2018年1月24日 14:41
 * @since jdk1.8.0
 */
public interface UserMapper {
	/**
	 * 根据给定参数从数据库中获得一个UserVO对象.
	 * 
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 * @return UserVO对象
	 **/
	UserVO getUserVO(@Param("userName") String userName, @Param("password") String password);

	/**
	 * 根据给定参数从数据库中查询给定参数是否已存在数据库中.
	 * 
	 * @param userName
	 *            用户名
	 * @return integer，为null代表给定参数不存在数据库中、否则存在与数据库中.
	 **/
	Integer queryUserNameIfExits(String userName);

	/**
	 * 持久化一个UserPO对象到数据库中.
	 * 
	 * @param userPO
	 *            UserPO对象
	 * @return 布尔值，为true代表持久化成功、否则持久化不成功.
	 **/
	boolean insertUserPO(UserPO userPO);
}
