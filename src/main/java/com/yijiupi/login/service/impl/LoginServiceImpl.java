package com.yijiupi.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yijiupi.login.VO.UserVO;
import com.yijiupi.login.dao.UserMapper;
import com.yijiupi.login.service.LoginService;

/**
 * @author 魏阳军
 * @date 2018年1月15日 16:25
 * @since jdk1.8.0
 */
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	UserMapper userMapper;

	/**
	 * @see com.yijiupi.service.LoginService#getUserVO(String userName, String password).
	 */
	public UserVO getUserVO(String userName, String password) {
		return userMapper.getUserVO(userName, password);
	}
}
