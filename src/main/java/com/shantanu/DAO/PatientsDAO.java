package com.shantanu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shantanu.Doctor.DoctorsDetails;
import com.shantanu.Patients.PatientsDetails;
import com.shantanu.Patients.PatientsRecordDetails;
import com.shantanu.Patients.ViewAllPatientsRecords;

public class PatientsDAO {
	private Connection connection;

	public PatientsDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public boolean addPatientsData(PatientsDetails details) {
		boolean res = false;
		
		try {
			String query = "INSERT INTO patients_details(first_name,last_name, email_id, password, gender, mobile_no, age, address) values(?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, details.getFirstName());
			preparedStatement.setString(2, details.getLastName());
			preparedStatement.setString(3, details.getEmail());
			preparedStatement.setString(4, details.getPassword());
			preparedStatement.setString(5, details.getGender());
			preparedStatement.setString(6, details.getMobile());
			preparedStatement.setString(7, details.getAge());
			preparedStatement.setString(8, details.getAddress());
			
			int i = preparedStatement.executeUpdate();
			if(i== 1) {
				res = true;
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public PatientsDetails loginPatients(PatientsDetails details) {
		PatientsDetails det = null;
		try {
			String query = "SELECT * FROM patients_details WHERE email_id=? and password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, details.getEmail());
			preparedStatement.setString(2, details.getPassword());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				det = new PatientsDetails();
				det.setEmail(resultSet.getString("email_id"));
				det.setFirstName(resultSet.getString("first_name"));
				det.setLastName(resultSet.getString("last_name"));
				det.setPassword(resultSet.getString("password"));
				det.setPatientID(resultSet.getInt("patient_uid"));
				det.setGender(resultSet.getString("gender"));
				det.setMobile(resultSet.getString("mobile_no"));
				det.setAddress(resultSet.getString("address"));
				det.setAge(resultSet.getString("age"));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return det;
	}
	
	public List<ViewAllPatientsRecords> getAllPatientsDetails(int patientsID){
		List<ViewAllPatientsRecords> list = new ArrayList<ViewAllPatientsRecords>();
		ViewAllPatientsRecords patientsRecordsDetails = null;
		
		try {
			String query = "SELECT * FROM patients_records WHERE patients_uid=?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, patientsID);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				patientsRecordsDetails = new ViewAllPatientsRecords();
				patientsRecordsDetails.setRecordsID(resultSet.getInt("records_id"));
				patientsRecordsDetails.setDiseaseName(resultSet.getString("disease_name"));
				patientsRecordsDetails.setDiseaseDescription(resultSet.getString("disease_description"));
				patientsRecordsDetails.setDate(resultSet.getDate("uploaded_date"));
				patientsRecordsDetails.SetTime(resultSet.getTime("uploaded_date"));
				patientsRecordsDetails.setPatientsUID(resultSet.getInt("patients_uid"));
				
				list.add(patientsRecordsDetails);
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	public List<DoctorsDetails> getAvailableDoctors(){
		List<DoctorsDetails> list = new ArrayList<DoctorsDetails>();
		DoctorsDetails doctorsDetails = null;
		
		try {
			String query = "SELECT * FROM doctors_details";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				doctorsDetails = new DoctorsDetails();
				doctorsDetails.setDoctorID(resultSet.getInt("doctor_uid"));
				doctorsDetails.setFirstName(resultSet.getString("first_name"));
				doctorsDetails.setLastName(resultSet.getString("last_name"));
				doctorsDetails.setEmail(resultSet.getString("email_id"));
				doctorsDetails.setPassword(resultSet.getString("password"));
				doctorsDetails.setMobile1(resultSet.getString("mobile_no1"));
				doctorsDetails.setMobile2(resultSet.getString("mobile_no2"));
				doctorsDetails.setEducationDetails(resultSet.getString("education_details"));
				doctorsDetails.setHospitalName(resultSet.getString("hospital_name"));
				doctorsDetails.setHospitalAddress(resultSet.getString("hospital_address"));
				
				list.add(doctorsDetails);
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	public boolean addPatientsRecords(PatientsRecordDetails details) {
		boolean res = false;
		
		try {
			String query = "INSERT INTO patients_records(disease_name, disease_description, patients_uid) values(?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, details.getDiseaseName());
			preparedStatement.setString(2, details.getDiseaseDescription());
			preparedStatement.setInt(3, details.getPatientID());
			
			int i = preparedStatement.executeUpdate();
			if(i== 1) {
				res = true;
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
}
