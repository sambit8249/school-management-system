
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
									<th>Email</th>
									<th>Mobile</th>
									<th>Status</th>
									<th>salary</th>
									<th>subject</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								TeacherDao dao = new TeacherDao();
								List<Teacher> teachers = dao.fetchAllTeachers();
								for (Teacher t : teachers) {
								%>
								<tr>
								<td><%=t.getName() %></td>
								<td><%=t.getAge() %></td>
								<td><%=t.getEmail() %></td>
								<td><%=t.getMobile() %></td>
								
								<td>
								<% String status = t.getStatus();
								if(status.equalsIgnoreCase("active"))
								{
								%>
								<a class ="btn btn-sm btn-danger" href="../update_teacher_status?id=<%=t.getId()%>"><i class="fa-solid fa-ban"></i>Block</a>
								<%}
								else{
								%>
								<a class ="btn btn-sm btn-success" href="../update_teacher_status?id=<%=t.getId()%>"><i class="fa-solid fa-key"></i>Unblock</a>
								<%}
								
								%>
								</td>
								
								<td><%=t.getSalary() %></td>
								<td><%=t.getSubject() %></td>
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