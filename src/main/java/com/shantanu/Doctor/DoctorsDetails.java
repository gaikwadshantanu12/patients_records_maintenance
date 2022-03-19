package com.shantanu.Doctor;

public class DoctorsDetails {
	private int DoctorID;
	private String firstName, lastName, password, email, mobile1, mobile2;
	private String educationDetails, hospitalName, hospitalAddress;
	
	public DoctorsDetails() {
		super();
	}

	public DoctorsDetails(int DoctorID, String firstName, String lastName, String password, String email,
			String mobile1, String mobile2, String educationDetails, String hospitalName, String hospitalAddress) {
		super();
		this.DoctorID = DoctorID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.mobile1 = mobile1;
		this.mobile2 = mobile2;
		this.educationDetails = educationDetails;
		this.hospitalName = hospitalName;
		this.hospitalAddress = hospitalAddress;
	}
	
	public int getDoctorID() {
		return DoctorID;
	}
	public void setDoctorID(int DoctorID) {
		this.DoctorID = DoctorID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile1() {
		return mobile1;
	}
	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}
	public String getMobile2() {
		return mobile2;
	}
	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}
	public String getEducationDetails() {
		return educationDetails;
	}
	public void setEducationDetails(String educationDetails) {
		this.educationDetails = educationDetails;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getHospitalAddress() {
		return hospitalAddress;
	}
	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}

}
