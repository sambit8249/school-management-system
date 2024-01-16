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
						Teacher teacher1 = (Teacher) session.getAttribute("teacherObj");
						int id =teacher1.getId();
						Teacher teacher = new TeacherDao().fetchTeacherById(id);
						%>

						<p class="fs-4 text-center"><%=teacher.getName()%>'s Profile </p>
						<form action="../ChangePassword" method="post">

							<%
							String str = (String) session.getAttribute("success");

							if (str != null) {
							%>
							<p class="fs-4 text-center text-sucess"><%=str%></p>
							<%
							session.removeAttribute("fail");
							}
							%>

							<input type="hidden" name="status" value="<%=teacher.getStatus()%>">
							<input type="hidden" name="id" value="<%=teacher.getId()%>">
							<input type="hidden" name="name" value="<%=teacher.getName()%>">
							<input type="hidden" name="email" value="<%=teacher.getEmail()%>">
							<input type="hidden" name="mobile" value="<%=teacher.getMobile()%>">
							<input type="hidden" name="subject" value="<%=teacher.getSubject()%>">
							<input type="hidden" name="status" value="<%=teacher.getStatus()%>">
							<input type="hidden" name="salary" value="<%=teacher.getSalary()%>">
							
							
    						<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" 
									type="password" class="form-control" required>
							</div>
							


							<button type="submit" class="btn bg-success text-white col-md-12">Update Password</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>



</body>
</html>