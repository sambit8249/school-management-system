package com.org.teacher_controller;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.org.dao.TeacherDao;
import com.org.dto.Teacher;

@WebServlet("/login_teacher")
public class LoginTeacher extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		TeacherDao dao = new TeacherDao();
		List<Teacher> teachers = dao.fetchTeacherByEmailPassword(email, password);

		HttpSession session = req.getSession();

		if (!teachers.isEmpty()) {
			Teacher teacher = teachers.get(0);
			session.setAttribute("teacherObj", teacher);
			resp.sendRedirect("teacher/teacher_home.jsp");

		} else {
			session.setAttribute("fail", "invalid email or password");
			resp.sendRedirect("teacher/teacher_login.jsp");
		}
	}

}
