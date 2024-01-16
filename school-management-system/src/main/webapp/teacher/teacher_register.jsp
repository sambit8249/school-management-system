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
						<p class="fs-4 text-center">Register Teacher</p>
						<%
						String str = (String) session.getAttribute("success");
						
						if(str != null){
						%>
						<p class="fs-4 text-center text-sucess"><%=str %></p>
						<%
						session.removeAttribute("fail");
						}
						%>


						<form action="../register_teacher" method="post">
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
								<label class="form-label">Subject</label> <input name="subject"
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
								<label class="form-label">Salary</label> <input name="salary"
									type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Status</label> <input name="status"
									type="text" class="form-control" required>
							</div>

							<%
						Principle principle = (Principle)session.getAttribute("principleObj");
						%>
							<input type="hidden" name="principleId" value="<%=principle.getId()%>"> 
							<button type="submit" class="btn bg-success text-white col-md-12">Register</button>
						</form>

						<p class="fs-4">
							Already have an account ?<a href="teacher_login.jsp"
								class="text-decoration-none text-success">Login</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>



</body>
</html>