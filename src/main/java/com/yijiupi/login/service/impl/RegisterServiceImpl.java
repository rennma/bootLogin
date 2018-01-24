package com.yijiupi.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yijiupi.login.PO.UserPO;
import com.yijiupi.login.dao.UserMapper;
import com.yijiupi.login.service.RegisterService;

/**
 * @author 魏阳军
 * @date 2018年1月15日 16:25
 * @since jdk1.8.0
 */
@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	UserMapper userMapper;

	/**
	 * @see com.yijiupi.service.RegisterService#insertUserPO(UserPO userPO).
	 */
	public boolean insertUserPO(UserPO userPO) {

		return userMapper.insertUserPO(userPO);
	}

	/**
	 * @see com.yijiupi.service.RegisterService#queryUserNameIfExits(String userName).
	 */
	public Integer queryUserNameIfExits(String userName) {

		return userMapper.queryUserNameIfExits(userName);
	}

}
