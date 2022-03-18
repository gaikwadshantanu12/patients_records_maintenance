package com.shantanu.Patients;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PatientsLogout")
public class PatientsLogout extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			session.removeAttribute("details2");
			
			HttpSession session2 = request.getSession();
			session.setAttribute("logout-message", "Logout Successfully !");
			
			response.sendRedirect("../patients_records_maintenance/Patients/PatientsLogin.jsp");
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
	}

}
