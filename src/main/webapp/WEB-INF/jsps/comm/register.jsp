<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form"%>
<jsp:useBean id="userVO" class="com.yijiupi.VO.UserVO" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" charset="utf-8"
	src="../js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" charset="utf-8" src="../js/register.js"></script>
<link href="../css/register.css" rel="stylesheet" type="text/css" />
<head>
<base basePath=${pageContext.request.contextPath}>
<title>注册</title>
</head>
<body>
	<fm:errors path="persistenceFail" cssClass="error" />
	<fm:form action="register.do" enctype="multipart/form-data"
		method="post" modelAttribute="userVO">
		<div>
			<span>请输入用户名：</span>
			<fm:input path="userName"  onblur="checkUserNameIfExists();"/>
			<fm:errors path="userName" cssClass="error" errorMessage="errorMessage"/>
			<span id="errorMessage"></span>
		</div>
		<div>
			<span>上传一张头像：</span> <input type="file" name="file" />
		</div>
		<div>
			<span>请输入密码：</span>
			<fm:password path="password" />
			<fm:errors path="password" cssClass="error" />
		</div>
		<div>
			<span>再次输入密码：</span>
			<fm:password path="passwordCopy" onblur="checkPasswordIfSame();" />
			<span id="passwordError"></span>
		</div>
		<div>
			<span>手机号：</span>
			<fm:input path="telPhone" />
			<fm:errors path="telPhone" cssClass="error" />
		</div>
		<div>
			<span>邮箱：</span>
			<fm:input path="email" />
			<fm:errors path="email" cssClass="error" />
		</div>
		<input type="submit" value="提交" />
		<a href="login.html">我有账号，登录</a>
	</fm:form>
</body>
</html>