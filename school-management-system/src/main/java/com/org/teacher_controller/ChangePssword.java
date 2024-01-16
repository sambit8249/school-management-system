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

@WebServlet("/ChangePassword")
public class ChangePssword extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String password = req.getParameter("password");

		TeacherDao dao = new TeacherDao();
		Teacher teacher = dao.fetchTeacherById(id);

		teacher.setPassword(password);

		dao.saveAndUpdate(teacher);

		HttpSession session = req.getSession();

		session.setAttribute("success", "password updated");

		resp.sendRedirect("teacher/update_password.jsp");

	}
}
