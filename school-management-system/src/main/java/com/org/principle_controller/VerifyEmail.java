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


import java.util.Properties;
import java.util.Random;

import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@WebServlet("/PrincipleVerifyEmail")
public class VerifyEmail extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");

		PrincipleDao dao = new PrincipleDao();
		List<Principle> principles = dao.fetchPrincipleByEmail(email);

		HttpSession session = req.getSession();

		if (!principles.isEmpty()) {
			Principle principle = principles.get(0);

			session.setAttribute("principleObj", principle);

			String db_email = principle.getEmail();
			if (email.equals(db_email)) {

				// mail sending logic
				Properties properties = System.getProperties();

				// step 1
				properties.setProperty("mail.smtp.host", "smtp.gmail.com");
				properties.setProperty("mail.smtp.port", "465");
				properties.setProperty("mail.smtp.ssl.enable", "true");
				properties.setProperty("mail.smtp.auth", "true");

				// step 2
				Session session2 = Session.getInstance(properties, new Authenticator() {

					@Override
					protected PasswordAuthentication getPasswordAuthentication() {

						return new PasswordAuthentication("abcxyz9r@gmail.com", "usaa iqbz dcpo rnsj");
					}
				});

				session2.setDebug(true);

				MimeMessage message = new MimeMessage(session2);
				try {
					message.setFrom("abcxyz9r@gmail.com");

					message.addRecipient(Message.RecipientType.TO,
							new InternetAddress("sambitsahoobabu6640@gmail.com"));

					message.setSubject("Otp verification");

					Random rd = new Random();
					String otp = "" + rd.nextInt(9) + rd.nextInt(9) + rd.nextInt(9) + rd.nextInt(9);

					message.setText(otp);

					Transport.send(message);

					System.out.println("message sent");

					session.setAttribute("otpObj", otp);
					resp.sendRedirect("principle/verify_otp.jsp");

				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// end of mail logic

			} else {
				session.setAttribute("fail", "invalid email");
				resp.sendRedirect("principle/verify_email.jsp");
			}
		}
		else
		{
			session.setAttribute("fail", "invalid email");
			resp.sendRedirect("principle/verify_email.jsp");
		}

	}
}
