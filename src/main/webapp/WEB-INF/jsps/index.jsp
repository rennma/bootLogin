<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base basePath=${pageContext.request.contextPath}>
<title>登录</title>
</head>
<body>
	<h2 style="color: red;">首页</h2>
	<input type="button" value="登录"
		onclick="javascript:window.location.href='comm/login.html'" />
	</form>
	<input type="button" value="注册"
		onclick="javascript:window.location.href='comm/register.html'" />
	</form>
</body>
</html>