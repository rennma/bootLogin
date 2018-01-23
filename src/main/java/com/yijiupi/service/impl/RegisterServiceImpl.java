package com.yijiupi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yijiupi.dao.UserMapper;
import com.yijiupi.PO.UserPO;
import com.yijiupi.service.RegisterService;

/**
 * @author 魏阳军
 * @date 2018年1月15日 16:25
 * @since jdk1.8.0
 */
@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	UserMapper userMapper;

	public boolean insertUserPO(UserPO userPO) {

		return userMapper.insertUserPO(userPO);
	}

	public Integer queryUserNameIfExits(String userName) {

		return userMapper.queryUserNameIfExits(userName);
	}

}
