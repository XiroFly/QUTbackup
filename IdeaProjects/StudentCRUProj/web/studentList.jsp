<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
<c:if test="${MOS==true}"><div id="top">已成功修改一条记录</div></c:if>
<c:if test="${MOS==false}"><div id="top">修改失败</div></c:if>
<c:if test="${DOS==true}"><div id="top">已成功删除一条记录</div></c:if>
<c:if test="${DOS==false}"><div id="top">删除失败</div></c:if>
<c:if test="${AOS==true}"><div id="top">已成功添加一条记录</div></c:if>
<c:if test="${AOS==false}"><div id="top">添加失败</div></c:if>
<form name="query" action="showOneStudent" method="get">
	查询学生信息：<input name="id" type="text"> <button type="submit">查询</button>
</form>
<a href="addStudent.jsp">添加学生信息</a>
<table>
	<tr>
		<td>ID</td>
		<td>姓名</td>
		<td>性别</td>
		<td>专业</td>
		<td>家乡</td>
		<td>操作</td>
	</tr>
	<c:forEach var="student" items="${studentList}">
		<tr>
			<td>${student.id}</td>
			<td>${student.name}</td>
			<td>${student.sex}</td>
			<td>${student.major}</td>
			<td>${student.hometown}</td>
			<td><a href="findModifyStudent?id=${student.id}">修改</a>
				<a href="deleteStudent?id=${student.id}">删除</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</br>
<c:set var ="iPage" value="${param.page}" scope="page"/>
<c:if test="${empty iPage}">
	<c:set var ="iPage" value="1" scope="page"/>
</c:if>
<a href="showAllStudents?page=1">第一页</a>
<c:if test="${iPage>1}">
	<a href="showAllStudents?page=${iPage-1}">前一页</a>
</c:if>
<c:if test="${iPage<pageCount}">
	<a href="showAllStudents?page=${iPage+1}">后一页</a>
</c:if>
<a href="showAllStudents?page=${pageCount}">最后一页</a>
现在是第${iPage}页
