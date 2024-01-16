package com.org.student_controller;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.org.dao.StudentDao;
import com.org.dto.Student;


@WebServlet("/login_student")
public class LoginStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		StudentDao dao = new StudentDao();
		List<Student> students= dao.fetchStudentByEmailPassword(email, password);

		HttpSession session = req.getSession();

		if (!students.isEmpty()) {
			Student student = students.get(0);
			session.setAttribute("studentObj", student);
			resp.sendRedirect("student/student_home.jsp");

		} else {
			session.setAttribute("fail", "invalid email or password");
			resp.sendRedirect("student/student_login.jsp");
		}
	}

}
