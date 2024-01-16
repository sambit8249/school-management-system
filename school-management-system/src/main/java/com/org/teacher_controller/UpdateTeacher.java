package com.org.teacher_controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.org.dao.TeacherDao;
import com.org.dto.Teacher;

@WebServlet("/UpdateTeacher")
public class UpdateTeacher extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		long mobile = Long.parseLong(req.getParameter("mobile"));
		String email = req.getParameter("email");
		
		TeacherDao dao = new TeacherDao();
		Teacher teacher = dao.fetchTeacherById(id);
		
		teacher.setName(name);
		teacher.setAge(age);
		teacher.setMobile(mobile);
		teacher.setEmail(email);
		
		dao.saveAndUpdate(teacher);
		
		HttpSession session = req.getSession();
		
		session.setAttribute("success", "profile updated");
		
		resp.sendRedirect("teacher/view_teacher_profile.jsp");
	}

}
