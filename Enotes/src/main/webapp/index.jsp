<%@page import="com.Db.DBCon"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.back-images{
background: url("images/2.jpg");
background-size: cover;
}
</style>

<meta charset="ISO-8859-1">
<title>Home Page</title>
<%@include file="all_component/allcss.jsp" %>
</head>
<body>
<%@include file="all_component/navbar.jsp" %>

<div class="container-fluid back-images">
<div class="text-center">
<h1 class="text-white"><i class="fa fa-home" aria-hidden="true"></i> E Notes-Save Your Notes</h1>
<a href="login.jsp" class="btn btn-light"><i class="fa fa-user-circle-o" aria-hidden="true"></i> Login</a>
<a href="register.jsp" class="btn btn-light"><i class="fa fa-user-plus" aria-hidden="true"></i> Register</a>
</div>
</div>
<img src="images/2.jpg"  align="middle" width="1365" height="500">

<%@include file="all_component/footer.jsp" %>
</body>
</html>