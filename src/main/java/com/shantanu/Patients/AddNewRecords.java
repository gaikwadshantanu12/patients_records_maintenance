package com.shantanu.Patients;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/AddNewRecords")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30, maxRequestSize = 1024 * 1024 * 50)

public class AddNewRecords extends HttpServlet {
	public static final String UPLOAD_RECORDS_DIR = "uploaded_patients_records";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session;
		int patientsID = Integer.parseInt(request.getParameter("patientsID"));
		String diseaseName = request.getParameter("diseaseName");
		String diseaseDescrption = request.getParameter("diseaseDescription");
		String fileName = "";
		
		String applicationPath = getServletContext().getRealPath(""),
			    uploadPath = applicationPath + File.separator + UPLOAD_RECORDS_DIR;
		
		File fileUploadDirectory = new File(uploadPath);
		if (!fileUploadDirectory.exists()) {
			fileUploadDirectory.mkdirs();
		}
		
		UploadDAO fileDao = null;
		
		List<UploadDAO> fileList = new ArrayList<UploadDAO>();
		for (Part part : request.getParts()) {
			fileName = extractFileName(part);
			fileName = "user_id_" + patientsID + "_" + fileName;
			fileDao = new UploadDAO();
			fileDao.setFileName(fileName);
			fileDao.setFileSize(part.getSize() / 1024);
			
			try {
				part.write(uploadPath + File.separator + fileName);
				fileDao.setUploadStatus("Success");
			} catch (IOException ioObj) {
			   fileDao.setUploadStatus("Failure : "+ ioObj.getMessage());
			}
			fileList.add(fileDao);
		}
		
//		request.setAttribute("uploadedFiles", fileList);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("../patients_records_maintenance/Patients/AddNewRecords.jsp");
//		dispatcher.forward(request, response);
		
		PatientsRecordDetails details = new PatientsRecordDetails();
		details.setPatientID(patientsID);
		details.setDiseaseName(diseaseName);
		details.setDiseaseDescription(diseaseDescrption);
		details.setFileName(fileName);		//file name uploaded to database
		
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
		
		System.out.println("Patients ID - "+patientsID+"\nDisease Name - "+diseaseName+"\nDisease Description - "+diseaseDescrption+"\nFile Name - "+fileName);
	}

	private String extractFileName(Part part) {
		String fileName = "", 
		contentDisposition = part.getHeader("content-disposition");
		String[] items = contentDisposition.split(";");
		for (String item : items) {
			if (item.trim().startsWith("filename")) {
				fileName = item.substring(item.indexOf("=") + 2, item.length() - 1);
		   }
		}
		return fileName;
	}
}