package com.curahealthyme.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "doctorschedule")
public class DoctorSchedule {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "id")
	private long Id;

	@Column(name = "doctorid")
	public long DoctorId;

	@Column(name = "date")
	public Date Date;

	@Column(name = "availablestarttime")
	public Time AvailableStartTime;

	@Column(name = "availableendtime")
	public Time AvailableEndTime;

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

	public Time getAvailableStartTime() {
		return AvailableStartTime;
	}

	public void setAvailableStartTime(Time availableStartTime) {
		AvailableStartTime = availableStartTime;
	}

	public Time getAvailableEndTime() {
		return AvailableEndTime;
	}

	public void setAvailableEndTime(Time availableEndTime) {
		AvailableEndTime = availableEndTime;
	}

	public DoctorSchedule() {
	}
}
