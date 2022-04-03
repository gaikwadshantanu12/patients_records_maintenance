package com.shantanu.Patients;

public class EnrolledDoctorsList {
	private int patientID, doctorID, enrolled_doctor_id;

	public EnrolledDoctorsList() {
		super();
	}

	public EnrolledDoctorsList(int patientID, int doctorID, int enrolled_doctor_id) {
		super();
		this.patientID = patientID;
		this.doctorID = doctorID;
		this.enrolled_doctor_id = enrolled_doctor_id;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public int getEnrolled_doctor_id() {
		return enrolled_doctor_id;
	}

	public void setEnrolled_doctor_id(int enrolled_doctor_id) {
		this.enrolled_doctor_id = enrolled_doctor_id;
	}
}
