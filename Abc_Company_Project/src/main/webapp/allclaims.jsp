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
    list = (ArrayList<Claim>) request.getAttribute("claimlist");
    
    request.setAttribute("list", list);
 %>
 <table class="table">
        <thead class="thead-dark">
            <tr>
                <th scope="col">Id</th>
                <th scope="col">User Name</th>
                <th scope="col">Product Name</th>
                <th scope="col">Description</th>
                <th scope="col">Claim Date</th>
                <th scope="col">Status</th>
            </tr>
        </thead>
        <tbody>
            <% for(int i = 0; i < list.size(); i++) {
            	Claim claim = new Claim();
                claim = list.get(i);
            %>
            <tr>
                <th scope="row"><%=i +1%></th>
                <td><%=claim.getUsername() %></td>
                <td><%=claim.getProductname() %></td>
                <td><%=claim.getDescription() %></td>
                <td><%=claim.getClaimdate() %></td>
                <td><%=claim.getStatus() %></td>
                <td><a href="updateclaim.jsp?id=<%=claim.getId() %>&uname=<%=claim.getUsername() %>&pname=<%=claim.getProductname() %>
                &desc=<%=claim.getDescription() %>&date=<%=claim.getClaimdate() %>&status=<%=claim.getStatus() %>">
                update</a>
                </td>
               </tr>
            <%
            }
            %>
        </tbody>
    </table>
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