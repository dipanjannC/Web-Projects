package com.sms.controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sms.dao.DatabaseValidationsDao;
import com.sms.dao.StudentRegistrationDao;
import com.sms.dao.UpdateDao;
import com.sms.pojo.StudentPojo;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        if(request.getParameter("fetch")!=null)
        {
                        StudentPojo pojo=StudentRegistrationDao.displayStudent(Integer.parseInt(request.getParameter("studentId")));
                        RequestDispatcher requestDispatcher=request.getRequestDispatcher("UpdateForm.jsp");
                        request.setAttribute("student", pojo);
                        requestDispatcher.forward(request, response);
        }
        else

        {
            StudentPojo pojo = new StudentPojo();
        
            int studentId=Integer.parseInt(request.getParameter("stduentId"));
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String gender = request.getParameter("gender");
            String address = request.getParameter("address");
            String country = request.getParameter("country");
            String hobbies = request.getParameter("hobbies");
            
            System.out.println(studentId);
            System.out.println(country);
            
            pojo.setStudentId(studentId);
            pojo.setName(name);
            pojo.setAge(age);
            pojo.setGender(gender);
            pojo.setAddress(address);
            pojo.setCountry(country);
            pojo.setHobbies(hobbies);
            
             int check = UpdateDao.updateStudent(pojo);
            
        	ArrayList<StudentPojo> allStudents=StudentRegistrationDao.displayStudents();
    		
    		RequestDispatcher requestDispatcher=request.getRequestDispatcher("StudentDetailsDisplayTable.jsp");
    		request.setAttribute("allStudents", allStudents);
    		requestDispatcher.forward(request, response);
    		
    		
        }
	}

	

}
