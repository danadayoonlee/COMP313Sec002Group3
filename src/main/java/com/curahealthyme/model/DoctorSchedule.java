package com.curahealthyme.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctorSchedule")
public class DoctorSchedule {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long Id;

	@Column(name = "doctorId")
	public long DoctorId;

	@Column(name = "date")
	public Date Date;

	@Column(name = "availableStartTime")
	public Date AvailableStartTime;

	@Column(name = "availableEndTime")
	public Date AvailableEndTime;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getDoctorId() {
		return DoctorId;
	}

	public void setDoctorId(long doctorId) {
		DoctorId = doctorId;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public Date getAvailableStartTime() {
		return AvailableStartTime;
	}

	public void setAvailableStartTime(Date availableStartTime) {
		AvailableStartTime = availableStartTime;
	}

	public Date getAvailableEndTime() {
		return AvailableEndTime;
	}

	public void setAvailableEndTime(Date availableEndTime) {
		AvailableEndTime = availableEndTime;
	}

	public DoctorSchedule() {
	}
}
