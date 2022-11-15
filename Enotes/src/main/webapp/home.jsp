<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%
    UserDetails user2 = (UserDetails)session.getAttribute("userD");
    
    if(user2==null){
    	response.sendRedirect("login.jsp");
    	session.setAttribute("Login-error", "Please Login..");
    }
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<div class="container-fluid p-0">
		<%@include file="all_component/navbar.jsp"%>
		<div class="card py-5">
			<div class="card-body text-center">
				<img alt="" src="images/4.jpg" class="img-fluid ms-auto"
					style="max-width: 300px;" align="middle">
				<h1>START TALKING YOUR NOTES</h1>
				<a href="addNotes.jsp" class="btn btn-outline-primary">Start Here</a>
			</div>
		</div>
	</div>

</body>
</html>