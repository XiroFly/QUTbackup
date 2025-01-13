<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<form:form modelAttribute="student"  method="post" action="student/add">
    <fieldset>
        <legend>添加一个学生</legend>
        <p>
            <label>学号:</label>
            <form:input path="sno"/>
        </p>
        <p>
            <label>姓名:</label>
            <form:input path="sname"/>
        </p>
        <p>
            <label>性别:</label>
            <form:radiobutton path="sex" value="男"/>男
            <form:radiobutton path="sex" value="女"/>女
        </p>  
        <p>
            <label>年龄（大于或等于18）:</label>
            <form:input path="age"/>
        </p>
        <p>
            <label>院系:</label>
            <form:select path="dept"> 
                <option/>请选择院系
                <form:options items="${dept }"/>
            </form:select>
        </p>
        <p id="buttons">
            <input id="reset" type="reset">
            <input id="submit" type="submit" value="添加">
        </p>
    </fieldset>
</form:form>
</body>
</html>