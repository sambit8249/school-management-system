<%@page import="java.util.List"%>
<%@page import="com.org.dao.TeacherDao"%>
<%@page import="com.org.dto.Teacher"%>
<%@page import="com.org.dto.Principle"%>
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
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="car paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Register Student</p>


						<%
						String str = (String) session.getAttribute("sucess");
						if (str != null) {
						%>
						<p class="fs-4 text-center text-sucess"><%=str%>

							<%
							session.removeAttribute("sucess");
							}
						
							%>
							<form action="../register_student" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label> <input name="name"
									type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Age</label> <input name="age"
									type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile</label> <input name="mobile"
									type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Course</label> 
								<select name="course" class="form-control">
								<%
								TeacherDao dao = new TeacherDao();
								List<Teacher> list = dao.fetchAllTeachers();

								for (Teacher t : list) {
								%>
							<option value="<%=t.getId()%>"><%=t.getSubject()%>
								<%
								}
								%>
								<!--
								<option value ="1">java</option>
								<option value ="2">python</option>
								<option value ="3">framework</option>
								<option value ="4">sql</option>
								--> </select>
						
								
							</div>
							<div class="mb-3">
								<label class="form-label">Marks</label> <input name="marks"
									type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Address</label> <input name="address"
									type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" type="password" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Status</label> <input name="status"
									type="text" class="form-control" required>
							</div>
							<%
							Principle p = (Principle) session.getAttribute("principleObj");
							%>
							<input type="hidden" name="principleId" value="<%=p.getId()%>">
							<button type="submit" class="btn bg-success text-white col-md-12">Register</button>
						</form>

						<p class="fs-4">
							Already have an account ?<a href="student_login.jsp"
								class="text-decoration-none text-success">Login</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>



</body>
</html>