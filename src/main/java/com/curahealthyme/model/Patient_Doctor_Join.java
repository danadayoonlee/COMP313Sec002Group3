package com.curahealthyme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient_Doctor_Join")
public class Patient_Doctor_Join {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long Id;

	@Column(name = "patientId")
	public long PatientId;

	@Column(name = "doctorId")
	public long DoctorId;

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

	public long getDoctorId() {
		return DoctorId;
	}

	public void setDoctorId(long doctorId) {
		DoctorId = doctorId;
	}

	public Patient_Doctor_Join() {
	}
}
