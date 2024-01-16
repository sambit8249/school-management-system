<%@page import="com.org.dto.School"%>
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
	School school = (School) session.getAttribute("schoolObj");

	if (school == null) {
		response.sendRedirect("school_login.jsp");
	} else {
	%>



	<%@ include file="../components/schoolnavbar.jsp"%>

	<!-- <p class="fs-4 text-center text-sucess">Welcome to Home</p

	<!--<img src="../img/schoolhome.png" class="d-block w-100" alt="..." height="700px"> -->
	<video controls autoplay>
		<source src="../img/schoolhome.mp4" type="video/mp4">
	</video>
	
	<%
	}
	%>
</body>
</html>
5
