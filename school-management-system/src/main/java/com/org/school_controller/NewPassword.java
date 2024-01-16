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

@WebServlet("/NewPassword")
public class NewPassword extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String newPassword = req.getParameter("password");
		HttpSession session = req.getSession();
		School school = (School) session.getAttribute("schoolObj");
		
		SchoolDao dao = new SchoolDao();
		school.setPassword(newPassword);

		dao.saveAndUpdate(school);

		session.setAttribute("sucess", "password updated");
		
		session.removeAttribute("otpObj");

		resp.sendRedirect("school/school_login.jsp");

	}

}
