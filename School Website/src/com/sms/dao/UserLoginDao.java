package com.sms.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sms.pojo.UserDetailsPojo;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dipanjan Chowdhury
 */

public class UserLoginDao {
    
    static Connection connect=null;
    static Statement statement=null;
    
    public static int insertUserDetails(UserDetailsPojo pojo)
    {
        connect=DBUtil.makeConnection();
        int countInsert=0;
        
        try {
            statement=connect.createStatement();
            countInsert=statement.executeUpdate("insert into user_StudentDetails(username,password) values('"
                    +pojo.getUsername()+"','"
                    +pojo.getPassword()
                    +")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return countInsert;
    }
    
    public static boolean checkUserInDatabase(String username,String password)
    {
    	connect=DBUtil.makeConnection();
    	ResultSet resultset;
    	
    	
    	try {
    		
    		statement=connect.createStatement();
			resultset=statement.executeQuery("select * from user_StudentDetails where (username='"+username
												+"' and password='"+password+"')");
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
