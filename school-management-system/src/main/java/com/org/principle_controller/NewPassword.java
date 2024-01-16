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

@WebServlet("/PrincipleNewPassword")
public class NewPassword extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String newPassword = req.getParameter("password");
		HttpSession session = req.getSession();
		Principle principle = (Principle) session.getAttribute("principleObj");

		PrincipleDao dao = new PrincipleDao();

		principle.setPassword(newPassword);

		dao.saveAndUpdate(principle);

		session.setAttribute("sucess", "password updated");

		session.removeAttribute("otpObj");
		resp.sendRedirect("principle/principle_login.jsp");

	}

}
