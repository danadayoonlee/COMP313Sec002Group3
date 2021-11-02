package com.curahealthyme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "symptoms")
public class Symptoms {

	@Id
	@GeneratedValue
	@Column(name = "symptomid")
	private long SymptomId;

	@Column(name = "symptomname")
	public String SymptomName;
	
	@Column(name = "description")
	public String Description;
	
	public long getSymptomId() {
		return SymptomId;
	}

	public void setSymptomId(long symptomId) {
		SymptomId = symptomId;
	}
	
	public String getSymptomName() {
		return SymptomName;
	}

	public void setSymptomName(String symptomName) {
		SymptomName = symptomName;
	}
	
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	public Symptoms() {
	}
}
