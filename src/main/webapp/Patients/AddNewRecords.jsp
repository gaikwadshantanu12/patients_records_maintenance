<%@page import="com.shantanu.Patients.PatientsDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

	<%
    	PatientsDetails user3 = (PatientsDetails)session.getAttribute("patientdetails2");
    		if(user3 == null) {
    			response.sendRedirect("../Patients/PatientsLogin.jsp");
    			session.setAttribute("login-error", "Please login to add new patient's records !");
    		}
    %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Patient's Dashboard</title>
		<%@include file="../CDNLinks.jsp" %>
		
		<style>
			h2{
				color: #845EC2;
			}
			
			.cont {
				margin-top: 75px;
				font-weight: bold;
			}
		</style>
	</head>
	
	<body>
		<%@include file="DashboardHeader.jsp" %>
		<div class="container-fluid p-0">
			<h2 class="text-center cont">Add Your Health Record Here...</h2>
		
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<form action="../AddNewRecords" method="POST" enctype="multipart/form-data">
							<input type="hidden" name="patientsID" id="patientsID" value="<%=user3.getPatientID()%>">
							
							<%
								String record_inserted = (String) session.getAttribute("record-inserted");
								if (record_inserted != null) {
							%>
							<div class="alert alert-success" role="alert"><%= record_inserted%></div>
							<%
									session.removeAttribute("record-inserted");
								}
							%>
							
							<%
								String record_not_inserted = (String)session.getAttribute("record-not-inserted");
								if(record_not_inserted != null) {
							%>
							
							<%
									session.removeAttribute("record_not_inserted");
								}
							%>
						
  							<div class="form-group mt-4">
    							<label for="diseaseName">Enter Disease Name</label>
    							<input type="text" class="form-control" name="diseaseName" id="diseaseName" placeholder="Enter Disease Name" aria-describedby="titleHelp" required="required">
 							</div>
  					
  							<div class="form-group mt-4">
  								<label for="diseaseDescription">Enter Disease Description</label>
    							<textarea rows="4" cols="" class="form-control" name="diseaseDescription" id="diseaseDescription" placeholder="Enter Disease Description" style="resize: none;" required="required"></textarea>
  							</div>
  							
  							<div class="form-group mt-4">
  								<label for="diseaseRecord">Select Disease Record/File</label>
    							<input type="file" class="form-control" name="diseaseRecord" id="diseaseRecord" accept="image/*,.pdf" aria-describedby="titleHelp" required="required">
 							</div>
  
  							<div class="container text-center">
  								<button type="submit" class="btn btn-outline-dark mt-3">Add Health Record</button>
  							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>