<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    您创建的商品信息如下：<br>
  <!-- 使用EL表达式取出model中goods的信息 -->
    商品名为：${goods.goodsname }， 
    商品价格为：${goods.goodsprice }，
    商品数量为：${goods.goodsnumber }。
</body>
</html>