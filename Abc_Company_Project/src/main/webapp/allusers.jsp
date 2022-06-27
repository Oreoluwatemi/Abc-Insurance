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
<%@page import="java.util.ArrayList" import="mvc.models.User"%>
</head>
<body>
<div id="head">
<%@ include file="header.jsp" %>
</div>
<br/><br/><br/>
<div class="container">  
<h1>All Users</h1><br/><br/><br/>
<%
	ArrayList<User> list = new ArrayList<User>();
    list = (ArrayList<User>) request.getAttribute("userlist");
    
 %>
 <table class="table" >
        <thead class="thead-dark">
            <tr>
            	<th scope="col">#</th>
                <th scope="col">User Name</th>
                <th scope="col">Email</th>
                <th scope="col">Phone Number</th>
                <th scope="col">Address</th>
            </tr>
        </thead>
        <tbody>
            <% for(int i = 0; i < list.size(); i++) {
            	User user = new User();
                user = list.get(i);
            %>
            
            <tr>
                <th scope="row"><%=i+1 %></th>
                <td><%=user.getUsername() %></td>
                <td><%=user.getEmail() %></td>
                <td><%=user.getPhoneNumber() %></td>
                <td><%=user.getAddress() %></td>
                <td><a href="UserDetailsController?name=<%=user.getUsername() %>">View</a></td>
                <td><a onclick="deleteRecord('<%=user.getEmail() %>', '<%=user.getId()%>')">Delete Account</a>
                </td>
               </tr>
            <%
                };
            %>
        </tbody>
    </table>
<br/>
<br/><br/><br/>
<br/>
<br/><br/><br/>
</div>

<script>
		function deleteRecord(name, id) {
			var ans = window.confirm("Are you sure you want to delete " + name
					+ " ? ")
			if (ans) {
				window.location.assign("DeleteController?id=" + id +"&role=admin")

				return true;
			} else
				return false;

		}
	</script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<div class="footer">
	<%@ include file="footer.jsp" %>
</div>
</body>

</html>