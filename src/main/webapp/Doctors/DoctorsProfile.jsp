<%@page import="com.shantanu.Doctor.DoctorsDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
    	DoctorsDetails user5 = (DoctorsDetails)session.getAttribute("doctorsdetails2");
    		if(user5 == null) {
    			response.sendRedirect("../Doctors/DoctorsLogin.jsp");
    			session.setAttribute("login-error", "Please Login, Else You Can't Access Doctor's Dashboard Page");
    		}
    		else {
    %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Doctor's Profile</title>
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
							<h4 class="mt-3">Doctor's Profile Section</h4>
						</div>
					
						<div class="card-body">
							<form action="" method="">
								<div class="form-row">
    								<div class="form-group col">
   										<label>First Name</label>
      									<h5><%=user5.getFirstName() %></h5>
   									</div>
	    							<div class="form-group col">
    									<label>Last Name</label>
      									<h5><%=user5.getLastName() %></h5>
      								</div>
  								</div>
	    						
  								<div class="form-group">
    								<label for="inputEmail">Doctor's Email ID</label>
     								<h5><%=user5.getEmail() %></h5>
	    						</div>
  								
  								<div class="form-row">
  									<div class="form-group col-6">
    									<label>Doctor's Mobile No 1</label>
     									<div class="input-group mb-2">
        									<h5><%=user5.getMobile1() %></h5>
      									</div>
	    							</div>
	    							
 									<div class="form-group col-6">
    									<label>Doctor's Mobile No 1</label>
    									<h5><%=user5.getMobile2() %></h5>
  									</div>
  								</div>
  								
  								<h5 class="card-title mt-5 separation-heading">Education/Professional Details :</h5>
  									<div class="form-group">
    									<label><b>Educational Details</b></label>
     									<h5><%=user5.getEducationDetails() %></h5>
     								</div>
  							
  									<div class="form-group">
    									<label><b>Clinic / Hospital Name</b></label>
     									<h5><%=user5.getHospitalName() %></h5>
     								</div>
	    						
  									<div class="form-group">
    									<label><b>Enter Clinic / Hospital Address</b></label>
   										<h5><%=user5.getHospitalAddress() %></h5>
   									</div>
  								
	 							<p class="text-center font-weight-bold mt-4">Click the link below to navigate to doctor's dashboard<br><a href="DoctorsDashboard.jsp">Go To Dashboard</a></p>
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