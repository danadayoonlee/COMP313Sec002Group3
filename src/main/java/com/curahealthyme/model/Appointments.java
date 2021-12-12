package com.curahealthyme.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointments")
public class Appointments {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "appointmentid")
	private long AppointmentId;

	@Column(name = "joinid")
	public long JoinId;

	@Column(name = "appointmentstarttime")
	public Time AppointmentStartTime;

	@Column(name = "appointmentendtime")
	public Time AppointmentEndTime;
	@Column(name = "appointmentdate")
	public Date AppointmentDate;
	public Date getAppointmentDate() {
		return AppointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		AppointmentDate = appointmentDate;
	}

	public void setAppointmentStartTime(Time appointmentStartTime) {
		AppointmentStartTime = appointmentStartTime;
	}

	public void setAppointmentEndTime(Time appointmentEndTime) {
		AppointmentEndTime = appointmentEndTime;
	}

	@Column(name = "reasonforvisit")
	public String ReasonForVisit;
	@Column(name = "doctorid")
	public long DoctorId;

	public long getDoctorId() {
		return DoctorId;
	}

	public void setDoctorId(long doctorId) {
		DoctorId = doctorId;
	}

	public long getAppointmentId() {
		return AppointmentId;
	}

	public void setAppointmentId(long appointmentId) {
		AppointmentId = appointmentId;
	}

	public long getJoinId() {
		return JoinId;
	}

	public void setJoinId(long joinId) {
		JoinId = joinId;
	}

	public Time getAppointmentStartTime() {
		return AppointmentStartTime;
	}


	public Time getAppointmentEndTime() {
		return AppointmentEndTime;
	}

	public String getReasonForVisit() {
		return ReasonForVisit;
	}

	public void setReasonForVisit(String reasonForVisit) {
		ReasonForVisit = reasonForVisit;
	}

	public Appointments() {
	}
}
