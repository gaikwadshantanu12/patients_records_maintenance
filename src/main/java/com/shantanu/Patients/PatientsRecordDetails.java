package com.shantanu.Patients;

public class PatientsRecordDetails {
	private int patientID, recordsID;
	private String diseaseName, diseaseDescription, fileName;
	
	public PatientsRecordDetails() {
		super();
	}

	public PatientsRecordDetails(int patientID, String diseaseName, String diseaseDescription, String fileName) {
		super();
		this.patientID = patientID;
		this.diseaseName = diseaseName;
		this.diseaseDescription = diseaseDescription;
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getRecordsID() {
		return recordsID;
	}

	public void setRecordsID(int recordsID) {
		this.recordsID = recordsID;
	}

	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public String getDiseaseDescription() {
		return diseaseDescription;
	}
	public void setDiseaseDescription(String diseaseDescription) {
		this.diseaseDescription = diseaseDescription;
	}
}
