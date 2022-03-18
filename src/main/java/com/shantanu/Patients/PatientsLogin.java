package com.shantanu.Patients;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shantanu.DAO.PatientsDAO;
import com.shantanu.DatabaseConnect.DatabaseConnection;

@WebServlet("/PatientsLogin")
public class PatientsLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("inputEmail");
		String password = request.getParameter("inputPassword");
		
		PatientsDetails details = new PatientsDetails();
		details.setEmail(email);
		details.setPassword(password);
		
		PatientsDAO dao = new PatientsDAO(DatabaseConnection.getDatabaseConnection());
		PatientsDetails details2 = dao.loginPatients(details);
		
		if(details2 != null) {
			HttpSession session = request.getSession();
			session.setAttribute("details2", details2);
			response.sendRedirect("../patients_records_maintenance/Patients/PatientsDashboard.jsp");
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("login_failed", "Please check user credentials");
			response.sendRedirect("../patients_records_maintenance/Patients/PatientsLogin.jsp");
		}
	}

}
