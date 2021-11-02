package com.curahealthyme.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patientprescriptions")
public class PatientPrescriptions {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private long Id;

	@Column(name = "joinid")
	public long JoinId;

	@Column(name = "prescriptionid")
	public long PrescriptionId;

	@Column(name = "dateprescribed")
	public Date DatePrescribed;

	@Column(name = "description")
	public String Description;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getJoinId() {
		return JoinId;
	}

	public void setJoinId(long joinId) {
		JoinId = joinId;
	}

	public long getPrescriptionId() {
		return PrescriptionId;
	}

	public void setPrescriptionId(long prescriptionId) {
		PrescriptionId = prescriptionId;
	}

	public Date getDatePrescribed() {
		return DatePrescribed;
	}

	public void setDatePrescribed(Date datePrescribed) {
		DatePrescribed = datePrescribed;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public PatientPrescriptions() {
	}

	public PatientPrescriptions(long joinid, long prescriptionid, Date dateprescribed, String desc) {
		this.JoinId = joinid;
		this.PrescriptionId = prescriptionid;
		this.DatePrescribed = dateprescribed;
		this.Description = desc;
	}
}
