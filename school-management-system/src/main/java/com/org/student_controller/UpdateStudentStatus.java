package com.org.student_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.StudentDao;
import com.org.dao.TeacherDao;
import com.org.dto.Student;
import com.org.dto.Teacher;

@WebServlet("/update_student_status")
public class UpdateStudentStatus extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		StudentDao dao = new StudentDao();

		Student student = dao.fetchStudentById(id);

		String status = student.getStatus();

		if (status.equalsIgnoreCase("active"))
			student.setStatus("inactive");
		else
			student.setStatus("active");
		
		dao.saveAndUpdate(student);
		
		resp.sendRedirect("student/view_students.jsp");
		
	}
}
