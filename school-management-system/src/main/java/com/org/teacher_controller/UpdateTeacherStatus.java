package com.org.teacher_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.TeacherDao;
import com.org.dto.Teacher;

@WebServlet("/update_teacher_status")
public class UpdateTeacherStatus extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		TeacherDao dao = new TeacherDao();

		Teacher teacher = dao.fetchTeacherById(id);

		String status = teacher.getStatus();

		if (status.equalsIgnoreCase("active"))
			teacher.setStatus("inactive");
		else
			teacher.setStatus("active");
		
		dao.saveAndUpdate(teacher);
		
		resp.sendRedirect("teacher/view_teacher.jsp");
		
	}
}
