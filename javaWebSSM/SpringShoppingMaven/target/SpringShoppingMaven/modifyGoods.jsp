<%--
  Created by IntelliJ IDEA.
  User: zhouw
  Date: 2020/4/9
  Time: 6:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改商品</title>
</head>
<body>
    <form action="modifyGoods">
        商品编号：${modifiedGoods.goodsId} <br/>
        <input type="hidden" name="goodsId" value="${modifiedGoods.goodsId} "/>
        商品名称：<input type="text" name="goodsName" value="${modifiedGoods.goodsName}"/> <br/>
        商品价格：<input type="text" name="price" value="${modifiedGoods.price}" /><br/>
        <input type="submit" value="修改"/>
    </form>
</body>
</html>
