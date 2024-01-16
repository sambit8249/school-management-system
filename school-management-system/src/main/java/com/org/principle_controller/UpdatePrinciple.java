package com.org.principle_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.PrincipleDao;
import com.org.dto.Principle;

@WebServlet("/UpdatePrinciple")
public class UpdatePrinciple extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		long mobile = Long.parseLong(req.getParameter("mobile"));
		String qualification = req.getParameter("Qualification");
		String email = req.getParameter("email");
		
		PrincipleDao dao = new PrincipleDao();
		Principle principle = dao.fetchPrincipleById(id);
		
		principle.setName(name);
		principle.setAge(age);
		principle.setMobile(mobile);
		principle.setEmail(email);
		principle.setQualification(qualification);
		
		dao.saveAndUpdate(principle);
		
		HttpSession session = req.getSession();
		
		session.setAttribute("success", "profile updated");
		
		resp.sendRedirect("principle/view_principle_profile.jsp");
	}

}
