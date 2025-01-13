<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/my/formatter" method="post">
    		商品名称：<input type="text" name="goodsname"/><br>
    		商品价格：<input type="text" name="goodsprice"/><br>
    		商品数量：<input type="text" name="goodsnumber"/><br>
    		商品日期：<input type="text" name="goodsdate"/>（yyyy-MM-dd）<br>
    		<input type="submit" value="提交"/>
    </form>
</body>
</html>