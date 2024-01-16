package com.org.school_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.SchoolDao;
import com.org.dto.School;

@WebServlet("/register_school")
public class RegisterSchool extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		School school=new School();
		
		school.setName(name);
		school.setAddress(address);
		school.setEmail(email);
		school.setPassword(password);
		
		SchoolDao dao=new SchoolDao();
		dao.saveAndUpdate(school);
		
		HttpSession session = req.getSession();
		session.setAttribute("sucess", "Registration sucessful");
		
		resp.sendRedirect("school/school_login.jsp");
	}

}
