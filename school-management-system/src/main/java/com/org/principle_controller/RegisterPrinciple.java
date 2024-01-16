package com.org.principle_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.PrincipleDao;
import com.org.dao.SchoolDao;
import com.org.dto.Principle;
import com.org.dto.School;

@WebServlet("/register_principle")
public class RegisterPrinciple extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		long mobile = Long.parseLong(req.getParameter("mobile"));
		String qualification = req.getParameter("qualification");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		int sch = Integer.parseInt(req.getParameter("schoolId"));
        
		Principle principle = new Principle();
		principle.setName(name);
		principle.setAge(age);
		principle.setMobile(mobile);
		principle.setQualification(qualification);
		principle.setEmail(email);
		principle.setPassword(password);
		
		SchoolDao dao = new SchoolDao();
		School school = new School();
		
		principle.setSchool(school);
		school.setPrinciple(principle);
		
		PrincipleDao daoPrinciple = new PrincipleDao();
		
		daoPrinciple.saveAndUpdate(principle);
		
		resp.sendRedirect("principle/principle_login.jsp");
		
	}

}
