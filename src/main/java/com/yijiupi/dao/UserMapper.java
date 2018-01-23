package com.yijiupi.dao;

import org.apache.ibatis.annotations.Param;

import com.yijiupi.PO.UserPO;
import com.yijiupi.VO.UserVO;;

/**
 * 与UserPO持久化、查询数据库获得UserVO有关的类.
 * 
 * @author 魏阳军
 * @date 2018年1月15日 16:25
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
	public UserVO getUserVO(@Param("userName") String userName, @Param("password") String password);

	/**
	 * 根据给定参数从数据库中查询给定参数是否已存在数据库中.
	 * 
	 * @param userName
	 *            用户名
	 * @return integer，为null代表给定参数不存在数据库中、否则存在与数据库中.
	 **/
	public Integer queryUserNameIfExits(String userName);

	public boolean insertUserPO(UserPO userPO);
}
