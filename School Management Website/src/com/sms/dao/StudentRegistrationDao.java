package com.sms.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sms.pojo.StudentPojo;

public class StudentRegistrationDao {

	static Connection connect=null;
	static Statement statement=null;
	
	
	
	public static int insertToDB(StudentPojo pojo)
	{
		connect=DBUtil.makeConnection();
		int countInsert=0;
		try {
			statement=connect.createStatement();
			countInsert=statement.executeUpdate("insert into student_details(name,age,gender,address,country,hobbies) values ('"
										+pojo.getName()+"','"
										+pojo.getAge()+"','"
										+pojo.getGender()+"','"
										+pojo.getAddress()+"','"
										+pojo.getCountry()+"','"
										+pojo.getHobbies()+"'"
										+")");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countInsert;	
	}
	
	public static ArrayList<StudentPojo> displayStudents()
	{
		
		connect=DBUtil.makeConnection();
		ResultSet resultset;
		
		ArrayList<StudentPojo> allStudents=new ArrayList<StudentPojo>(); 
		
		try {
			statement=connect.createStatement();
			resultset=statement.executeQuery("Select * from student_details");
			
			while(resultset.next())
			{
							
				int studentId = resultset.getInt(1);
				
				StudentPojo pojo = new StudentPojo();
				pojo.setStudentId(studentId);
				
				String name = resultset.getString(2);
				int age = resultset.getInt(3);
				String gender = resultset.getString(4);
				String address=resultset.getString(5);
				String country=resultset.getString(6);
				String hobbies=resultset.getString(7);
				
				pojo.setName(name);
				pojo.setAge(age);
				pojo.setGender(gender);
				pojo.setAddress(address);
				pojo.setCountry(country);
				pojo.setHobbies(hobbies);
				
				allStudents.add(pojo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return	allStudents;	
	}
	
	public static StudentPojo displayStudent(int id) {
        Connection connection = DBUtil.makeConnection();
        Statement statement = null;
        StudentPojo pojo = null;
        
        try {
                        statement = connection.createStatement();

                        ResultSet resultset = statement.executeQuery("Select * from student_details where student_id = "+id);

                                        pojo.setName(resultset.getString(2));
                                        pojo.setAge(resultset.getInt(3));
                                        pojo.setGender(resultset.getString(4));
                                        pojo.setAddress(resultset.getString(5));
                                        pojo.setCountry(resultset.getString(6));
                                        pojo.setHobbies(resultset.getString(7));
                        

                        resultset.close();
                        statement.close();
                        
        } catch (SQLException e) {
                        e.printStackTrace();
        }
        
        return pojo;
}

}
