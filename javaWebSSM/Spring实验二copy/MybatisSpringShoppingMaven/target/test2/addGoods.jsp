<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
</head>
<body>
    <form action="addGoods">
<%--        商品编号：<input type="text" name="goodsId"/> </br>--%>
        商品名称：<input type="text" name="goodsName"/> <br/>
        商品价格：<input type="text" name="price"/> <br/>
        <input type="submit" value="添加"/>
    </form>
</body>
</html>
