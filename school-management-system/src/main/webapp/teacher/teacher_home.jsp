<%@page import="com.org.dto.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../components/allcss.jsp"%>
</head>
<body>
	<p class="fs-4 text-center text-sucess">Welcome to Home</p>
	<%
	Teacher teacher = (Teacher) session.getAttribute("teacherObj");
	String status = teacher.getStatus();

	if (teacher == null) 
		response.sendRedirect("teacher/teacher_login.jsp");
	
	if (status.equalsIgnoreCase("inactive")) {
		response.sendRedirect("../components/blocked.jsp");
	} else {
	%>

	<%@ include file="../components/teachernavbar.jsp"%>
	<%
	}
	%>


	<img src="../img/teacherhome.jpg" class="d-block w-100" alt="..."
		height="700px">
</body>
</html>