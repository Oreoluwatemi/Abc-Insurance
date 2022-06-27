<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<%@page import="mvc.models.Admin"%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="style.css" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
<div id="head">
<%@ include file="header.jsp" %>
</div>
<br/><br/><br/><br/>
<%
    Admin user = (Admin) request.getAttribute("admin");
 %>
 <div class="jumbotron">
  <h1 class="display-4">Welcome Admin <%= user.getUsername() %></h1>
  <p class="lead">Your Dashboard</p>
  <hr class="my-4">
  <p>Here you view all registered users, add/edit a product and update the status of a claim</p>
  <p class="lead">
    <a class="btn btn-primary btn-lg" href="AllUserandProduct?id=allusers" role="button">All Users</a>
 	<a class="btn btn-primary btn-lg" href="AllUserandProduct?id=allproducts" role="button">All Products</a>
  	<a class="btn btn-primary btn-lg" href="AllClaimsController?id=allclaims" role="button">Update claim status</a>
  </p>
</div>

	<div class="footer">
	<%@ include file="footer.jsp" %>
</div>
</body>

</html>