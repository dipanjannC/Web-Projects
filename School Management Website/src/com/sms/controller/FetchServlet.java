package com.sms.controller;


import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sms.dao.StudentRegistrationDao;
import com.sms.pojo.StudentPojo;

/**
 * Servlet implementation class FetchServlet
 */
@WebServlet("/FetchServlet")
public class FetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<StudentPojo> allStudents=StudentRegistrationDao.displayStudents();
		
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("StudentDetailsDisplayTable.jsp");
		request.setAttribute("allStudents", allStudents);
		requestDispatcher.forward(request, response);
		
		
	}
	
	

	

}
