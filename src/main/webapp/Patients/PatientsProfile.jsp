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
			h5 {
				color: #C34A36;
			}
			
			body {
				background: #D5CABD;
			}

			.bg-custom {
				background-image: radial-gradient( circle farthest-corner at 22.4% 21.7%, rgba(4,189,228,1) 0%, rgba(2,83,185,1) 100.2% );
			}
			
			label, h5 {
  				font-family: Arial, Helvetica, sans-serif;
			}
		</style>
	</head>
	
	<body>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-6 offset-md-3 mb-5">
					<div class="card mt-5">
						<div class="card-header text-center text-white bg-custom">
							<i class="fa fa-user fa-3x" aria-hidden="true"></i>
							<h4 class="mt-3">Patient's Profile Section</h4>
						</div>
					
						<div class="card-body">
							<form action="" method="">
								<div class="form-row">
    								<div class="form-group col">
   										<label>First Name</label>
      									<h5><%=user2.getFirstName() %></h5>
   									</div>
	    							<div class="form-group col">
    									<label>Last Name</label>
      									<h5><%=user2.getLastName() %></h5>
      								</div>
  								</div>
	    						
  								<div class="form-group">
    								<label for="inputEmail">Patient's Email ID</label>
     								<h5><%=user2.getEmail() %></h5>
	    						</div>
	    							
								<div class="form-group">
    								<label>Patient's Gender</label><br>
    								<h5><%=user2.getGender() %></h5>
  								</div>
  								
  								<div class="form-row">
  									<div class="form-group col-8">
    									<label>Patient's Mobile Number</label>
     									<div class="input-group mb-2">
        									<h5><%=user2.getMobile() %></h5>
      									</div>
	    							</div>
	    							
 									<div class="form-group col-4">
    									<label>Patient's Age</label>
    									<h5><%=user2.getAge() %></h5>
  									</div>
  								</div>
  							
  								<div class="form-group">
    								<label>Patient's Residential Address</label>
   									<h5><%=user2.getAddress() %></h5>
	 							</div>
	 							
	 							<p class="text-center font-weight-bold mt-4">Click the link below to navigate to patient's dashboard<br><a href="PatientsDashboard.jsp">Go To Dashboard</a></p>
							</form>
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