<%@page import="com.shantanu.Patients.PatientsDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	
	<%
    	PatientsDetails user2 = (PatientsDetails)session.getAttribute("patientdetails2");
    		if(user2 == null) {
    			response.sendRedirect("../Patients/PatientsLogin.jsp");
    			session.setAttribute("login-error", "Please Login, Else You Can't Access Patient's Dashboard Page");
    		}
    %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Patient's Dashboard</title>
		<%@include file="../CDNLinks.jsp" %>
	</head>
	<body>
		<%@include file="AddNewRecords.jsp" %>
	</body>
</html>