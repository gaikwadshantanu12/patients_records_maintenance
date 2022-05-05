package com.shantanu.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownloadRecordFile")
public class DownloadRecordFile extends HttpServlet {
	public static int BUFFER_SIZE = 1024 * 100;
	public static final String UPLOAD_RECORDS_DIR = "uploaded_patients_records";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("fileName"),
			    applicationPath = getServletContext().getRealPath(""),
			    downloadPath = applicationPath + File.separator + UPLOAD_RECORDS_DIR,
			    filePath = downloadPath + File.separator + fileName;
		
		File file = new File(filePath);
		OutputStream outStream = null;
		FileInputStream inputStream = null;
		
		if (file.exists()) {
			   /**** Setting The Content Attributes For The Response Object ****/
			   String mimeType = "application/octet-stream";
			   response.setContentType(mimeType);
			   /**** Setting The Headers For The Response Object ****/
			   String headerKey = "Content-Disposition";
			   String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
			   response.setHeader(headerKey, headerValue);
			   
			   try {
				   /**** Get The Output Stream Of The Response ****/
				   outStream = response.getOutputStream();
				   inputStream = new FileInputStream(file);
				   byte[] buffer = new byte[BUFFER_SIZE];
				   int bytesRead = -1;
				   /**** Write Each Byte Of Data Read From The Input Stream Write Each Byte Of Data  Read From The Input Stream Into The Output Stream ****/
				   while ((bytesRead = inputStream.read(buffer)) != -1) {
					   	outStream.write(buffer, 0, bytesRead);
				   }    
			   	} catch(IOException ioExObj) {
				   System.out.println("Exception While Performing The I/O Operation?= " + ioExObj.getMessage());
			   	} finally {    
				   if (inputStream != null) {
					   inputStream.close();
				   }
				   outStream.flush();
				   if (outStream != null) {
					   outStream.close();
				   }
			  }
			} else {
			   /***** Set Response Content Type *****/
			   response.setContentType("text/html");
			   /***** Print The Response *****/
			   response.getWriter().println("<h3>File "+ fileName +" Is Not Present .....!</h3>");
			  }
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}