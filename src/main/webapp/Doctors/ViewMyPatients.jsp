<%@page import="com.shantanu.Patients.PatientsDetails"%>
<%@page import="com.shantanu.Doctor.EnrolledPatientList"%>
<%@page import="java.util.List"%>
<%@page import="com.shantanu.DatabaseConnect.DatabaseConnection"%>
<%@page import="com.shantanu.DAO.DoctorsDAO"%>
<%@page import="com.shantanu.Doctor.DoctorsDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

	<%
    	DoctorsDetails user3 = (DoctorsDetails)session.getAttribute("doctorsdetails2");
    		if(user3 == null) {
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
				<h2 class="text-center">My Patients</h2>
		
				<div class="row">
					<div class="col-md-8 offset-md-2">
					
					<%
						if(user3 != null){
							DoctorsDAO doctorsDAO = new DoctorsDAO(DatabaseConnection.getDatabaseConnection());
							List<EnrolledPatientList> details = doctorsDAO.getListOfMyPatients(user3.getDoctorID());
									
							for(EnrolledPatientList my_patients_list : details) { 
								PatientsDetails dd = doctorsDAO.getParticularPatient(my_patients_list.getPatientID());
								%>
								
								<div class="card mt-3">
									
									<div class="card-body p-4">
										<div class="form-row align-middle">
						
											<img alt="Doctor's Profile" src="../Images/list_profile_icon.png" class="card-img-top rounded-circle mx-auto" style="max-width: 100px; max-height: 100px;">
						
	    									<div class="form-group col justify-content-start ml-5">
	    										<div class="form-row d-flex">
	    											<h5><%= dd.getFirstName() %></h5>&nbsp;
													<h5><%= dd.getLastName() %></h5>&nbsp; 
												
	    										</div>
	    										
	    										<div class="form-row d-flex">
													<h6>Contact : 
															<a href="mailto:<%=dd.getEmail()%>"><i class="fa fa-envelope" aria-hidden="true"></i>&nbsp;<%= dd.getEmail() %></a>&nbsp;&#44;&nbsp;
													 		<a href="tel:+91<%=dd.getMobile()%>"><i class="fa fa-phone" aria-hidden="true"></i>&nbsp;<%=dd.getMobile() %></a>&nbsp;
													 </h6>
	    										</div>
 										</div>
									</div>
								</div>
								
									<%}
								}
							%>
					</div>
				</div>
			</div>
			</div>
	</body>
</html>