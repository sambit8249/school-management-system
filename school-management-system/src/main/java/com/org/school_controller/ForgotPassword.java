package com.org.school_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.org.dao.SchoolDao;
import com.org.dto.School;
import com.org.dto.School;

@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter(getServletName());
		
		
		HttpSession session = req.getSession();		
		School school = (School) session.getAttribute("schoolObj");
		int id = school.getId();
		//School school = new SchoolDao().fetchSchoolById(id);
//		SchoolDao dao = new SchoolDao();
//		School school = dao.fetchSchoolById(id);
		System.out.println(school.getName());
	}

}
