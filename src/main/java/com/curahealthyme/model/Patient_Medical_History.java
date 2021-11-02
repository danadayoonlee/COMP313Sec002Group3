package com.curahealthyme.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient_Medical_History")
public class Patient_Medical_History {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long Id;
	
	@Column(name = "joinId")
	public long JoinId;

	@Column(name = "dateVisited")
	public Date DateVisited;
	
	@Column(name = "reasonForVisit")
	public String ReasonForVisit;

	@Column(name = "problems")
	public String Problems;

	@Column(name = "medications")
	public String Medications;
	
	@Column(name = "allergies")
	public String Allergies;

	@Column(name = "servicesDue")
	public String ServicesDue;
	
	@Column(name = "locationOfVisit")
	public String LocationOfVisit;

	@Column(name = "diseaseId")
	public long DiseaseId;
	
	@Column(name = "treatment")
	public String Treatment;

	@Column(name = "followUp")
	public Date FollowUp;

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

	public Date getDateVisited() {
		return DateVisited;
	}

	public void setDateVisited(Date dateVisited) {
		DateVisited = dateVisited;
	}
	
	public String getReasonForVisit() {
		return ReasonForVisit;
	}

	public void setReasonForVisit(String reasonForVisit) {
		ReasonForVisit = reasonForVisit;
	}
	
	public String getProblems() {
		return Problems;
	}

	public void setProblems(String problems) {
		Problems = problems;
	}
	
	public String getMedications() {
		return Medications;
	}

	public void setMedications(String medications) {
		Medications = medications;
	}
	
	public String getAllergies() {
		return Allergies;
	}

	public void setAllergies(String allergies) {
		Allergies = allergies;
	}
	
	public String getServicesDue() {
		return ServicesDue;
	}

	public void setServicesDue(String servicesDue) {
		ServicesDue = servicesDue;
	}
	
	public String getLocationOfVisit() {
		return LocationOfVisit;
	}

	public void setLocationOfVisit(String locationOfVisit) {
		LocationOfVisit = locationOfVisit;
	}
	
	public long getDiseaseId() {
		return DiseaseId;
	}

	public void setDiseaseId(long diseaseId) {
		DiseaseId = diseaseId;
	}
	
	public String getTreatment() {
		return Treatment;
	}

	public void setTreatment(String treatment) {
		Treatment = treatment;
	}
	
	public Date getFollowUp() {
		return FollowUp;
	}

	public void setFollowUp(Date followUp) {
		FollowUp = followUp;
	}

	public Patient_Medical_History() {
	}
}
