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

@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		long mobile = Long.parseLong(req.getParameter("mobile"));
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		
		StudentDao dao = new StudentDao();
		Student student = dao.fetchStudentById(id);
		
		student.setName(name);
		student.setAge(age);
		student.setMobile(mobile);
		student.setEmail(email);
		student.setAddress(address);
		
		dao.saveAndUpdate(student);
		
		HttpSession session = req.getSession();
		
		session.setAttribute("success", "profile updated");
		
		resp.sendRedirect("student/view_student_profile.jsp");
	}

}
