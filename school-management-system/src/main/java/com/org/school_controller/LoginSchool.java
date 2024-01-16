package com.org.school_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.SchoolDao;
import com.org.dto.School;

@WebServlet("/login_school")
public class LoginSchool extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		SchoolDao dao=new SchoolDao();
		List<School> schools = dao.fetchSchoolByEmailPassword(email, password);
		
		HttpSession session = req.getSession();
		
		if(!schools.isEmpty())
		{
			School school = schools.get(0);
			session.setAttribute("schoolObj", school);
			resp.sendRedirect("school/school_home.jsp");
		}
		else
		{
			session.setAttribute("fail","invalid email or password");
			resp.sendRedirect("school/school_login.jsp");
		}
	}

}
