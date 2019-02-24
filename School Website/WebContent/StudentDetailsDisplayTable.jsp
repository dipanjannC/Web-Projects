<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.sms.pojo.StudentPojo" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Details</title>

<style>
table, th, td {

  text-align:left;
  border: 1px solid black;
  border-collapse: collapse;
}
th{
    background-color:#0375B4;
    color:#f2f2f2;
}
th, td {
  padding: 5px ;
  text-align: left;
}

tr:nth-child(odd){background-color: #e6f0ff}
</style>
</head>


<body>
<h2>Student Details</h2>


<div style="overflow-x:auto;">
<%
	ArrayList<StudentPojo> allStudents=(ArrayList<StudentPojo>) request.getAttribute("allStudents");
	Iterator<StudentPojo> itr=allStudents.iterator();
 
%>
<table style="width:100%">

<%
	while(itr.hasNext())
	{
		StudentPojo pojo=(StudentPojo)itr.next();
	
%>
  <tr>
    <th>StudentID</th>
    <th>Name</th>
    <th>Age</th>
    <th>Gender</th>
    <th>Address</th>
    <th>Country</th>
    <th>Hobbies</th>
  </tr>
  <tr>
    <td><%=pojo.getStudentId() %></td>
    <td><%=pojo.getName() %></td>
    <td><%=pojo.getAge() %></td>
    <td><%=pojo.getGender() %></td>
    <td><%=pojo.getAddress() %></td>
    <td><%=pojo.getCountry() %></td>
    <td><%=pojo.getHobbies() %></td>
  </tr>
  
  <% } %>
</table>
</div>


</body>
</html>