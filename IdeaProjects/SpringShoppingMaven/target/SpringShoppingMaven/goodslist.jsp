<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">

	<title>商品</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

</head>

<body>
<div>
	${goods}
	<%=request.getAttribute("goodsList")%>
		12
	<%=request.getAttribute("sales")%>

</div>
<c:if test="${pageNo!=1}">
<a href="getAllGoods?pageNo=1">
	</c:if>
	第一页
	<c:if test="${pageNo!=1}">
</a>
</c:if>

<c:if test="${pageNo!=1}">
<a href="getAllGoods?pageNo=${pageNo-1}">
	</c:if>
	上一页
	<c:if test="${pageNo!=1}">
</a>
</c:if>

<c:if test="${pageNo!=pageCount}">
<a href="getAllGoods?pageNo=${pageNo+1}">
	</c:if>
	下一页
	<c:if test="${pageNo!=pageCount}">
</a>
</c:if>

<c:if test="${pageNo!=pageCount}">
<a href="getAllGoods?pageNo=${pageCount}">
	</c:if>
	最后一页
	<c:if test="${pageNo!=pageCount}">
</a>
</c:if>
共${pageCount }页，当前为第${pageNo }页，
<a href="addGoods.jsp">添加商品</a>
<a href="showCart">查看购物车</a>
<a href="showAllOrders">查看订单</a>
${requestScope.resultMessage}
<table border=1>
	<tr>
		<th>产品编号</th>
		<th>产品名称</th>
		<th>产品价格</th>
		<th>售出数量</th>
		<th>操作</th>
	</tr>
	<c:forEach var="goods" items="${requestScope.goodsList}">
		<tr>
			<td>${goods.goodsId}</td>
			<td>${goods.goodsName}</td>
			<td>${goods.price}</td>
			<td>${sales[goods.goodsId]}</td>
			<td><a href="addToCart?goodsId=${goods.goodsId}">将产品添加到购物车里</a>
				<a href="showModifyPage?goodsId=${goods.goodsId}">修改商品</a>
				<a href="deleteGoods?goodsId=${goods.goodsId}">删除商品</a>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
