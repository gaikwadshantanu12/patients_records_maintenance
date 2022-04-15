package com.shantanu.Doctor;

public class SharedDataList {
	private int patientsID, doctorsID, recordsID, shared_record_id;

	public SharedDataList() {
		super();
	}

	public SharedDataList(int patientsID, int doctorsID, int recordsID, int shared_record_id) {
		super();
		this.patientsID = patientsID;
		this.doctorsID = doctorsID;
		this.recordsID = recordsID;
		this.shared_record_id = shared_record_id;
	}

	public int getPatientsID() {
		return patientsID;
	}

	public void setPatientsID(int patientsID) {
		this.patientsID = patientsID;
	}

	public int getDoctorsID() {
		return doctorsID;
	}

	public void setDoctorsID(int doctorsID) {
		this.doctorsID = doctorsID;
	}

	public int getRecordsID() {
		return recordsID;
	}

	public void setRecordsID(int recordsID) {
		this.recordsID = recordsID;
	}

	public int getShared_record_id() {
		return shared_record_id;
	}

	public void setShared_record_id(int shared_record_id) {
		this.shared_record_id = shared_record_id;
	}
}
