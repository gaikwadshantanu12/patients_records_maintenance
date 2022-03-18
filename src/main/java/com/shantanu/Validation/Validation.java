package com.shantanu.Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	// Email validation function
	public boolean emailValidate(String email) {
		boolean res = false;
		String emailRegex  = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);
		
		if(matcher.matches()) {
			res = true;
			//System.out.println("It is a valid email address");
		}
		else {
			//System.out.println("It is not a valid email address");
		}
		return res;
	}
	
	// Password validation function
	public boolean passwordValidate(String password) {
		boolean res = false;
		String passwordRegex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$";
		Pattern pattern = Pattern.compile(passwordRegex);
		Matcher matcher = pattern.matcher(password);
		
		if(matcher.matches()) {
			res = true;
			//System.out.println("It is a valid password");
		}
		else {
			//System.out.println("It is not a valid password");
		}
		return res;
	}
		
	// Check if password and confirm password provided by user is same or not. 
	// If same then proceed else show error.
	public boolean passwordAndConfirmPasswordSame(String password, String confirmPassword) {
		boolean res = false;
		if(password.equals(confirmPassword)) {
			res = true;
			//System.out.println("Password & Confirm Password Matches");
		}
		else {
			//System.out.println("Password & Confirm Password do not matched");
		}
		return res;
	}
	
	// Mobile Number validation
	public boolean mobileValidate(String mobile) {
		boolean res = false;
		
		String mobileRegex = "(0|91)?[7-9][0-9]{9}";
		Pattern pattern = Pattern.compile(mobileRegex);
		Matcher matcher = pattern.matcher(mobile);
		
		if(matcher.matches()) {
			res = true;
			//System.out.println("It is a valid mobile number");
		}
		else {
			//System.out.println("It is not a valid mobile number");
		}
		return res;
	}
}
