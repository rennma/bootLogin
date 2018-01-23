/*
 * Copyright (c) 2018, weiYangJun. All rights free.
 * 
 * 
 */

package com.yijiupi.PO;

/**
 * 这是一个映射用户的pojo类.
 * <p>
 * 该类有两个构造器.
 * 
 * @author 魏阳军
 * @date 2018年1月15日 16:25
 * @since jdk1.8.0
 */

public class UserPO {
	/** 属性：用户名. */
	private String userName;

	/** 属性：用户密码. */
	private String password;

	/** 属性：手机号. */
	private String telPhone;

	/** 属性：邮箱. */
	private String email;

	/** 属性：头像路径. */
	private String portraitName;

	/** 有参构造器. */
	public UserPO(String userName, String password, String telPhone, String email, String portraitName) {
		this.userName = userName;
		this.password = password;
		this.telPhone = telPhone;
		this.email = email;
		this.portraitName = portraitName;
	}

	/** 无参构造器. */
	public UserPO() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPortraitName() {
		return portraitName;
	}

	public void setPortraitName(String portraitName) {
		this.portraitName = portraitName;
	}

}
