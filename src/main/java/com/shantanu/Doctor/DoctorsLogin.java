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

@WebServlet("/DoctorsLogin")
public class DoctorsLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("inputEmail");
		String password = request.getParameter("inputPassword");
		
		DoctorsDetails details = new DoctorsDetails();
		details.setEmail(email);
		details.setPassword(password);
		
		DoctorsDAO dao = new DoctorsDAO(DatabaseConnection.getDatabaseConnection());
		DoctorsDetails details2 = dao.loginDoctors(details);
		
		if(details2 != null) {
			System.out.println("Doctor's Login Success !");
			HttpSession session = request.getSession();
			session.setAttribute("doctorsdetails2", details2);
			response.sendRedirect("../patients_records_maintenance/Doctors/DoctorsDashboard.jsp");
		}
		else {
			System.out.println("Doctor's Login Failed");
			HttpSession session = request.getSession();
			session.setAttribute("login_failed", "Please check doctor's login credentials");
			response.sendRedirect("../patients_records_maintenance/Doctors/DoctorsLogin.jsp");
		}
	}

}
