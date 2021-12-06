package com.curahealthyme.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "patientdocument")
public class PatientDocument {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long Id;
	@Column(name = "patientid")
	private long PatientId;
	@Column(name = "doctorid")
	private long DoctorId;
	@Column(name = "documenttype")
	private String DocumentType;
	@Column(name = "filename")
	private String FileName;
	@Column(name = "filekey")
	private String FileKey;
	@Column(name = "dateposted")
	private Date DatePosted;
	@Column(name="patientname")
	private String PatientName;
	@Column(name="doctorname")
	private String DoctorName;

	public String getPatientName() {
		return PatientName;
	}
	public void setPatientName(String patientName) {
		PatientName = patientName;
	}
	public String getDoctorName() {
		return DoctorName;
	}
	public void setDoctorName(String doctorName) {
		DoctorName = doctorName;
	}
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
	public String getDocumentType() {
		return DocumentType;
	}
	public void setDocumentType(String documentType) {
		DocumentType = documentType;
	}
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public String getFileKey() {
		return FileKey;
	}
	public void setFileKey(String fileKey) {
		FileKey = fileKey;
	}
	public Date getDatePosted() {
		return DatePosted;
	}
	public void setDatePosted(Date datePosted) {
		DatePosted = datePosted;
	}

}
