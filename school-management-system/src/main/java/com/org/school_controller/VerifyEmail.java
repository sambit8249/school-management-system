package com.org.school_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.SchoolDao;
import com.org.dto.School;

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

@WebServlet("/VerifyEmail")
public class VerifyEmail extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");

		SchoolDao dao = new SchoolDao();
		List<School> schools = dao.fetchSchoolByEmail(email);

		HttpSession session = req.getSession();
		
		if (!schools.isEmpty()) {
			School school = schools.get(0);
			
			session.setAttribute("schoolObj", school);
			
			String db_email = school.getEmail();
			if (email.equals(db_email)) {

				//mail sending logic
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
					resp.sendRedirect("school/verify_otp.jsp");

				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//end of mail logic

			} else {
				session.setAttribute("fail", "invalid email");
				resp.sendRedirect("school/verify_email.jsp");
			}
		}
		else
		{
			session.setAttribute("fail", "invalid email");
			resp.sendRedirect("school/verify_email.jsp");
		}

	}
}
