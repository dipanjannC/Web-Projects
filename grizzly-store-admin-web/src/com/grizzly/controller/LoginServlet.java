package com.grizzly.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.grizzly.dao.DatabaseValidationDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		int failedLoginAttempts=0;
		
		PrintWriter out=response.getWriter();
		boolean credentialValidation=DatabaseValidationDao.checkUserInDatabase(username, password);		
		System.out.println(username);
		System.out.println(password);
		System.out.println(credentialValidation);
		
		
		
		if(credentialValidation)
		{
			
		
		 // Staring User-Session
		 
			HttpSession session=request.getSession();
			session.setAttribute("username", username);
			
			
			
			//Requesting the Dispatcher	
			
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("FetchServlet");
			requestDispatcher.forward(request, response);
			
			
		}
		else
		{
			//out.println("<h2>Login Failed<h2>");
			failedLoginAttempts++;
			System.out.println(failedLoginAttempts);
			
			if(failedLoginAttempts<3)
			{
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("Login.html");
				requestDispatcher.forward(request, response);
			}
			else
			{
				out.println("<h2>Your account is locked.<h2>");
			}
		}
		
	}

}
