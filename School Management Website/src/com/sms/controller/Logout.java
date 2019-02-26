package com.sms.controller;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String optionLogout=request.getParameter("logout-option");
		System.out.println(optionLogout);
		
		if(optionLogout.equals("Yes"))
		{
		HttpSession session=request.getSession(false);
		session.invalidate();
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("Login.html");
		requestDispatcher.forward(request,response);
		}
		else
		{
			
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("Home.jsp");
			requestDispatcher.forward(request,response);
		}
	}

	

}
