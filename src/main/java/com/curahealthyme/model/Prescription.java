package com.curahealthyme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prescription")
public class Prescription {

	@Id
	@GeneratedValue
	@Column(name="prescriptionId")
	private long PrescriptionId;
	
	@Column(name="medicationName")
	public String MedicationName;
	
	@Column(name="doseQty")
	public String DoseQty;

	public long getPrescriptionId() {
		return PrescriptionId;
	}

	public void setPrescriptionId(long prescriptionId) {
		PrescriptionId = prescriptionId;
	}

	public String getMedicationName() {
		return MedicationName;
	}

	public void setMedicationName(String medicationName) {
		MedicationName = medicationName;
	}
	
	public String getDoseQty() {
		return DoseQty;
	}

	public void setDoseQty(String doseQty) {
		DoseQty = doseQty;
	}
	
	public Prescription() {}
}
