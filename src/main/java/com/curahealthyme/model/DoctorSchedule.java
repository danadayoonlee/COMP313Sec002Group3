package com.curahealthyme.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.datetime.standard.DateTimeContext;

@Entity
@Table(name = "doctorSchedule")
public class DoctorSchedule {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long Id;

	@Column(name = "doctorid")
	public long DoctorId;

	@Column(name = "date")
	public Date Date;

	@Column(name = "availablestarttime")
	public Date AvailableStartTime;

	@Column(name = "availableendtime")
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
