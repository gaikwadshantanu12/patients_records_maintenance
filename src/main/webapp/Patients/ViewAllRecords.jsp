<%@page import="com.shantanu.Patients.ViewAllPatientsRecords"%>
<%@page import="java.util.List"%>
<%@page import="com.shantanu.DatabaseConnect.DatabaseConnection"%>
<%@page import="com.shantanu.DAO.PatientsDAO"%>
<%@page import="com.shantanu.Patients.PatientsDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

	<%
    	PatientsDetails user4 = (PatientsDetails)session.getAttribute("patientdetails2");
    		if(user4 == null) {
    			response.sendRedirect("../Patients/PatientsLogin.jsp");
    			session.setAttribute("login-error", "Please login to view all patient's records !");
    		}
    %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Patient's Dashboard</title>
		<%@include file="../CDNLinks.jsp" %>
		<style>
			h2 {
				color: #845EC2;
				font-weight: bold;
			}
			h5 {
				color: #D13A28;
				font-weight: bold;
			}
			h6 {
				color: #4B4453;
				font-weight: bold;
			}
			.cont {
				margin-top: 75px;
			}
		</style>
	</head>
	
	<body>
		<%@include file="DashboardHeader.jsp" %>
		<div class="container-fluid cont">
				<h2 class="text-center">My Past Records</h2>
		
				<div class="row">
					<div class="col-md-8 offset-md-2 mb-5">
					
					<%
						if(user4 != null){
							PatientsDAO patientsDAO = new PatientsDAO(DatabaseConnection.getDatabaseConnection());
							List<ViewAllPatientsRecords> details = patientsDAO.getAllPatientsDetails(user4.getPatientID());
									
							for(ViewAllPatientsRecords viewAllDetails : details){%>
							
							<div class="card-deck m-3">
  								<div class="card">
    								<img class="card-img-top rounded-circle mx-auto p-3" src="../Images/list_technology_icon.png" style="max-width: 100px; max-height: 100px;" alt="Card image cap">
    								<div class="card-body">
     									<h5 class="card-title"><%= viewAllDetails.getDiseaseName() %></h5>
     									<p class="card-text"><%= viewAllDetails.getDiseaseDescription() %></p>
    								</div>
    								<div class="card-footer">
      									<small class="text-muted">Uploaded On : <%= viewAllDetails.getDate() %> &amp; <%= viewAllDetails.getTime() %></small>
    								</div>
  								</div>
							</div>
									<%}
								}
							%>
					</div>
				</div>
			</div>
			
			
	</body>
</html>