<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="translator" scope="session" class="javaBean.TranslatorBean"></jsp:useBean>
<%@ page import="java.lang.Integer" %>
<body>
<h3>以下是生成的界面</h3>
<c:forEach var="i" items="${param}">
<c:if test="${i.key.matches('text[1-9]')}">
    <jsp:setProperty name="translator" property="chineseWord"  value="${i.value}"></jsp:setProperty>
     <jsp:getProperty name="translator" property="englishWord"/>:<input type="text" name="${i.key}"/><br>
</c:if>
</c:forEach>
<jsp:setProperty name="translator" property="chineseWord"  param="check"/>
<jsp:getProperty name="translator" property="englishWord"/>
<c:forEach var="i" items="${param}">
<c:if test="${i.key.matches('check[1-9]')}">
    <jsp:setProperty name="translator" property="chineseWord"  value= "${i.value}"/>
    <jsp:getProperty name="translator" property="englishWord"/>:<input type="checkbox" name="checkBox" value="${param.get("value".concat(i.key.substring(5)))}"  >
</c:if>
</c:forEach>

