<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		text-align: center;
	}
	.textSize{
		width: 120px;
		height: 25px;
	}
	* {
		margin: 0px;
		padding: 0px;
	}
	body {
		font-family: Arial, Helvetica, sans-serif;
		font-size: 12px;
		margin: 10px 10px auto;
		background-image: url(images/bb.jpg);
	}
	</style>
</head>
<body>
<form action="user/register" method="post" name="registForm">
	<table>
			<tr>
				<td>姓名：</td>
				<td>
					<input class="textSize" type="text" name="uname"/>
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input class="textSize" type="password" maxlength="20" name="upwd"/></td>
			</tr>
			<tr>
				<td>确认密码：</td>
			<td><input class="textSize" type="password" maxlength="20" name="reupwd"/></td>
			</tr>
			<tr>
			<td colspan="2" align="center"><input type="submit" value="注册" /></td>
			</tr>
		</table>
	</form>
</body>
</html>