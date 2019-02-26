package com.sms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseValidationsDao {
	
	static Connection connect=null;
	static Statement statement=null;
	
	public static boolean checkId(int studentId)
	{
		connect=DBUtil.makeConnection();
		ResultSet resultset;
		
		try {
			statement=connect.createStatement();
			resultset=statement.executeQuery("select * from student_details where id='"+studentId+"'");
			
			if(resultset.next())
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean checkFields(String field)
	{
		//Making the Connection and Initialization
		connect=DBUtil.makeConnection();
		ResultSet resultset;
		ArrayList<String> columnNames=new ArrayList<String>();
		
		//enclosing the string in quotation to make it work dynamically
		// field ->"field"
		String fieldUnderQuotes;
		char quote='"';
		fieldUnderQuotes=new StringBuilder().append(quote).append(field).append(quote).toString();
		
		try {
			//Initializing Variables
			int i=1;
			
			//Executing the Query Statement
			statement=connect.createStatement();
			resultset=statement.executeQuery("SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = N'student_details'");
			
			//Adding ResultSet Objects to ArrayList
			while(resultset.next())
			{
				columnNames.add(resultset.getString(i));
				i++;
			}
			
			//checking fields
			if(columnNames.contains(fieldUnderQuotes))
			{
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	
/*
 * For Extra Parameters
 * 	
	public static boolean checkRollNumber(int rollNumber)
	{
		connect=DBUtil.makeConnection();
		ResultSet resultset;
		
		try {
			statement=connect.createStatement();
			resultset=statement.executeQuery("select * from student_details where id='"+rollNumber+"'");
			
			if(resultset.next())
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
*/
}
