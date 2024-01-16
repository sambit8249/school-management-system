
<%@page import="com.org.dto.Principle"%>
<%@page import="com.org.dao.PrincipleDao"%>
<%@page import="com.org.dao.StudentDao"%>
<%@page import="com.org.dto.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.TeacherDao"%>
<%@page import="com.org.dto.Teacher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../components/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@ include file="../components/principlenavbar.jsp"%>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Teacher Details</p>

						<table class="table">
							<thead>
								<tr>
									<th>Full Name</th>
									<th>Age</th>
									<th>Mobile</th>
									<th>Qualification</th>
									<th>Email</th>
									<td>Action</td>
								</tr>
							</thead>
							<tbody>
								<%
								PrincipleDao dao = new PrincipleDao();
								List<Principle> principle = dao.fetchAllPrinciples();
								for (Principle s : principle) {
								%>
								<tr>
									<td><%=s.getName()%></td>
									<td><%=s.getAge()%></td>
									<td><%=s.getMobile()%></td>
									<td><%=s.getQualification()%></td>
									<td><%=s.getEmail()%></td>
									<td>Action</td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
>
