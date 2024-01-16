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

@WebServlet("/change_password")
public class UpdatePassword extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
       
		HttpSession session = req.getSession();
		Teacher teacher1 = (Teacher) session.getAttribute("teacherObj");
		int id =teacher1.getId();
		Teacher teacher = new TeacherDao().fetchTeacherById(id);
		
		String d_email = teacher.getEmail();
		String d_pass=teacher.getPassword();
		
		if(email.equals(d_email) && password.equals(d_pass))
		{
			resp.sendRedirect("teacher/update_password.jsp");
		}
		else
		{
			resp.sendRedirect("teacher/change_password.jsp");
		}
		

	}

}
