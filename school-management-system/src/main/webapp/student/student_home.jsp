<%@page import="com.org.dto.Student"%>
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
	<%
	Student student = (Student) session.getAttribute("studentObj");

	if (student == null) {
		response.sendRedirect("student_login.jsp");
	} else {
	%>

	<%@ include file="../components/studentnavbar.jsp"%>

	<p class="fs-4 text-center text-sucess">Welcome to Home</p>
	<img src="../img/student_home.jpg" class="d-block w-100" alt="..."
		height="700px">
	<%
	}
	%>
	
</body>
</html>