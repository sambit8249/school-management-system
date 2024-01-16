<%@page import="com.org.dao.PrincipleDao"%>
<%@page import="com.org.dto.Principle"%>
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
						Principle principle1 = (Principle) session.getAttribute("principleObj");
						int id = principle1.getId();
						Principle principle = new PrincipleDao().fetchPrincipleById(id);
						%>

						<p class="fs-4 text-center"><%=principle.getName()%>'s Profile </p>
						<form action="../UpdatePrinciple" method="post">

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
									type="text" value="<%=principle.getName()%>" class="form-control"
									required>
							</div>

							<div class="mb-3">
								<label class="form-label">Age</label> <input name="age"
									type="text" value="<%=principle.getAge()%>" class="form-control"
									required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile</label> <input name="mobile"
									type="text" value="<%=principle.getMobile()%>"
									class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Qualification</label> <input name="Qualification"
									type="text" value="<%=principle.getQualification()%>"
									class="form-control" required>
							</div>
							
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" value="<%=principle.getEmail()%>" type="email"
									class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" value="<%=principle.getPassword()%>"
									type="password" class="form-control" required
									readonly="readonly">
							</div>

							<input type="hidden" name="id" value="<%=principle.getId()%>">


							<button type="submit" class="btn bg-success text-white col-md-12">Update Profile</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>



</body>
</html>