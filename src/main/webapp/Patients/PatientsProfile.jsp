<%@page import="com.shantanu.Patients.PatientsDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	
	<%
    	PatientsDetails user2 = (PatientsDetails)session.getAttribute("patientdetails2");
    		if(user2 == null) {
    			response.sendRedirect("../Patients/PatientsLogin.jsp");
    			session.setAttribute("login-error", "Please Login, Else You Can't Access Patient's Dashboard Page");
    		}
    		else {
    %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Patient's Profile</title>
		<%@include file="../CDNLinks.jsp" %>
		
		<style>
			h1 {
				color: #845EC2;
			}
			h6 {
				color: #4B4453;
			}
			h4 {
				color: #C34A36;
			}
		</style>
	</head>
	
	<body>
		<div class="container-fluid p-0">
			<h1 class="text-center font-weight-bold mt-4"><%=user2.getFirstName() %>'s Profile</h1>
		
			<div class="container mt-4">
				<div class="row">
					<div class="col-md-12">
						<div class="form-row">
    						<div class="form-group col">
   								<h6>First Name</h6>
      							<h4><%=user2.getFirstName() %></h4>
   							</div>
	    					<div class="form-group col">
    							<h6>Last Name</h6>
      							<h4><%=user2.getLastName() %></h4>
   							</div>
  						</div>
  						
  						<div class="form-row">
    						<div class="form-group col">
   								<h6>Email</h6>
      							<h4><%=user2.getEmail()%></h4>
   							</div>
	    					<div class="form-group col">
    							<h6>Age</h6>
      							<h4><%=user2.getAge() %></h4>
   							</div>
  						</div>
  						
  						<div class="form-row">
    						<div class="form-group col">
   								<h6>Mobile</h6>
      							<h4><%=user2.getMobile() %></h4>
   							</div>
	    					<div class="form-group col">
    							<h6>Gender</h6>
      							<h4><%=user2.getGender() %></h4>
   							</div>
  						</div>
  						
  						<div class="form-row">
	    					<div class="form-group col">
    							<h6>Address</h6>
      							<h4><%=user2.getAddress() %></h4>
   							</div>
  						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>

	<%
    		}
   %>