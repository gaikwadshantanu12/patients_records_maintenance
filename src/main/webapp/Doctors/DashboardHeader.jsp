<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<div class="container">
		<a href="" class="navbar-brand text-warning font-weight-bold">Doctor's Dashboard</a>
			
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsenavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
			
		<div class="collapse navbar-collapse text-center" id="collapsenavbar">
			<ul class="navbar-nav ml-auto">
      				  					
      			<li class="nav-item">
        			<a class="nav-link text-white ml-2 mr-2" href="ViewMyPatients.jsp">
        				<i class="fa fa-list-ul mr-1" aria-hidden="true"></i>
          				View All Patients
        			</a>
      			</li>
      			
      			<li class="nav-item">
        			<a class="nav-link text-white ml-2 mr-2" href="ViewSharedData.jsp">
        				<i class="fa fa-database mr-1" aria-hidden="true"></i>
          				View Shared Records
        			</a>
      			</li>
      			
      			<li class="nav-item dropdown">
        			<a class="nav-link dropdown-toggle text-white ml-2 mr-2" href="" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          				<i class="fa fa-cog mr-1" aria-hidden="true"></i>
          				Settings
        			</a>
        			<div class="dropdown-menu text-center" aria-labelledby="navbarDropdown">
         				<a class="dropdown-item" href="DoctorsProfile.jsp"><i class="fa fa-user-circle mr-2" aria-hidden="true"></i>My Profile</a>
         				<div class="dropdown-divider"></div>
          				<a class="dropdown-item" href="../DoctorsLogout"><i class="fa fa-sign-out mr-2" aria-hidden="true"></i>Log Out</a>
        			</div>
      			</li>
			</ul>
		</div>
	</div>
</nav>