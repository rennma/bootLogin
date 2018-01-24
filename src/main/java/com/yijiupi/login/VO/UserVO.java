/*
 * Copyright (c) 2018, weiYangJun. All rights free.
 * 
 * 
 */

package com.yijiupi.login.VO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 这是一个映射用户的pojo类
 * <p>
 * 该类有两个构造器.
 * 
 * @author 魏阳军
 * @date 2018年1月24日 14:41
 * @since jdk1.8.0
 */

public class UserVO {
	/** 属性：用户名. */
	@NotNull(message = "用户名不能为空")
	@Size(min = 1, max = 16, message = "用户名为1-16个中英文字符")
	private String userName;

	/** 属性：密码. */
	@Pattern(regexp = "^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;',\\\\\\\\[\\\\\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]){6,20}$", message = "请输入正确的6-20位密码")
	private String password;

	/** 属性：确认密码. */
	private String passwordCopy;

	/** 属性：手机号. */
	@Pattern(regexp = "^[1][3,4,5,7,8][0-9]{9}$", message = "请输入正确的手机号")
	private String telPhone;

	/** 属性：邮箱. */
	@Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", message = "请输入正确的邮箱地址")
	private String email;

	/** 属性：头像存储路径. */
	private String portraitName;

	/**
	 * 有参构造器.
	 */
	public UserVO(String userName, String telPhone, String email, String portraitName) {
		super();
		this.userName = userName;
		this.telPhone = telPhone;
		this.email = email;
		this.portraitName = portraitName;
	}

	/**
	 * 无参构造器.
	 */
	public UserVO() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPortraitName() {
		return portraitName;
	}

	public void setPortraitPath(String portraitName) {
		this.portraitName = portraitName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCopy() {
		return passwordCopy;
	}

	public void setPasswordCopy(String passwordCopy) {
		this.passwordCopy = passwordCopy;
	}

}
