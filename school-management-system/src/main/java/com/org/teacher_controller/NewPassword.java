package com.org.teacher_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.TeacherDao;
import com.org.dto.Teacher;

@WebServlet("/TeacherNewPassword")
public class NewPassword extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String newPassword = req.getParameter("password");
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacherObj");

		TeacherDao dao = new TeacherDao();

		teacher.setPassword(newPassword);

		dao.saveAndUpdate(teacher);

		session.setAttribute("sucess", "password updated");

		session.removeAttribute("otpObj");
		resp.sendRedirect("teacher/teacher_login.jsp");

	}

}
