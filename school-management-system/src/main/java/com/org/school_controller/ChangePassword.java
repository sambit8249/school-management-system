package com.org.school_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dto.School;

@WebServlet("/SchoolChangePassword")
public class ChangePassword extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password = req.getParameter("password");

		HttpSession session = req.getSession();
		
		School school = (School) session.getAttribute("schoolObj");
		String dbPpassword = school.getPassword();
		
		if (password.equals(dbPpassword))
		{
			resp.sendRedirect("school/new_password.jsp");
		}
		else
		{
			session.setAttribute("fail", "incorrect password");
			resp.sendRedirect("school/school_home.jsp");
		}
	}
}
