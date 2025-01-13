<%--
  Created by IntelliJ IDEA.
  User: Xiro
  Date: 2023/5/6
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Modification</title>

</head>
<body>
<form method="get" action="modifyStudent">
    <c:set var="item" scope="page" value="${requestScope.student}"/>
    学生ID:${item.id}<br>
    <input name="id" type="hidden" value="${item.id}">
    姓名：<input type="text" name="name" value="${item.name}"><br>
    性别：<input type="text" name="sex" value="${item.sex}"><br>
    专业：<input type="text" name="major" value="${item.major}"><br>
    家乡：<input type="text" name="hometown" value=" ${item.hometown}"><br>
    <button type="submit">修改</button>
</form>
</body>
</html>
