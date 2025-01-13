<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>modify</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>
<body>
<form action="modifyGoodsServlet" method="get">
                产品编号:<input type="text" value="${requestScope.single.goodsId}" name="goodsId"><br>
                产品名称:<input type="text" value="${requestScope.single.goodsName}" name="goodsName"><br>
                产品价格:<input type="text" value="${requestScope.single.price}" name="price"><br>
            <input type="radio" name="type" value="增加">增加
            <input type="radio" name="type" value="修改">修改
            <input type="radio" name="type" value="删除">删除
            <input type="radio" name="type" value="查找">查找
        <button type="submit">提交</button>
    </form><br>
<c:if test="${requestScope.type!=null}">
  ${requestScope.type}执行成功
</c:if>
</body>
</html>
