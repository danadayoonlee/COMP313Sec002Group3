package com.curahealthyme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient_ohip")
public class Patient_OHIP {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long Id;

	@Column(name = "patientid")
	public long PatientId;

	@Column(name = "ohip")
	public String Ohip;

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

	public String ohip() {
		return Ohip;
	}

	public void setOhip(String ohip) {
		Ohip = ohip;
	}

	public Patient_OHIP() {
	}
}
