<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>订单</title>
</head>
<body>
<a href="getAllGoods">继续购物</a>
${requestScope.resultMessage}
<c:if test="${!empty orders}">
    <c:forEach items="${orders}" var="order">
        <table border="1">
            <form action="deleteOrder" method="post">
                <tr>
                    <input type="hidden" name="orderId" value="${order.id}"/>
                    <th>订单编号</th>
                    <td>${order.id}</td>
                    <th>创建时间</th>
                    <td>${order.createdTime}</td>
                    <td><input type="submit" value="删除订单"></td>
                </tr>
                <tr>
                    <th>物品编号</th>
                    <th>物品名称</th>
                    <th>物品价格</th>
                    <th>物品数量</th>
                </tr>
                <c:forEach items="${order.itemView}" var="item">
                    <tr>
                        <td>${item.goodsVo.goodsId}</td>
                        <td>${item.goodsVo.goodsName}</td>
                        <td>${item.goodsVo.price}</td>
                        <td>${item.quantity}</td>
                    </tr>
                </c:forEach>
            </form>
        </table>
        <br/>
    </c:forEach>
</c:if>

<c:if test="${empty orders}">
    订单为空，请直接购物！
</c:if>
</body>
</html>
