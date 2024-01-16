package com.org.principle_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.org.dao.PrincipleDao;
import com.org.dto.Principle;

@WebServlet("/login_principle")
public class LoginPrinciple extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		PrincipleDao dao = new PrincipleDao();
		List<Principle> principles = dao.fetchPrincipleByEmailPassword(email, password);

		HttpSession session = req.getSession();

		if (!principles.isEmpty()) {
			Principle principle = principles.get(0);
			session.setAttribute("principleObj", principle);
			resp.sendRedirect("principle/principle_home.jsp");
			
		} else {
			session.setAttribute("fail", "invalid email or password");
			resp.sendRedirect("principle/principle_login.jsp");
		}
	}
}
