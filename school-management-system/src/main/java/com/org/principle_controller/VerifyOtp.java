package com.org.principle_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dto.Principle;

@WebServlet("/PrincipleVerifyOtp")
public class VerifyOtp extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String otp = req.getParameter("otp");

		HttpSession session = req.getSession();
		String session_otp = (String) session.getAttribute("otpObj");

		Principle Principle = (Principle) session.getAttribute("PrincipleObj");

		if (otp.equals(session_otp)) {
			session.setAttribute("success", "password updated");
			resp.sendRedirect("principle/new_password.jsp");
		} else {
			session.setAttribute("fail", "incorrect otp");
			resp.sendRedirect("principle/verify_otp.jsp");
		}

	}

}
