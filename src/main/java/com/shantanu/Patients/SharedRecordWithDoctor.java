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

@WebServlet("/SharedRecordWithDoctor")
public class SharedRecordWithDoctor extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int doctor_id = Integer.parseInt(request.getParameter("doctor_id"));
		int patient_id = Integer.parseInt(request.getParameter("patient_id"));
		int records_id = Integer.parseInt(request.getParameter("records_id"));
		
		//System.out.println("Doctor ID = "+doctor_id+"\nPatient ID = "+patient_id+"\nRecord ID = "+records_id);
		
		PatientsDAO dao = new PatientsDAO(DatabaseConnection.getDatabaseConnection());
		boolean res = dao.shareDataWithDoctor(records_id, patient_id, doctor_id);
		
		HttpSession session = null;
		if(res) {
			//System.out.println("Doctor Enrolled Successfully !");
			session = request.getSession();
			session.setAttribute("data_shared_success", "Successfully Shared The Data With Enrolled Doctor !");
			response.sendRedirect("../patients_records_maintenance/Patients/ViewAllRecords.jsp");
		}
		else{
			session = request.getSession();
			session.setAttribute("data_shared_failure", "Something Went Wrong ! Data Not Shared With Enrolled Doctor !");
			response.sendRedirect("../patients_records_maintenance/Patients/ViewAllRecords.jsp");
			//System.out.println("Doctor Not Enrolled !");
		}
	}
}