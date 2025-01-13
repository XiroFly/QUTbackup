<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/my/converter" method="post">
    		请输入商品信息（格式为：apple,10.58,200）：
    		<input type="text" name="goods"/><br>
    		<input type="submit" value="提交"/>
    </form>
</body>
</html>