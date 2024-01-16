<%@page import="com.org.dao.StudentDao"%>
<%@page import="com.org.dto.Student"%>
<%@page import="com.org.dto.Principle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
						<%
						Student student1 = (Student) session.getAttribute("studentObj");
						int id = student1.getId();
						Student student = new StudentDao().fetchStudentById(id);
						%>

						<p class="fs-4 text-center"><%=student.getName()%>'s Profile </p>
						<form action="../UpdateStudent" method="post">

							<%
							String str = (String) session.getAttribute("success");

							if (str != null) {
							%>
							<p class="fs-4 text-center text-sucess"><%=str%></p>
							<%
							session.removeAttribute("fail");
							}
							%>

                             <div class="mb-3">
								<label class="form-label">Name</label> <input name="name"
									type="text" value="<%=student.getName()%>" class="form-control"
									required>
							</div>

							<div class="mb-3">
								<label class="form-label">Age</label> <input name="age"
									type="text" value="<%=student.getAge()%>" class="form-control"
									required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile</label> <input name="mobile"
									type="text" value="<%=student.getMobile()%>"
									class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Course</label> <input name="course"
									type="text" value="<%=student.getCourse()%>"
									class="form-control" required readonly="readonly">
							</div>
							<div class="mb-3">
								<label class="form-label">Marks</label> <input name="marks"
									type="text" value="<%=student.getMarks()%>"
									class="form-control" required readonly="readonly">
							</div>
							<div class="mb-3">
								<label class="form-label">Address</label> <input name="address"
									type="text" value="<%=student.getAddress()%>"
									class="form-control" required >
							</div>
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" value="<%=student.getEmail()%>" type="email"
									class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" value="<%=student.getPassword()%>"
									type="password" class="form-control" required
									readonly="readonly">
							</div>

							<input type="hidden" name="status" value="<%=student.getStatus()%>">
							<input type="hidden" name="id" value="<%=student.getId()%>">


							<button type="submit" class="btn bg-success text-white col-md-12">Update Profile</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>



</body>
</html>