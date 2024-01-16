package com.org.student_controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.PrincipleDao;
import com.org.dao.StudentDao;
import com.org.dao.TeacherDao;
import com.org.dto.Principle;
import com.org.dto.Student;
import com.org.dto.Teacher;

@WebServlet("/register_student")
public class RegisterStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		long mobile = Long.parseLong(req.getParameter("mobile"));
		String cource = req.getParameter("course");
		int mark = Integer.parseInt(req.getParameter("marks"));
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String status = req.getParameter("status");
        
		int teacherId = Integer.parseInt(req.getParameter("course"));
		int principleId = Integer.parseInt(req.getParameter("principleId"));
		
		
		Principle principle = new PrincipleDao().fetchPrincipleById(principleId);
		
		Teacher teacher = new TeacherDao().fetchTeacherById(teacherId);
		
		Student student = new Student();
		student.setName(name);
		student.setAge(age);
		student.setMobile(mobile);
		student.setMarks(mark);
		student.setAddress(address);
		student.setEmail(email);
		student.setCourse(teacher.getSubject());;
		student.setPassword(password);
		student.setStatus(status);
		student.setPrinciple(principle);
		student.setTeacher(teacher);
		
		List <Student> list = new ArrayList<>();
		list.add(student);
		
		principle.setStudents(list);
		teacher.setStudents(list);
		
		StudentDao dao = new StudentDao();
		dao.saveAndUpdate(student);
		
		HttpSession session = req.getSession();
		session.setAttribute("sucess", "Registration sucessful");
		
		resp.sendRedirect("student/student_register.jsp");
	}

}
