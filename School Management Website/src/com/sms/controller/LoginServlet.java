package com.sms.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sms.dao.UserLoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user=request.getParameter("user");
		String password=request.getParameter("password");
		
		boolean credentialValidation=UserLoginDao.checkUserInDatabase(user, password);		
		
		
		
		if(credentialValidation)
		{
			
		
		 // Staring User-Session
		 
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
		
		//Requesting the Dispatcher	
			
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("Home.jsp");
			requestDispatcher.forward(request, response);
			
			
		}
		else
		{
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("Login.html");
			requestDispatcher.forward(request, response);
		}
		
	}

	
	
	
}
