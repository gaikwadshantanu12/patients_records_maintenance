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

@WebServlet("/AddNewRecords")
public class AddNewRecords extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session;
		int patientsID = Integer.parseInt(request.getParameter("patientsID"));
		String diseaseName = request.getParameter("diseaseName");
		String diseaseDescrption = request.getParameter("diseaseDescription");
		
		PatientsRecordDetails details = new PatientsRecordDetails();
		details.setPatientID(patientsID);
		details.setDiseaseName(diseaseName);
		details.setDiseaseDescription(diseaseDescrption);
		
		PatientsDAO dao = new PatientsDAO(DatabaseConnection.getDatabaseConnection());
		boolean result = dao.addPatientsRecords(details);
		
		if(result) {
			System.out.println("Patient's Record Inserted Successfully !");
			session = request.getSession();
			session.setAttribute("record-inserted", "Patient's Record Inserted Successfully !");
			response.sendRedirect("../patients_records_maintenance/Patients/AddNewRecords.jsp");
		}
		else {
			System.out.println("Patient's Record Not Inserted !");
			session = request.getSession();
			session.setAttribute("record-not-inserted", "Patient's Record Not Inserted !");
			response.sendRedirect("../patients_records_maintenance/Patients/AddNewRecords.jsp");
		}
		
		System.out.println("Patients ID - "+patientsID+"\nDisease Name - "+diseaseName+"\nDisease Description - "+diseaseDescrption);
	}

}
