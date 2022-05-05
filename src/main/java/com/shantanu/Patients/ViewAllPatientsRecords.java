package com.shantanu.Patients;

import java.sql.Time;
import java.util.Date;

public class ViewAllPatientsRecords {
	private int recordsID, patientsUID;
	private String diseaseName, diseaseDescription, diseaseFile;
	private Date date;
	private Time time;
	
	public ViewAllPatientsRecords() {
		super();
	}

	public ViewAllPatientsRecords(int recordsID, int patientsUID, String diseaseName, String diseaseDescription,
			Date date, Time time, String diseaseFile) {
		super();
		this.recordsID = recordsID;
		this.patientsUID = patientsUID;
		this.diseaseName = diseaseName;
		this.diseaseDescription = diseaseDescription;
		this.date = date;
		this.time = time;
		this.diseaseFile = diseaseFile;
	}
	
	public String getDiseaseFile() {
		return diseaseFile;
	}

	public void setDiseaseFile(String diseaseFile) {
		this.diseaseFile = diseaseFile;
	}

	public int getRecordsID() {
		return recordsID;
	}
	public void setRecordsID(int recordsID) {
		this.recordsID = recordsID;
	}
	public int getPatientsUID() {
		return patientsUID;
	}
	public void setPatientsUID(int patientsUID) {
		this.patientsUID = patientsUID;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void SetTime(Time time) {
		this.time = time;
	}
	
}
