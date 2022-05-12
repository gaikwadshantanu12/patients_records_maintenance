package com.shantanu.Patients;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.shantanu.DAO.PatientsDAO;
import com.shantanu.DAO.UploadDAO;
import com.shantanu.DatabaseConnect.DatabaseConnection;
import com.shantanu.Validation.Validation;

@WebServlet("/PatientsSignup")

public class PatientsSignup extends HttpServlet {
	String firstName, lastName, email, password, confirmPassword, gender, mobile, age, address;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getData(request);
		
		HttpSession session;
		
		Validation validation = new Validation();
		if(validation.emailValidate(email)) {
			response.getWriter().println("Valid Email");
			
			if(validation.passwordValidate(password)) {
				if(validation.passwordAndConfirmPasswordSame(password, confirmPassword)) {
					response.getWriter().println("Password & Confirm Password Matched");
					
					if(validation.mobileValidate(mobile)) {
						response.getWriter().println("Valid Mobile No");
						
						// if everything right and valid, let's add patient's data to database
						PatientsDetails patientsDetails = new PatientsDetails();
						patientsDetails.setFirstName(firstName);
						patientsDetails.setLastName(lastName);
						patientsDetails.setEmail(email);
						patientsDetails.setPassword(password);
						patientsDetails.setGender(gender);
						patientsDetails.setAge(age);
						patientsDetails.setMobile("+91-"+mobile);
						patientsDetails.setAddress(address);
						
						PatientsDAO dao = new PatientsDAO(DatabaseConnection.getDatabaseConnection());
						boolean res = dao.addPatientsData(patientsDetails);
						
						if(res) {
							System.out.println("Patient registered successfully !");
							session = request.getSession();
							session.setAttribute("register_success", "Patient registered successfully !");
							response.sendRedirect("../patients_records_maintenance/Patients/PatientsSignup.jsp");
						}
						else {
							System.out.println("Patient not registered. Something went wrong on server !");
							session = request.getSession();
							session.setAttribute("register_fail", "Patient not registered. Something went wrong on server !");
							response.sendRedirect("../patients_records_maintenance/Patients/PatientsSignup.jsp");
						}
						
					}
					else {
						System.out.println("Invalid mobile number. Please provide a valid mobile number.");
						session = request.getSession();
						session.setAttribute("invalid_mob", "Invalid mobile number. Please provide a valid mobile number.");
						response.sendRedirect("../patients_records_maintenance/Patients/PatientsLogin.jsp");
					}
				}
				else {
					System.out.println("Password & Confirm Password Not Matched.");
					session = request.getSession();
					session.setAttribute("pass_confirm_pass", "Password & Confirm Password Not Matched.");
					response.sendRedirect("../patients_records_maintenance/Patients/PatientsSignup.jsp");
				}
			}
			else {
				System.out.println("Invalid Password. Please provide a valid password.");
				session = request.getSession();
				session.setAttribute("invalid_pass", "Invalid Password. Please provide a valid password.");
				response.sendRedirect("../patients_records_maintenance/Patients/PatientsSignup.jsp");
			}
		}
		else {
			System.out.println("Invalid Email ID. Please provide a valid email address.");
			session = request.getSession();
			session.setAttribute("invalid_email", "Invalid Email ID. Please provide a valid email address.");
			response.sendRedirect("../patients_records_maintenance/Patients/PatientsSignup.jsp");
		}
		
		//System.out.println(firstName+"\n"+lastName+"\n"+email+"\n"+password+"\n"+confirmPassword+"\n"+gender+"\n"+mobile+"\n"+age+"\n"+address+"\n"+fileName);
	}

	public void getData(HttpServletRequest request) {
		firstName = request.getParameter("firstName").trim();
		lastName = request.getParameter("lastName").trim();
		email = request.getParameter("emailID").trim();
		password = request.getParameter("inputPassword").trim();
		confirmPassword = request.getParameter("inputConfirmPassword").trim();
		gender = request.getParameter("gender").trim();
		mobile = request.getParameter("mobileNumber").trim();
		age = request.getParameter("patientAge").trim();
		address = request.getParameter("inputAddress").trim();
	}
	
}
