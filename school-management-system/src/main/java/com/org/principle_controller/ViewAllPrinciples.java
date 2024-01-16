package com.org.principle_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.PrincipleDao;
import com.org.dto.Principle;


public class ViewAllPrinciples extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrincipleDao dao = new PrincipleDao();
		
		java.util.List<Principle> p= dao.fetchAllPrinciples();
		
		
	}

}
