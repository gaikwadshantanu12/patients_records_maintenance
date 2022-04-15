<%@page import="com.shantanu.Doctor.DoctorsDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

	<%
    	DoctorsDetails user2 = (DoctorsDetails)session.getAttribute("doctorsdetails2");
    		if(user2 == null) {
    			response.sendRedirect("../Doctors/DoctorsLogin.jsp");
    			session.setAttribute("login-error", "Please Login, Else You Can't Access Doctor's Dashboard Page");
    		}
    %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Doctor's Dashboard</title>
		<%@include file="../CDNLinks.jsp" %>
	</head>
	
	<body>
		<%@include file="ViewMyPatients.jsp" %>
	</body>
</html>