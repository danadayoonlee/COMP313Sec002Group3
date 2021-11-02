package com.curahealthyme.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patientcovid19screening")
public class PatientCOVID19Screening {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long Id;

	@Column(name = "patientid")
	public long PatientId;

	@Column(name = "testdate")
	public Date TestDate;

	@Column(name = "result")
	public String Result;
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getPatientId() {
		return PatientId;
	}

	public void setPatientId(long patientId) {
		PatientId = patientId;
	}

	public Date getTestDate() {
		return TestDate;
	}

	public void setTestDate(Date testDate) {
		TestDate = testDate;
	}
	
	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}

	public PatientCOVID19Screening() {
	}
}
