<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.sms.pojo.StudentPojo" %>
<%@page import="com.sms.dao.UpdateDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
 <style>
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
 </style>
  
</head>
<body>

<%
StudentPojo pojo = (StudentPojo)request.getAttribute("student");
%>




  <!-- Modal -->
  <div class="modal fade" id="updateModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <!--Modal Header-->
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Update Form</h4>
        </div>
        <!-- Modal Header-->
        
        <div class="modal-body">
          <form action="UpdateServlet" method="get">
		
        <div>
		<label for="name" >Student ID:</label><br>
      	<input type="text" class="form-control" name="studentId" value="<%=pojo.getStudentId()%>" readonly/>
  		<br>
  		<hr>
  	  	</div>
        
        
		<div>
		<label for="name" >Name:</label><br>
      <input type="text" class="form-control" name="name" value="<%=pojo.getName() %>" />
  	<br>
  	<hr>
  	  </div>
		
		<div>
		 <label for="age">Age:</label><br> 
		 <input type="number" name="age"  value="<%=pojo.getAge() %>" readonly/>
    	<br>
    	<hr>
    	</div>	
    	
    	<div>
		 <label for="age">Gender:</label><br> 
		 <input type="number" name="gender"  value="<%=pojo.getGender() %>" readonly/>
    	<br>
    	<hr>
    	</div>		
		
		<div>
		  Address:
		   <br>
		<textarea name="address"  cols="30" value="<%=pojo.getAddress() %>" />
		<br>
		<hr> 
		</div>
		
		<div>
		Country:
		<br>
		<select name="country"  >
			<option value="India">India</option>
			<option value="USA">United State of America</option>
			<option value="UK">United Kingdom</option>
			<option value="Australia">Australia</option>
			<option value="Germany">Germany</option>
			<option value="Finland">Finland</option>
			<option value="South Africa">South Africa</option>
		</select> 
		<br>
		<hr>
		</div> 
		
		<div>
		  Hobbies:
		   <br>
			<input type="text" name="hobbies" value="<%=pojo.getHobbies() %>" readonly /> 
		<br>
		<hr> 
		</div>
		 <input type="submit" name="update" value="Update" class="btn btn-info btn-block"/>
         <br>

	</form>
         
         
        
        
  		</div>
        <!--Modal Footer-->
        
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div>

</body>
</html>
