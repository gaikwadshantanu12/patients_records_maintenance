package com.shantanu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shantanu.Patients.PatientsDetails;

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
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return det;
	}
}
