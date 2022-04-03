<nav class="navbar navbar-expand-md bg-dark fixed-top navbar-dark">
	<div class="container">
		<a href="" class="navbar-brand text-warning font-weight-bold">Patient's Dashboard</a>
			
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsenavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
			
		<div class="collapse navbar-collapse text-center" id="collapsenavbar">
			<ul class="navbar-nav ml-auto">
      			<li class="nav-item">
        			<a class="nav-link text-white ml-2 mr-2" href="AddNewRecords.jsp">
          				<i class="fa fa-plus-circle mr-1" aria-hidden="true"></i>
          				Add New Record
        			</a>
      			</li>
      						
      			<li class="nav-item">
        			<a class="nav-link text-white ml-2 mr-2" href="ViewAllRecords.jsp">
        				<i class="fa fa-list-ul mr-1" aria-hidden="true"></i>
          				View All Records
        			</a>
      			</li>
      						
      			<li class="nav-item">
        			<a class="nav-link text-white ml-2 mr-2" href="DoctorsAvailable.jsp">
        				<i class="fa fa-clock-o mr-1" aria-hidden="true"></i>
          				Doctors Available
        			</a>
      			</li>
      						
      			<li class="nav-item">
        			<a class="nav-link text-white ml-2 mr-2" href="EnrolledDoctors.jsp">
        				<i class="fa fa-sticky-note mr-1" aria-hidden="true"></i>
          				Enrolled Doctor
        			</a>
      			</li>
      			
      			<li class="nav-item dropdown">
        			<a class="nav-link dropdown-toggle text-white ml-2 mr-2" href="" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          				<i class="fa fa-cog mr-1" aria-hidden="true"></i>
          				Settings
        			</a>
        			<div class="dropdown-menu text-center" aria-labelledby="navbarDropdown">
         				<a class="dropdown-item" href="PatientsProfile.jsp"><i class="fa fa-user-circle mr-2" aria-hidden="true"></i>My Profile</a>
         				<div class="dropdown-divider"></div>
          				<a class="dropdown-item" href="../PatientsLogout"><i class="fa fa-sign-out mr-2" aria-hidden="true"></i>Log Out</a>
        			</div>
      			</li>
			</ul>
		</div>
	</div>
</nav>