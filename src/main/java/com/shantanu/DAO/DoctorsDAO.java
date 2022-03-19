package com.shantanu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shantanu.Doctor.DoctorsDetails;
import com.shantanu.Patients.PatientsDetails;

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
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return det;
	}
}
