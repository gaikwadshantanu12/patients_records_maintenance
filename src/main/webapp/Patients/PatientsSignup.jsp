<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Patient's Sign Up Screen</title>
		<%@include file="../CDNLinks.jsp" %>
		
		<style>
			.div-color {
				background-image: linear-gradient(to right top, #d16ba5, #c777b9, #ba83ca, #aa8fd8, #9a9ae1, #8aa7ec, #79b3f4, #69bff8, #52cffe, #41dfff, #46eefa, #5ffbf1);
				height: 100%;
				max-height: 100%;
			}

			.bg-custom {
				background-image: radial-gradient( circle farthest-corner at 22.4% 21.7%, rgba(4,189,228,1) 0%, rgba(2,83,185,1) 100.2% );
			}
		</style>

	</head>
	<body>
		<div class="container-fluid div-color">
			<div class="row">
				<div class="col-md-6 offset-md-3 mb-5">
					<div class="card mt-5">
						<div class="card-header text-center text-white bg-custom">
							<i class="fa fa-user-plus fa-3x" aria-hidden="true"></i>
							<h4 class="mt-3">Patient's Registration Page</h4>
						</div>
						
						<%
							String registration_msg = (String) session.getAttribute("register_success");
							if (registration_msg != null) {
						%>
					
						<div class="alert alert-success" role="alert"><%=registration_msg%>
							<a href="PatientsLogin.jsp"> Click here to login</a>
						</div>
					
						<%
								session.removeAttribute("register_success");
							}
						%>

						<%
							String failed_msg = (String) session.getAttribute("register_fail");
							if (failed_msg != null) {
						%>
					
						<div class="alert alert-danger" role="alert"><%=failed_msg%></div>
					
						<%
								session.removeAttribute("register_fail");
							}
						%>
					
						<div class="card-body">
							<form action="../PatientsSignup" method="POST">
								<div class="form-row">
    								<div class="form-group col">
   										<label for="firstName">Enter Your First Name</label>
      									<input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name" required="required">
   									</div>
	    							<div class="form-group col">
    									<label for="inputPassword">Enter Your Last Name</label>
      									<input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name" required="required">
   									</div>
  								</div>
	    						
  								<div class="form-group">
    								<label for="inputEmail">Enter Your Email</label>
     								<input type="email" class="form-control" id="emailID" name="emailID" placeholder="Enter Your Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Please enter proper email address. For eg. 'android@whatsapp.com'" required="required">
	    						</div>
  								
  								<div class="form-row">
    								<div class="form-group col">
   										<label for="inputPassword">Enter Your Password</label>
    									<input type="password" class="form-control" id="inputPassword" name="inputPassword" maxlength="20" placeholder="Enter Your Password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
  title="Password must be a very strong combination of alpha-numeric characters and special symbols. And it must be around 15-18 characters long." required="required">
  									</div>
	    							<div class="form-group col">
    									<label for="inputConfirmPassword">Confirm Your Password</label>
    									<input type="password" class="form-control" id="inputConfirmPassword" name="inputConfirmPassword" maxlength="20" placeholder="Confirm Your Password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
  title="Password must be a very strong combination of alpha-numeric characters and special symbols. And it must be around 15-18 characters long." required="required">
  									</div>
  								</div>
	    							
								<div class="form-group">
    								<label for="inputPassword">Select Gender</label><br>
    								<div class="custom-control custom-radio custom-control-inline">
  										<input type="radio" id="male" name="gender" value="Male" class="custom-control-input" required="required">
 										<label class="custom-control-label" for="male">Male</label>
									</div>
									<div class="custom-control custom-radio custom-control-inline">
  										<input type="radio" id="female" name="gender" value="Female" class="custom-control-input" required="required">
  										<label class="custom-control-label" for="female">Female</label>
									</div>
									<div class="custom-control custom-radio custom-control-inline">
  										<input type="radio" id="transgender" name="gender" value="Transgender" class="custom-control-input" required="required">
  										<label class="custom-control-label" for="transgender">Prefer Not To Say</label>
									</div>
  								</div>
  								
  								<div class="form-row">
  									<div class="form-group col-8">
    									<label for="mobileNumber">Enter Your Mobile Number</label>
     									<div class="input-group mb-2">
        									<div class="input-group-prepend">
          										<div class="input-group-text">+91</div>
        									</div>
        									<input type="tel" class="form-control" id="mobileNumber" name="mobileNumber" maxlength="10" placeholder="Enter Your Mobile No" required="required">
      									</div>
	    							</div>
	    							
 									<div class="form-group col-4">
    									<label for="patientAge">Enter Your Age</label>
    									<input type="number" class="form-control" id="patientAge" name="patientAge" min="10" max="90" placeholder="Enter Age" required="required">
  									</div>
  								</div>
  							
  								<div class="form-group">
    								<label for="inputAddress">Enter Your Address</label>
   									<textarea rows="3" cols="" class="form-control" name="inputAddress" id="inputAddress" placeholder="Enter Your Address" style="resize: none;" required="required"></textarea>
	 							</div>
 							
 								<!--  
 								<div class="form-group">
    								<label for="profileImage">Select Profile Photo</label>
    								<input type="file" class="form-control" id="profileImage" name="profileImage" accept="image/*" required="required">
  								</div>
  								-->
  	
  								<div class="d-flex justify-content-center mt-5 mb-3">
  									<button type="submit" id="registerBtn" name="registerBtn" class="btn btn-success">Register As Patient</button>
  								</div>
  								<p class="text-center font-weight-bold mt-5">Already Registered ? <a href="PatientsLogin.jsp">Login Here</a></p>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>