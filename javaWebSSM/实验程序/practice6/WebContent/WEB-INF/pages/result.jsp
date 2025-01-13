<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%  
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>学生列表</h1>
    <a href="<c:url value="student/toAdd"/>">继续添加</a>
    <table>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>院系</th>
        </tr>
        <c:forEach items="${allStus}" var="stu">
            <tr>
                <td>${stu.sno }</td>
                <td>${stu.sname }</td>
                <td>${stu.sex }</td>
                <td>${stu.age }</td>
                <td>${stu.dept }</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>