package com.shantanu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shantanu.Doctor.DoctorsDetails;
import com.shantanu.Doctor.EnrolledPatientList;
import com.shantanu.Doctor.SharedDataList;
import com.shantanu.Patients.EnrolledDoctorsList;
import com.shantanu.Patients.PatientsDetails;
import com.shantanu.Patients.PatientsRecordDetails;

public class DoctorsDAO {
	private Connection connection;

	public DoctorsDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public boolean addDoctorsData(DoctorsDetails details) {
		boolean res = false;
		
		try {
			String query = "INSERT INTO doctors_details(first_name, last_name, email_id, password, mobile_no1, mobile_no2, education_details, hospital_name, hospital_address) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, details.getFirstName());
			preparedStatement.setString(2, details.getLastName());
			preparedStatement.setString(3, details.getEmail());
			preparedStatement.setString(4, details.getPassword());
			preparedStatement.setString(5, details.getMobile1());
			preparedStatement.setString(6, details.getMobile2());
			preparedStatement.setString(7, details.getEducationDetails());
			preparedStatement.setString(8, details.getHospitalName());
			preparedStatement.setString(9, details.getHospitalAddress());
			
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
	
	public DoctorsDetails loginDoctors(DoctorsDetails details) {
		DoctorsDetails det = null;
		try {
			String query = "SELECT * FROM doctors_details WHERE email_id=? and password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, details.getEmail());
			preparedStatement.setString(2, details.getPassword());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				det = new DoctorsDetails();
				det.setEmail(resultSet.getString("email_id"));
				det.setFirstName(resultSet.getString("first_name"));
				det.setLastName(resultSet.getString("last_name"));
				det.setPassword(resultSet.getString("password"));
				det.setDoctorID(resultSet.getInt("doctor_uid"));
				det.setMobile1(resultSet.getString("mobile_no1"));
				det.setMobile2(resultSet.getString("mobile_no2"));
				det.setEducationDetails(resultSet.getString("education_details"));
				det.setHospitalName(resultSet.getString("hospital_name"));
				det.setHospitalAddress(resultSet.getString("hospital_address"));
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return det;
	}
	
	public List<EnrolledPatientList> getListOfMyPatients(int doctorID) {
		List<EnrolledPatientList> list = new ArrayList<EnrolledPatientList>();
		EnrolledPatientList patientList = null;
		try {
			String query = "SELECT * FROM patients_enrolled_doctor WHERE doctor_uid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, doctorID);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				patientList = new EnrolledPatientList();
				patientList.setDoctorID(resultSet.getInt("doctor_uid"));
				patientList.setPatientID(resultSet.getInt("patient_uid"));
				patientList.setEnrolled_doctor_id(resultSet.getInt("patients_enrolled_dr"));
				list.add(patientList);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	public PatientsDetails getParticularPatient(int patientID) {
		PatientsDetails patientsDetails = null;
		try {
			String query = "SELECT * FROM patients_details WHERE patient_uid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, patientID);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				patientsDetails = new PatientsDetails();
				patientsDetails.setPatientID(resultSet.getInt("patient_uid"));
				patientsDetails.setFirstName(resultSet.getString("first_name"));
				patientsDetails.setLastName(resultSet.getString("last_name"));
				patientsDetails.setEmail(resultSet.getString("email_id"));
				patientsDetails.setMobile(resultSet.getString("mobile_no"));
				patientsDetails.setAge(resultSet.getString("age"));
				patientsDetails.setAddress(resultSet.getString("address"));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return patientsDetails;
	}
	
	public List<SharedDataList> getListOfDataSharedWithMe(int doctorID) {
		List<SharedDataList> list = new ArrayList<SharedDataList>();
		SharedDataList sharedDataList = null;
		try {
			String query = "SELECT * FROM patients_shared_record_with_doctor WHERE doctor_uid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, doctorID);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				sharedDataList = new SharedDataList();
				sharedDataList.setDoctorsID(resultSet.getInt("doctor_uid"));;
				sharedDataList.setPatientsID(resultSet.getInt("patient_uid"));
				sharedDataList.setRecordsID(resultSet.getInt("records_id"));
				sharedDataList.setShared_record_id(resultSet.getInt("shared_record_id"));
				list.add(sharedDataList);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public PatientsRecordDetails getParticularPatientRecordDetails(int patientID, int recordID) {
		PatientsRecordDetails patientsRecordDetails = null;
		try {
			String query = "SELECT * FROM patients_records WHERE patients_uid=? AND records_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, patientID);
			preparedStatement.setInt(2, recordID);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				patientsRecordDetails = new PatientsRecordDetails();
				patientsRecordDetails.setPatientID(resultSet.getInt("patients_uid"));
				patientsRecordDetails.setRecordsID(resultSet.getInt("records_id"));
				patientsRecordDetails.setDiseaseName(resultSet.getString("disease_name"));
				patientsRecordDetails.setDiseaseDescription(resultSet.getString("disease_description"));
				patientsRecordDetails.setFileName(resultSet.getString("disease_file_name"));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return patientsRecordDetails;
	}
}
