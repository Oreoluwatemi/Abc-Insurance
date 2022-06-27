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
<%@page import="java.util.ArrayList" import="mvc.models.RegisteredDevice" import="mvc.models.Product" import="mvc.models.User"%>
</head>
<body>
<div id="head">
<%@ include file="header.jsp" %>
</div>
<%
	String user = request.getParameter("user");
	String prod = request.getParameter("prod");
%>
<div class="container">  
<div id="registerForm">
<form action="ClaimController" method="post">
	<div class="form-group">
    <label>Username</label>
    <input type="text" class="form-control" name="username" placeholder="Username" value=<%=user %> readonly>
  </div>
  <div class="form-group">
    <label>	Product Name</label>
    <input type="text" class="form-control" name="productname" placeholder="Enter product name" value=<%=prod %> readonly>
  </div>
  <div class="form-group">
    <label>Description</label>
    <textarea type="text" class="form-control" name="desc" placeholder="Enter Description"></textarea>
  </div>

  <button type="submit" class="btn btn-primary">Register Claim</button>
</form>
</div>
</div>
<a href="UserHome?id=<%=user %>">Go Home</a>
<div class="footer">
	<%@ include file="footer.jsp" %>
</div>
</body>

</html>