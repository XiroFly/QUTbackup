<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.lang.Integer" %>
<html>
<head>
    <title>inner</title>
</head>
<body>

<h3>用户${param.name}
    <c:if test="${param['gender'].equals('男')}">
        先生
    </c:if>
    <c:if test="${param['gender'].equals('女')}">
        女士
    </c:if>
    您好！</h3>
<form method="get" action="/practice03_war/translateServlet">
<c:set var="quantity" value="${param.quantity1}"/>
<c:forEach begin="1" end="${Integer.parseInt(quantity)}" var="i" step="1">
    文本框${i}标题：<input type="text" name="text${i}"><br>
</c:forEach>
复选框标题：<input type="text" name="check"><br>
<c:forEach begin="1" end="${Integer.parseInt(param.quantity2)}" var="i">
    复选框${i}value值：<input type="text" name="value${i}">
    复选框文本${i}:<input type="text" name="check${i}"><br>
</c:forEach>
<button type="submit">生成英文界面</button>
</form>
</body>
</html>
