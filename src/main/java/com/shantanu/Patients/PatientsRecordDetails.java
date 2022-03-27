package com.shantanu.Patients;

public class PatientsRecordDetails {
	private int patientID;
	private String diseaseName, diseaseDescription;
	
	public PatientsRecordDetails() {
		super();
	}

	public PatientsRecordDetails(int patientID, String diseaseName, String diseaseDescription) {
		super();
		this.patientID = patientID;
		this.diseaseName = diseaseName;
		this.diseaseDescription = diseaseDescription;
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
