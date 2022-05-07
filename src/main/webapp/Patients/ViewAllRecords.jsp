<%@page import="com.shantanu.Patients.PatientsSharedRecordDoctorList"%>
<%@page import="com.shantanu.Doctor.DoctorsDetails"%>
<%@page import="com.shantanu.Patients.EnrolledDoctorsList"%>
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
    								<div class="card-body">
     									<h5 class="card-title"><%= viewAllDetails.getDiseaseName() %></h5>
     									<p class="card-text"><%= viewAllDetails.getDiseaseDescription() %></p>
    								</div>
    								<div class="card-footer">
      									<small class="text-muted">Uploaded On : <%= viewAllDetails.getDate() %> &amp; <%= viewAllDetails.getTime() %></small>
      									
      									<!-- Share Record With Enroll Doctor Function  -->
      									<div class="btn-group ml-4">
  											<button class="btn btn-light btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    											Share With Enroll Doctor
 											</button>
  											<div class="dropdown-menu">
  											
  												<%
													List<EnrolledDoctorsList> doctorsLists = patientsDAO.getListofEnrolledDoctor(user4.getPatientID());
							
													for(EnrolledDoctorsList enrolled_list : doctorsLists) {
														DoctorsDetails dd = patientsDAO.getParticularDoctor(enrolled_list.getDoctorID());
														
														boolean result = patientsDAO.isDataAlreadySharedWithDoctor(viewAllDetails.getRecordsID(), dd.getDoctorID(), user4.getPatientID());
														if (result) {
												%>
												
													<a class="dropdown-item disabled" href="" onclick="alert('Particular record already shared with the respective doctor !')">Dr. <%=dd.getFirstName()%>&nbsp;<%=dd.getLastName()%></a>
												
												<%
														} else {
												%>
												
												<a class="dropdown-item" href="../SharedRecordWithDoctor?doctor_id=<%=dd.getDoctorID()%>&patient_id=<%=user4.getPatientID()%>&records_id=<%=viewAllDetails.getRecordsID()%>">Dr. <%=dd.getFirstName()%>&nbsp;<%=dd.getLastName()%></a>
												
												<%
														}
													}
											%>
  											</div>
										</div>
										
										<!-- Don't Share Record With Enroll Doctor Function  -->
										<div class="btn-group ml-4">
											<button class="btn btn-light btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    											Don't Share With Enroll Doctor
 											</button>
  											<div class="dropdown-menu">
  												<%
													List<PatientsSharedRecordDoctorList> shared_record_list = patientsDAO.getListofRecordSharedWithDoctor(user4.getPatientID());
							
													for(PatientsSharedRecordDoctorList record_list : shared_record_list) {
														DoctorsDetails dd2 = patientsDAO.getParticularDoctor(record_list.getDoctor_id());
														
														boolean result = patientsDAO.isDataAlreadySharedWithDoctor(viewAllDetails.getRecordsID(), dd2.getDoctorID(), user4.getPatientID());
														if(result) {
												%>
												
												<a class="dropdown-item" href="../DontSharedRecordWithDoctor?doctor_id=<%=dd2.getDoctorID()%>&patient_id=<%=user4.getPatientID()%>&records_id=<%=viewAllDetails.getRecordsID()%>">Dr. <%=dd2.getFirstName()%>&nbsp;<%=dd2.getLastName()%></a>
												
												<%
														}
														else {
												%>
												<!--  
												<a class="dropdown-item disabled" href="" onclick="alert('You need to first share this record to do this action !')">This record is not shared with anyone</a>
												-->
												<%
														}
													}
												%>
  											</div>
										</div>
										<a class="ml-4" href="<%=request.getContextPath()%>/DownloadRecordFile?fileName=<%= viewAllDetails.getDiseaseFile() %>&recordID=<%=viewAllDetails.getRecordsID()%>">Download Record</a>
										
										<a class="ml-4" href="<%=request.getContextPath()%>/DeleteMyRecord?patient_id=<%=user4.getPatientID()%>&records_id=<%=viewAllDetails.getRecordsID()%>"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
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