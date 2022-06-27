<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" type="text/css"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<%@page import="java.util.ArrayList" import="mvc.models.Product" import="mvc.models.User"%>
</head>
<body>
<div id="head">
<%@ include file="header.jsp" %>
</div>

<div class="container">  
<div id="registerForm">
<%
	ArrayList<Product> list = new ArrayList<Product>();
    list = (ArrayList<Product>) request.getAttribute("productlist");
    
   User user = (User) request.getAttribute("user");
 %>
<br/>
<br/><br/><br/><br/><br/><br/><br/>
<h1>Register Device</h1>
	<form action="RegisterDeviceController" method="post">
	<div class="form-group">
    <label>Username</label>
    <input type="text" class="form-control" name="username" placeholder="Username" value=<%=user.getUsername() %> readonly>
     
  </div>
  <div class="form-group">
    <label>Product Name</label>
    <select class="form-control" name="productname">
    	 <% for(int i = 0; i < list.size(); i++) {
            	Product prod = new Product();
                prod = list.get(i);
            %>
            <option><%= prod.getProductname() %></option>
            <%
            };
            %>
    </select>
 
     </div>
  <div class="form-group">
    <label>Serial No</label>
    <input type="text" class="form-control" name="serialno" placeholder="Enter serial no">
  </div>
  <div class="form-group">
    <label>Purchase Date</label>
    <input type="date" class="form-control" name="date" placeholder="Enter purchase date">
  </div>
  
  <button type="submit" class="btn btn-primary">Register</button>
</form>
<br/>
<a href="UserHome?id=<%=user.getUsername() %>">Go back</a>
<br/><br/><br/>
</div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<div class="footer">
	<%@ include file="footer.jsp" %>
</div>
</body>

</html>