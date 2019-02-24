package com.sms.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDao {

	static Connection connect=null;
	static Statement statement=null;
	
	public static int updateName(String studentId,String value)
	{
		
		connect=DBUtil.makeConnection();
		int count=0;
		
		try {
			statement=connect.createStatement();
			count=statement.executeUpdate("update student_details set name = '"+value+"' where id='"+studentId+"'");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return count;
	}
	
	public static int update(String field,String studentId,String value)
	{
		
		connect=DBUtil.makeConnection();
		int count=0;
		
		try {
			statement=connect.createStatement();
			count=statement.executeUpdate("update student_details set "+ field+" = '"+value+"' where id='"+studentId+"'");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return count;
	}
	
}
