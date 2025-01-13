<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>购物车</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

</head>

<body>
<a href="getAllGoods">继续购物</a>
<a href="clearCart">清空购物车</a>
${requestScope.resultMessage}

<c:if test="${!empty cart}">

    <table border="1">
        <tr>
            <th>物品名称</th>
            <th>物品价格</th>
            <th>物品编号</th>
            <th>物品数量</th>
            <th></th>
        </tr>
        <c:forEach items="${cart}" var="item">
            <tr>
                <form action="processCart" method="post">
                    <input type="hidden" name="id" value="${item.id}"/>
                    <td>${item.goodsVo.goodsId}</td>
                    <td>${item.goodsVo.goodsName}</td>
                    <td>${item.goodsVo.price}</td>
                    <td><input type="text" name="quantity" value="${item.quantity}"/></td>
                    <td><input type="submit" name="action" value="修改"/><input type="submit" name="action" value="删除"/></td>
                </form>
            </tr>
        </c:forEach>
    </table>
    <form action="addOrder" method="post">
        <input type="submit" value="添加订单"/>
    </form>
</c:if>

<c:if test="${empty cart}">
    购物车为空，请直接购物！
</c:if>
</body>
</html>
