package com.sms.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.sms.pojo.StudentPojo;

public class UpdateDao {

	static Connection connect=null;
	static Statement statement=null;
	

	
	public static int update(int studentId,String field,String value)
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
    public static int updateStudent(StudentPojo pojo)
    {
                    int check=0;
                    try {
                                    Connection connection = DBUtil.makeConnection();
                                    Statement statement = connection.createStatement();

                                    check = statement.executeUpdate("update student_details set "
                                    								+ "student_name ='"+pojo.getName()+"',"
                                    								+ "student_age = "+pojo.getAge()+","
                                    								+ "student_address = '"+pojo.getAddress()
                                    								+"',student_hobbies = '"+pojo.getHobbies()
                                    								+"',student_gender = '"+pojo.getGender()
                                    								+"',student_country ='"+pojo.getCountry()
                                    								+"' where student_id=" +pojo.getStudentId());

                                    statement.close();

                    } catch (Exception e) {
                                    e.printStackTrace();
                    }
                    
                    return check;
    }

	
}
