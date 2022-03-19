package com.shantanu.Doctor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shantanu.DAO.DoctorsDAO;
import com.shantanu.DatabaseConnect.DatabaseConnection;
import com.shantanu.Validation.Validation;

@WebServlet("/DoctorsSignup")
public class DoctorsSignup extends HttpServlet {
	String firstName, lastName, email, password, confirmPassword, mobile1, mobile2;
	String educationDetails, hospitalName, hospitalAddress;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getData(request);
		HttpSession session;
		
		Validation validation = new Validation();
		if(validation.emailValidate(email)) {
			response.getWriter().println("Valid Email");
			
			if(validation.passwordValidate(password)) {
				if(validation.passwordAndConfirmPasswordSame(password, confirmPassword)) {
					response.getWriter().println("Password & Confirm Password Matched");
					
					if(validation.mobileValidate(mobile1)) {
						response.getWriter().println("Valid Mobile No1");
						
						if(validation.mobileValidate(mobile2)) {
							response.getWriter().println("Valid Mobile No2");
							
							// if everything right and valid, let's add doctor's data to database
							DoctorsDetails doctorsDetails = new DoctorsDetails();
							doctorsDetails.setFirstName(firstName);
							doctorsDetails.setLastName(lastName);
							doctorsDetails.setEmail(email);
							doctorsDetails.setPassword(password);
							doctorsDetails.setMobile1(mobile1);
							doctorsDetails.setMobile2(mobile2);
							doctorsDetails.setEducationDetails(educationDetails);
							doctorsDetails.setHospitalName(hospitalName);
							doctorsDetails.setHospitalAddress(hospitalAddress);
							
							DoctorsDAO dao = new DoctorsDAO(DatabaseConnection.getDatabaseConnection());
							boolean res = dao.addDoctorsData(doctorsDetails);
							
							if(res) {
								System.out.println("Doctor registered successfully !");
								session = request.getSession();
								session.setAttribute("register_success", "Doctor registered successfully !");
								response.sendRedirect("../patients_records_maintenance/Doctors/DoctorsSignup.jsp");
							}
							else {
								System.out.println("Doctor not registered. Something went wrong on server !");
								session = request.getSession();
								session.setAttribute("register_fail", "Doctor not registered. Something went wrong on server !");
								response.sendRedirect("../patients_records_maintenance/Doctors/DoctorsSignup.jsp");
							}
						}
						else {
							System.out.println("Invalid mobile number 2. Please provide a valid mobile number.");
							session = request.getSession();
							session.setAttribute("invalid_mob", "Invalid mobile number 2. Please provide a valid mobile number.");
							response.sendRedirect("../patients_records_maintenance/Doctors/DoctorsSignup.jsp");
						}
					}
					else {
						System.out.println("Invalid mobile number 1. Please provide a valid mobile number.");
						session = request.getSession();
						session.setAttribute("invalid_mob", "Invalid mobile number 1. Please provide a valid mobile number.");
						response.sendRedirect("../patients_records_maintenance/Doctors/DoctorsSignup.jsp");
					}
				}
				else {
					System.out.println("Password & Confirm Password Not Matched.");
					session = request.getSession();
					session.setAttribute("pass_confirm_pass", "Password & Confirm Password Not Matched.");
					response.sendRedirect("../patients_records_maintenance/Doctors/DoctorsSignup.jsp");
				}
			}
			else {
				System.out.println("Invalid Password. Please provide a valid password.");
				session = request.getSession();
				session.setAttribute("invalid_pass", "Invalid Password. Please provide a valid password.");
				response.sendRedirect("../patients_records_maintenance/Doctors/DoctorsSignup.jsp");
			}
		}
		else {
			System.out.println("Invalid Email ID. Please provide a valid email address.");
			session = request.getSession();
			session.setAttribute("invalid_email", "Invalid Email ID. Please provide a valid email address.");
			response.sendRedirect("../patients_records_maintenance/Doctors/DoctorsSignup.jsp");
		}
	}
	
	public void getData(HttpServletRequest request) {
		// Doctor's Personal Details
		firstName = request.getParameter("firstName").trim();
		lastName = request.getParameter("lastName").trim();
		email = request.getParameter("inputEmail").trim();
		password = request.getParameter("inputPassword").trim();
		confirmPassword = request.getParameter("inputConfirmPassword").trim();
		mobile1 = request.getParameter("mobileNumber1").trim();
		mobile2 = request.getParameter("mobileNumber2").trim();
		
		// Doctor's Professional Details
		educationDetails = request.getParameter("educationDetails").trim();
		hospitalName = request.getParameter("clinicName").trim();
		hospitalAddress = request.getParameter("clinicAddress").trim();
	}

}
