package com.curahealthyme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "diseassSymptoms")
public class DiseaseSymptoms {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long Id;

	@Column(name = "diseaseid")
	public long DiseaseId;

	@Column(name = "symptomid")
	public long SymptomId;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getDiseaseId() {
		return DiseaseId;
	}

	public void setDiseaseId(long diseaseId) {
		DiseaseId = diseaseId;
	}

	public long getSymptomId() {
		return SymptomId;
	}

	public void setSymptomId(long symptomId) {
		SymptomId = symptomId;
	}

	public DiseaseSymptoms() {
	}
}
