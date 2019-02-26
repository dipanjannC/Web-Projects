package com.sms.controller;
import com.sms.dao.*;
import com.sms.pojo.StudentPojo;

import java.io.IOException;

import java.util.ArrayList;

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
		
		DeleteDao.delete(studentId);
			
		ArrayList<StudentPojo> allStudents=StudentRegistrationDao.displayStudents();
			
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("StudentDetailsDisplayTable.jsp");
		request.setAttribute("allStudents", allStudents);
		requestDispatcher.forward(request, response);
		
	}


}
