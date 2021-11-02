package com.curahealthyme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "disease")
public class Disease {

	@Id
	@GeneratedValue
	@Column(name = "diseaseid")
	private long DiseaseId;

	@Column(name = "diseasename")
	public String DiseaseName;

	public long getDiseaseId() {
		return DiseaseId;
	}

	public void setDiseaseId(long diseaseId) {
		DiseaseId = diseaseId;
	}

	public String getDiseaseName() {
		return DiseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		DiseaseName = diseaseName;
	}

	public Disease() {
	}
}
