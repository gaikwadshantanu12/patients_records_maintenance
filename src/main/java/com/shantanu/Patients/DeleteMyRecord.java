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

@WebServlet("/DeleteMyRecord")
public class DeleteMyRecord extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int patient_id = Integer.parseInt(request.getParameter("patient_id"));
		int records_id = Integer.parseInt(request.getParameter("records_id"));
		
		PatientsDAO dao = new PatientsDAO(DatabaseConnection.getDatabaseConnection());
		boolean res = dao.deleteMyRecord(patient_id, records_id);
		
		HttpSession session = null;
		if(res) {
			System.out.println("Successfully Deleted The Record !");
			session = request.getSession();
			session.setAttribute("data_deleted_success", "Successfully Deleted The Record !");
			response.sendRedirect("../patients_records_maintenance/Patients/ViewAllRecords.jsp");
		}
		else{
			session = request.getSession();
			session.setAttribute("data_deleted_failure", "Record Not Deleted !");
			response.sendRedirect("../patients_records_maintenance/Patients/ViewAllRecords.jsp");
			System.out.println("Record Not Deleted !");
		}
	}
}