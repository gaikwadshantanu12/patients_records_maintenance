<%@page import="com.shantanu.Patients.PatientsDetails"%>
<%@page import="com.shantanu.Patients.PatientsRecordDetails"%>
<%@page import="com.shantanu.Doctor.SharedDataList"%>
<%@page import="java.util.List"%>
<%@page import="com.shantanu.DatabaseConnect.DatabaseConnection"%>
<%@page import="com.shantanu.DAO.DoctorsDAO"%>
<%@page import="com.shantanu.Doctor.DoctorsDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
    	DoctorsDetails user4 = (DoctorsDetails)session.getAttribute("doctorsdetails2");
    		if(user4 == null) {
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
		
		<style>
			h5 {
				color: #936C00;
				font-weight: bold;
			}
			h2 {
				color: #845EC2;
				font-weight: bold;
			}
			.cont {
				margin-top: 30px;
			}
		</style>
	</head>
	
	<body>
		<%@include file="DashboardHeader.jsp" %>
		
		<div class="container-fluid cont">
				<h2 class="text-center">Records Shared By My Patients</h2>
		
				<div class="row">
					<div class="col-md-8 offset-md-2 mb-5">
					
					<%
						if(user4 != null){
							DoctorsDAO doctorsDAO = new DoctorsDAO(DatabaseConnection.getDatabaseConnection());
							List<SharedDataList> details = doctorsDAO.getListOfDataSharedWithMe(user4.getDoctorID());
							
							for(SharedDataList shared_data_list : details) { 
								//System.out.println("Shared Record ID : "+shared_data_list.getShared_record_id()+"\tPatient UID : "+shared_data_list.getPatientsID()+"\tDoctor UID : "+shared_data_list.getDoctorsID()+"\tRecord UID : "+shared_data_list.getRecordsID());
								PatientsRecordDetails dd = doctorsDAO.getParticularPatientRecordDetails(shared_data_list.getPatientsID(), shared_data_list.getRecordsID());
								
								//System.out.println("Disease Name : "+dd.getDiseaseName()+"\tDisease Des : "+dd.getDiseaseDescription()+"\tPatients ID : "+dd.getPatientID());
							%>
							
							<div class="card-deck m-3">
  								<div class="card">
    								<div class="card-body">
     									<h5 class="card-title"><%=dd.getDiseaseName()  %></h5>
     									<p class="card-text"><%= dd.getDiseaseDescription() %></p>
    								</div>
    								<div class="card-footer">
    									<%
    										PatientsDetails dePatientsDetails = doctorsDAO.getParticularPatient(shared_data_list.getPatientsID());
    									%>
      									<small class="text-muted">Record Shared By : <%=dePatientsDetails.getFirstName() %>&nbsp;<%=dePatientsDetails.getLastName() %></small>
      									
      									<a href="<%=request.getContextPath()%>/DownloadRecordFile?fileName=<%= dd.getFileName() %>">Download Record</a>
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