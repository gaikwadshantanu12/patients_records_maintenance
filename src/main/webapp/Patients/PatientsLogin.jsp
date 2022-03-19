<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Patient's Log In Screen</title>
		<%@include file="../CDNLinks.jsp" %>
		
		<style>
			html, body {
  				height: 100%;
			}
			
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
			<div class="row justify-content-center align-items-center">
				<div class="col-md-6 mb-5">
					<div class="card mt-5">
						<div class="card-header text-center text-white bg-custom">
							<i class="fa fa-user-circle fa-3x" aria-hidden="true"></i>
							<h4 class="mt-3">Patient's Login Page</h4>
						</div>
						
						<%
							String failed_msg = (String) session.getAttribute("login_failed");
							if (failed_msg != null) {
						%>
						<div class="alert alert-danger" role="alert"><%= failed_msg%></div>
						<%
								session.removeAttribute("login_failed");
							}
						%>
						
						<%
							String loginerror = (String)session.getAttribute("login-error");
							if(loginerror != null) {
						%>
						<div class="alert alert-danger" role="alert"><%= loginerror%></div>
						<%
								session.removeAttribute("login-error");
							}
						%>
					
						<%
							String logout_message = (String)session.getAttribute("logout-message");
							if(logout_message != null) {
						%>
						<div class="alert alert-success" role="alert"><%= logout_message%></div>
						<%
								session.removeAttribute("logout-message");
							}
						%>
					
						<div class="card-body">
							<form action="../PatientsLogin" method="POST">
  								<div class="form-group">
    								<label for="inputEmail">Enter Your Email</label>
     								<input type="email" class="form-control" id="inputEmail" name="inputEmail" placeholder="Enter Your Email" required="required">
	    						</div>
    	
 								<div class="form-group">
    								<label for="inputPassword">Enter Your Password</label>
    								<input type="password" class="form-control" id="inputPassword" name="inputPassword" placeholder="Enter Your Password" required="required">
  								</div>
  	
  								<div class="d-flex justify-content-center mt-5 mb-3">
  									<button type="submit" id="logInBtn" name="logInBtn" class="btn btn-outline-success">Login As Patient</button>
  								</div>
  								<p class="text-center font-weight-bold mt-5">New User (New Patient) ? <a href="PatientsSignup.jsp">Register Here</a></p>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>