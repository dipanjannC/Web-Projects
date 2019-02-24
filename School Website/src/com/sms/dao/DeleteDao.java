package com.sms.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDao {

	static Connection connect=null;
	static Statement statement=null;
	
	public static int delete(int studentId)
	{
		
		connect=DBUtil.makeConnection();
		int count=0;
		
		try {
			statement=connect.createStatement();
			count=statement.executeUpdate("delete from student_details where id='"+studentId+"'");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return count;
	}
	
}
