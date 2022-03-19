package com.shantanu.DatabaseConnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private static Connection connection;
	
	public static Connection getDatabaseConnection() {
		try {
			if(connection == null) {
				//System.out.println("Driver registration started");
				Class.forName("com.mysql.cj.jdbc.Driver");
				//System.out.println("Driver is registered");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/patients_records_maintenance","shantanu","shantanu");
				//System.out.println("Connected to database !");
			}
		} 
		catch(Exception e) {
			System.out.println(e);
		}
		return connection;
	}
}