package com.org.principle_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dto.Principle;

@WebServlet("/PrincipleChangePassword")
public class ChangePassword extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password = req.getParameter("password");

		HttpSession session = req.getSession();
		
		Principle principle = (Principle) session.getAttribute("principleObj");
		String dbPpassword = principle.getPassword();
		
		if (password.equals(dbPpassword))
		{
			resp.sendRedirect("principle/new_password.jsp");
		}
		else
		{
			session.setAttribute("fail", "incorrect password");
			resp.sendRedirect("principle/principle_home.jsp");
		}
	}
}
