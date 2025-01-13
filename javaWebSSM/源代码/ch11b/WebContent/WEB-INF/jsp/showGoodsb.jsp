<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    您创建的商品信息如下：<br>
  <!-- 使用EL表达式取出Action类的属性goods的值 -->
    商品名称为：${goods.goodsname }<br>
    商品价格为：${goods.goodsprice }<br>
    商品数量为：${goods.goodsnumber }<br>
    商品日期为：${goods.goodsdate }
</body>
</html>