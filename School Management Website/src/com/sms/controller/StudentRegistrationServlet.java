package com.sms.controller;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sms.dao.StudentRegistrationDao;
import com.sms.pojo.StudentPojo;

@WebServlet("/DBinsert")
public class StudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int count=0;
		PrintWriter out=response.getWriter();
		
		
		String name=request.getParameter("name");
		String ageString=request.getParameter("age");
		int age=Integer.parseInt(ageString);
		
		String address=request.getParameter("address");
		String gender=request.getParameter("gender");
		String country=request.getParameter("country");
		String[] hobbies=request.getParameterValues("hobby_option");
		
		
		String delimiter=":";
        String hobbyList=convertStringArrayToString(hobbies,delimiter);
		
		StudentPojo pojo=new StudentPojo();
		pojo.setName(name);
		pojo.setAge(age);
		pojo.setGender(gender);
		pojo.setAddress(address);
		pojo.setCountry(country);
		pojo.setHobbies(hobbyList);
		
		// Fetching Session Details
			
		//HttpSession session=request.getSession(false);
		//String user=(String)session.getAttribute("user");
		
		
		
		count=StudentRegistrationDao.insertToDB(pojo);
		
		
		
		if(count>0)
		{
			out.println("<h2>Login Successfully</h2>");
		}
		else
		{
			out.println("<h2>Login Unsucessful</h2>");
		}
	}
	
	
    public static String convertStringArrayToString(String[] hobbies, String delimiter) 
    {
		
    	StringBuilder sb = new StringBuilder();
		
		for (String hobby : hobbies)
			{
				sb.append(hobby).append(delimiter);
			}
		
		return sb.substring(0, sb.length()-1);
	}

	

}
