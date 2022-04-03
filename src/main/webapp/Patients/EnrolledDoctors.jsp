<%@page import="com.shantanu.Doctor.DoctorsDetails"%>
<%@page import="com.shantanu.Patients.EnrolledDoctorsList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.shantanu.DatabaseConnect.DatabaseConnection"%>
<%@page import="com.shantanu.DAO.PatientsDAO"%>
<%@page import="com.shantanu.Patients.PatientsDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

	<%
    	PatientsDetails user5 = (PatientsDetails)session.getAttribute("patientdetails2");
    		if(user5 == null) {
    			response.sendRedirect("../Patients/PatientsLogin.jsp");
    			session.setAttribute("login-error", "Please login to view enrolled doctor's list !");
    		}
    %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Patient's Dashboard</title>
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
				margin-top: 75px;
			}
		</style>
	</head>
	
	<body>
		<%@include file="DashboardHeader.jsp" %>
		
		<div class="container-fluid cont">
				<h2 class="text-center">Enrolled Doctors</h2>
		
				<div class="row">
					<div class="col-md-8 offset-md-2 mb-5">
					
					<%
						if(user5 != null){
							PatientsDAO patientsDAO = new PatientsDAO(DatabaseConnection.getDatabaseConnection());
							
							List<EnrolledDoctorsList> doctorsLists = patientsDAO.getListofEnrolledDoctor(user5.getPatientID());
							
							for(EnrolledDoctorsList enrolled_list : doctorsLists) {
								DoctorsDetails dd = patientsDAO.getParticularDoctor(enrolled_list.getDoctorID());
								%>
								<div class="card mt-3">
									
									<div class="card-body p-4">
										<div class="form-row align-middle">
						
											<img alt="Doctor's Profile" src="../Images/list_profile_icon.png" class="card-img-top rounded-circle mx-auto" style="max-width: 100px; max-height: 100px;">
						
	    									<div class="form-group col justify-content-start ml-5">
	    										<div class="form-row d-flex">
	    											<h5><%= dd.getFirstName() %></h5>&nbsp;
													<h5><%= dd.getLastName() %></h5>&nbsp; 
													<h5>&#40; <%=dd.getEducationDetails() %> &#41;</h5>
	    										</div>
	    										
	    										<div class="form-row d-flex">
													<h6>Contact : 
															<a href="mailto:<%=dd.getEmail()%>"><i class="fa fa-envelope" aria-hidden="true"></i>&nbsp;<%= dd.getEmail() %></a>&nbsp;&#44;&nbsp;
													 		<a href="tel:+91<%=dd.getMobile1()%>"><i class="fa fa-phone" aria-hidden="true"></i>&nbsp;<%=dd.getMobile1() %></a>&nbsp;&#47;&nbsp;<a href="tel:+91<%=dd.getMobile2()%>"><%=dd.getMobile2() %></a>
													 </h6>
	    										</div>
	    										
	    										<div class="form-row d-flex mt-2">
	    											<h5>Hospital Details - </h5>
	    										</div>
	    										
	    										<div class="form-row d-flex">
	    											<h6>Hospital Name : <%=dd.getHospitalName() %></h6>
	    										</div>
	    										
	    										<div class="form-row d-flex">
	    											<h6>Hospital Add. : <%=dd.getHospitalAddress() %></h6>
	    										</div>
   											</div>
   											
   											<div>
   												<a class="btn btn-outline-dark" href="../DisenrollDoctor?doctor_id=<%=dd.getDoctorID() %>&patient_id=<%=user5.getPatientID()%>">Unenroll Doctor</a>
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
		</body>
</html>