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
<%@page import="java.util.ArrayList" import="mvc.models.RegisteredDevice" import="mvc.models.Claim" import="mvc.models.User"%>
</head>
<body>
<div id="head">
<%@ include file="header.jsp" %>
</div>
<br/><br/><br/>
<div class="container">  
<h1>Claims</h1><br/><br/><br/>
<%

ArrayList<Claim> list = new ArrayList<Claim>();
list = (ArrayList<Claim>) request.getAttribute("list");

String id = request.getParameter("id");
String uname = request.getParameter("uname");
String pname = request.getParameter("pname");
String desc = request.getParameter("desc");
String date = request.getParameter("date");
String status = request.getParameter("status");
	
   %>
   <form action="UpdateClaimController" method="post">
   
    <input type="hidden" name="id" value=<%=id %> >
    <div class="form-group">
    <label>User</label>
   <input type="text" name="uname" class="form-control" value=<%=uname %> readonly>
   </div>
    <div class="form-group">
    <label>Product</label>
    <input type="text" name="pname" class="form-control" value=<%=pname %> readonly>
     </div>
      <div class="form-group">
    <label>Description</label>
     <textarea type="text" name="desc" class="form-control" readonly><%=desc %> </textarea>
      </div>
       <div class="form-group">
    <label>Claim date</label>
      <input type="text" name="date" class="form-control" value=<%=date %> readonly>
      </div>
      <div class="form-group">
    <label>Status</label>
      <select name="status" class="form-control"><%=status %>
      <option>pending</option>
      <option>approved</option>
      <option>rejected</option>
       </select>
       </div>
       <button type="submit" class="btn btn-primary">Update</button>
   </form>
   
 

<br/>
<br/><br/><br/>

<br/>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<div class="footer">
	<%@ include file="footer.jsp" %>
</div>
</body>

</html>