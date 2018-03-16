<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div class="register">
		<form action="/Train1/registerSeverlet" method="post">
			<div class="login-box">

				<table width="350" height="200">

					<tr align="center">

						<td><div>用户名：</div></td>
						<td colspan="2"><input type="text" name="userName" /></td>

					</tr>

					<tr align="center">

						<td><div>密&nbsp;&nbsp;码：</div></td>
						<td colspan="2"><input type="password" name="passWord" /></td>

					</tr>

					<tr align="center">

						<td colspan="3"><input type="submit"
							style="width: 50px; background-color: red;" value="注册" /></td>

					</tr>
					<tr>
						<td><%=request.getAttribute("msg")%></td>
					</tr>

				</table>


			</div>
		</form>
	</div>
</body>
</html>