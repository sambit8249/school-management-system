package com.org.student_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.StudentDao;
import com.org.dto.Student;

@WebServlet("/StudentNewPassword")
public class NewPassword extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String newPassword = req.getParameter("password");
		HttpSession session = req.getSession();
		Student student = (Student) session.getAttribute("studentObj");

		StudentDao dao = new StudentDao();

		student.setPassword(newPassword);

		dao.saveAndUpdate(student);

		session.setAttribute("sucess", "password updated");

		session.removeAttribute("otpObj");
		resp.sendRedirect("student/student_login.jsp");

	}

}
