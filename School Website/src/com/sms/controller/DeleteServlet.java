package com.sms.controller;
import com.sms.dao.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id=request.getParameter("studentId");
		int studentId=Integer.parseInt(id);
		PrintWriter out=response.getWriter();
		
		boolean checkInDatabase=DatabaseValidationsDao.checkId(studentId);
		
		if(checkInDatabase)
		{
				//Requesting the Dispatcher	
			
			//RequestDispatcher requestDispatcher=request.getRequestDispatcher("DeleteStudent.html");
			//requestDispatcher.forward(request, response);
			DeleteDao.delete(studentId);
			out.println("<h2>Student with ID: "+studentId+" deleted succesfully . </h2>");
		}
		else
		{
			//RequestDispatcher requestDispatcher=request.getRequestDispatcher("DeleteStudent.html");
			//requestDispatcher.forward(request, response);
			out.println("<h2> couldn't delete "+studentId+" succesfully as its not present. </h2>");
		}
		
		
	}


}
