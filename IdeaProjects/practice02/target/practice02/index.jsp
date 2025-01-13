<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="database" class="Javabean.DatabaseJavabean" scope="session"/>
<%String Path;%>
<%
    String path = request.getContextPath();
    Path = (request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"+"AddOrDelServlet");
%>
<html>
<script>
    function clickLink(mode,index){
        var xmlHttpRequest;
        if(window.XMLHttpRequest){xmlHttpRequest=new XMLHttpRequest();}
        var Path="<%=Path%>" ;
        xmlHttpRequest.open('GET',Path+"?mode="+mode+"&index="+index);
        xmlHttpRequest.send();
        xmlHttpRequest.onreadystatechange=function () {
            if(this.readyState==4&&this.status==200){
                document.getElementById("bottom").innerHTML=xmlHttpRequest.responseText;
            }
        }
    }

</script>
<body>
<% for(Map.Entry<String, String> i : database.getDataBase().entrySet()){
%>
<div style="display: inline-block;">
    <%= i.getValue()%>
</div>
<a href="#" onclick="clickLink(1,<%=i.getKey()%>)">添加</a>
<a href="#" onclick="clickLink(2,<%=i.getKey()%>)">删除</a>
<br>
<%
    }
%>
<div id="bottom">
</div>
</body>

</html>