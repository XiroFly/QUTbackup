<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>所有的演示例子</h1>  
<h3><a href="${pageContext.request.contextPath }/daodb">处理dao中数据库异常</a></h3>  
<h3><a href="${pageContext.request.contextPath }/daomy">处理dao中自定义异常</a></h3>  
<h3><a href="${pageContext.request.contextPath }/daono">处理dao未知错误</a></h3>  
<hr>
<h3><a href="${pageContext.request.contextPath }/servicedb">处理service中数据库异常</a></h3>  
<h3><a href="${pageContext.request.contextPath }/servicemy">处理service中自定义异常</a></h3>  
<h3><a href="${pageContext.request.contextPath }/serviceno">处理service未知错误</a></h3>  
<hr> 
<h3><a href="${pageContext.request.contextPath }/db">处理controller中数据库异常</a></h3>  
<h3><a href="${pageContext.request.contextPath }/my">处理controller中自定义异常</a></h3>  
<h3><a href="${pageContext.request.contextPath }/no">处理controller未知错误</a></h3>
<hr>
<!-- web.xml中配置404 -->
<h3><a href="${pageContext.request.contextPath }/404">404错误</a></h3>
</body>
</html>
