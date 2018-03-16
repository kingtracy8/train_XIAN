<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div class="register">
		<%=request.getAttribute("msg") %><br> 欢迎您<%=session.getAttribute("userName") %>
	</div>
</body>
</html>
