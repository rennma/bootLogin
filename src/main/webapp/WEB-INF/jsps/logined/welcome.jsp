<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" charset="utf-8" src="../js/jquery-3.0.0.min.js"></script>
<script src="../js/welcome.js"></script>
<link href="../css/welcome.css" rel="stylesheet" type="text/css" />
<base basePath=${pageContext.request.contextPath}>
<title>欢迎</title>
</head>
<body>
	<h2>欢迎，</h2>
	<div>
		<span>头像：</span><img src="../image/${sessionScope.userLogined.portraitName}" /></span>
	</div>
	<div>
		<span>用户名：</span><span>${sessionScope.userLogined.userName}</span>
	</div>
	<div>
		<span>手机号：</span><span>${sessionScope.userLogined.telPhone}</span>
	</div>
	<div>
		<span>邮箱：</span><span>${sessionScope.userLogined.email}</span>
	</div>
	<a href="javascript:;" onclick="javascript:logout('../other/logout.do')"
		id="logOut">退出登录</a>
	</br>
	</br>
</body>
</html>