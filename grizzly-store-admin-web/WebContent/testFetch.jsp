<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.grizzly.pojo.ProductDetailsPojo" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Links -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
 
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<!-- Links -->

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
  hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 20px;
}
  
tr:nth-child(odd){background-color: #e6f0ff}
</style>
</head>
<div>
	<h4 align="right">
 				<!-- Button to Open Logout Modal -->
  	<button type="button" class="btn btn-info" data-toggle="modal" data-target="#logoutModal">Logout</button>
 	</h4>
 </div> 
  
<body>
<h2>Product Details</h2>

			<!-- Table -->
<div style="overflow-x:auto;">
<%
	ArrayList<ProductDetailsPojo> productsViewAdmin=(ArrayList<ProductDetailsPojo>)request.getAttribute("productsViewAdmin");
	Iterator<ProductDetailsPojo> itr=productsViewAdmin.iterator();
 
%>


<table style="width:100%">

 <tr>
    <th>Product List</th>
    <th>Brand</th>
    <th>Category</th>
    <th>Rating</th>
    <th> Delete</th>
  </tr>
<%
	while(itr.hasNext())
	{
		ProductDetailsPojo pojo=(ProductDetailsPojo)itr.next();
	
%>
 
  <tr>
    <td><%=pojo.getProductName() %></td>
    <td><%=pojo.getProductBrand() %></td>
    <td><%=pojo.getProductCategory() %></td>
    <td><%=pojo.getProductRating() %></td>
	<td><%= pojo.getProductId() %></td>
    <td><a href="DeleteServlet?productId=<%= pojo.getProductId() %>" > <i class="material-icons">highlight_off</i></a></td>
  </tr>
  
  <% } %>
</table>
</div>
			<!-- Table -->
<!--Logout Modal-->
  <div class="modal fade" id="logoutModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Logout</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <!--Update Modal-->
       	<div class="modal-body">
          <hr>
          Are you Sure?
          <br>
          <hr>
         	 <form action="Logout" method="get">
         		<input type="submit" name="logout-option" value="Yes" class="btn btn-info btn-block"/>
        		 <br>
  				
    		</form>
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>
  		<!--Logout Modal-->

  


</body>
</html>