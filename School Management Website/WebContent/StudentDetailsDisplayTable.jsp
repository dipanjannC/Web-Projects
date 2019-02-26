<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.sms.pojo.StudentPojo" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
 
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
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
  
  /*FORM CSS */
  textDecoration {
  text-decoration: none;
}
option {
  	background: #f1f1f1;
    display: block;
    float: left;
    padding: 1rem;
    position: relative;
   	transition-duration: 0.5s;
}
nav {
    font-family: monospace;
}


input[type=text], input[type=password],
input[type=number],
textarea{
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus,input[type=password]:focus,
input[type=number]:focus,
textarea:focus{
  background-color: #ddd;
  outline: none;
}
select{
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 20px;
}

.loginbtn {
  background-color: #00cccc;
  color: white;
  padding: 16px 20px;
  margin: 3px 0;
  border: none;
  cursor:pointer;
  width: 100%;
  opacity: 0.8;
}
.loginbtn:hover
{
	opacity:1;
}
.registerbtn {
  background-color: #ff1a1a;
  color: white;
  padding: 16px 20px;
  margin: 3px 0;
  border: none;
  cursor:pointer;
  width: 100%;
  opacity: 0.8;
}
.registerbtn:hover
{
	opacity:1;
} 
  /*FORM CSS*/


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

 <tr>
    <th>StudentID</th>
    <th>Name</th>
    <th>Age</th>
    <th>Gender</th>
    <th>Address</th>
    <th>Country</th>
    <th>Hobbies</th>
    <th> Edit </th>
    <th> Delete</th>
  </tr>
<%
	while(itr.hasNext())
	{
		StudentPojo pojo=(StudentPojo)itr.next();
	
%>
 
  <tr>
    <td><%=pojo.getStudentId() %></td>
    <td><%=pojo.getName() %></td>
    <td><%=pojo.getAge() %></td>
    <td><%=pojo.getGender() %></td>
    <td><%=pojo.getAddress() %></td>
    <td><%=pojo.getCountry() %></td>
    <td><%=pojo.getHobbies() %></td>
    <td><a data-toggle="modal" href="UpdateServlet?fetch=ture&studentId=<%= pojo.getStudentId() %>"><i class="material-icons">mode_edit</i></a></a></td>
    <td><a href="DeleteServlet?studentId=<%= pojo.getStudentId() %>" > <i class="material-icons">highlight_off</i></a></td>
  </tr>
  
  <% } %>
</table>
</div>



  


</body>
</html>