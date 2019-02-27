package com.grizzly.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseValidationDao {

	static Connection connect=null;
	static Statement statement=null;
	
	public static boolean checkUserInDatabase(String username,String password)
    {
    	connect=DBUtil.makeConnection();
    	ResultSet resultset;
    	
    	
    	try {
    		
    		statement=connect.createStatement();
			resultset=statement.executeQuery("select * from user_details where "
													+ "(user_name='"+username
													+"' and user_password='"+password+"')");
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
}
