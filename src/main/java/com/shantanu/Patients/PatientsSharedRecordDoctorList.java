package com.shantanu.Patients;

public class PatientsSharedRecordDoctorList {
	private int patient_id, doctor_id, shared_record_id, records_id;

	public PatientsSharedRecordDoctorList(int patient_id, int doctor_id, int shared_record_id, int records_id) {
		super();
		this.patient_id = patient_id;
		this.doctor_id = doctor_id;
		this.shared_record_id = shared_record_id;
		this.records_id = records_id;
	}

	public PatientsSharedRecordDoctorList() {
		super();
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public int getShared_record_id() {
		return shared_record_id;
	}

	public void setShared_record_id(int shared_record_id) {
		this.shared_record_id = shared_record_id;
	}

	public int getRecords_id() {
		return records_id;
	}

	public void setRecords_id(int records_id) {
		this.records_id = records_id;
	}
	
}
