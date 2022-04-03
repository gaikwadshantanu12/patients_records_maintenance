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

@WebServlet("/EnrolledDoctor")
public class EnrolledDoctor extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int doctor_id = Integer.parseInt(request.getParameter("doctor_id"));
		int patient_id = Integer.parseInt(request.getParameter("patient_id"));
		
		//System.out.println("Doctor ID = "+doctor_id+"\nPatient ID = "+patient_id);
		
		PatientsDAO dao = new PatientsDAO(DatabaseConnection.getDatabaseConnection());
		boolean res = dao.enrolledDoctor(patient_id, doctor_id);
		
		HttpSession session = null;
		if(res) {
			//System.out.println("Doctor Enrolled Successfully !");
			session = request.getSession();
			session.setAttribute("doctor_enrolled_success", "Doctor Enrolled Successfully !");
			response.sendRedirect("../patients_records_maintenance/Patients/DoctorsAvailable.jsp");
		}
		else{
			session = request.getSession();
			session.setAttribute("doctor_enrolled_error", "Something Went Wrong ! Doctor Not Enrolled !");
			response.sendRedirect("../patients_records_maintenance/Patients/DoctorsAvailable.jsp");
			//System.out.println("Doctor Not Enrolled !");
		}
	}

}
