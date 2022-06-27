<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<%@page import="mvc.models.User"%>
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
    User user = (User) request.getAttribute("user");
 %>
 <div class="jumbotron">
  <h1 class="display-4">Welcome <%= user.getUsername() %></h1>
  <p class="lead">Your Dashboard</p>
  <hr class="my-4">
  <p>Here you can register a device, file a claim and check the status of your claims</p>
  <p class="lead">
    <a class="btn btn-primary btn-lg" href="DisplayRD?id=<%= user.getEmail() %>" role="button">Register a device</a>
 	<a class="btn btn-primary btn-lg" href="AllDevicesController?id=<%= user.getUsername()%>" role="button">Find your registered devices</a>
  	<a class="btn btn-primary btn-lg"href="AllClaimsController?id=<%= user.getUsername()%>" role="button">Check your claims status</a>
  </p>
</div>

&nbsp&nbsp&nbsp<a class="btn btn-primary btn-lg" onclick="deleteRecord('<%=user.getEmail() %>', '<%=user.getId()%>')" role="button">Delete Account</a>

<script>
		function deleteRecord(name, id) {
			var ans = window.confirm("Are you sure you want to delete your account " + name + "id " + id +" ?")
			if (ans) {
				window.location.assign("DeleteController?id=" + id +"&role=user")

				return true;
			} else
				return false;

		}
	</script>
	<div class="footer">
	<%@ include file="footer.jsp" %>
</div>

</body>

</html>