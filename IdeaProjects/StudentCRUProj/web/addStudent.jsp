<%--
  Created by IntelliJ IDEA.
  User: Xiro
  Date: 2023/5/6
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD</title>
</head>
<body>
<form action="addStudent" method="get">

    学生ID： <input name="id" type="text" ><br>
    姓名：<input type="text" name="name" ><br>
    性别：<input type="text" name="sex" ><br>
    专业：<input type="text" name="major" ><br>
    家乡：<input type="text" name="hometown" ><br>
    <button type="submit">添加</button>
</form>
</body>
</html>
