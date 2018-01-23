<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" charset="utf-8" src="../js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" charset="utf-8" src="../js/login.js"></script>
<head>
<base basePath=${pageContext.request.contextPath}>
<title>登录</title>
</head>
<body>
	<form action="login.do" method="post">
		<span>用户名：</span><input type="text" id="userName" />
		<span id="errorMessage" style="color:red;"></span>
		</br>
		<%-- <%=response %> --%>
		<span>密码:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span><input type="password"
		 id="password" /></br> </br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<input type="button" value="登录" onClick="login();" />
		&nbsp&nbsp<input type="button" value="注册"
			onclick="javascript:window.location.href='register.html'" />
	</form>
</body>
</html>