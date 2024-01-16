<%@page import="com.org.dto.Principle"%>
<%@page import="com.org.dto.Principle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../components/allcss.jsp"%>
</head>
<body>
	<%
	Principle principle = (Principle) session.getAttribute("principleObj");

	if (principle == null) {
		response.sendRedirect("principle_login.jsp");
	} else {
	%>


	<%@ include file="../components/principlenavbar.jsp"%>

	<p class="fs-4 text-center text-sucess">Welcome to Home</p>

	<img src="../img/principal_home.jpg" class="d-block w-100" alt="..."
		height="700px">

	<%
	}
	%>
</body>
</html>