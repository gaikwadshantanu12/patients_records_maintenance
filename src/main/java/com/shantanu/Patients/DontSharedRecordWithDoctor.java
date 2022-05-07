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

@WebServlet("/DontSharedRecordWithDoctor")
public class DontSharedRecordWithDoctor extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int doctor_id = Integer.parseInt(request.getParameter("doctor_id"));
		int patient_id = Integer.parseInt(request.getParameter("patient_id"));
		int records_id = Integer.parseInt(request.getParameter("records_id"));
		
		PatientsDAO dao = new PatientsDAO(DatabaseConnection.getDatabaseConnection());
		boolean res = dao.dontShareDataWithDoctor(records_id, patient_id, doctor_id);
		
		HttpSession session = null;
		if(res) {
			System.out.println("Successfully Deleted The Data With Enrolled Doctor !");
			session = request.getSession();
			session.setAttribute("data_dont_shared_success", "Successfully Deleted The Data With Enrolled Doctor !");
			response.sendRedirect("../patients_records_maintenance/Patients/ViewAllRecords.jsp");
		}
		else{
			session = request.getSession();
			session.setAttribute("data_dont_shared_failure", "Something Went Wrong ! Data Not Deleted With Enrolled Doctor !");
			response.sendRedirect("../patients_records_maintenance/Patients/ViewAllRecords.jsp");
			System.out.println("Something Went Wrong ! Data Not Deleted With Enrolled Doctor !");
		}
	}
}