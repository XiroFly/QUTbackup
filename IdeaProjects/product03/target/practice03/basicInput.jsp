<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h1>请输入文本框的数目和复选框中包含条目的数目</h1>
<form action="infoInput.jsp" method="get" >
姓名：<input type="text" name="name"/><br>
    性别：<input type="text" name="gender"><br>
    文本框数目：<input type="text" name="quantity1">范围：1-9<br>
    复选框包含条目数：<input type="text" name="quantity2">范围：2-9<br>
   <button type="submit">填写具体信息</button>
</form>
</body>
</html>
