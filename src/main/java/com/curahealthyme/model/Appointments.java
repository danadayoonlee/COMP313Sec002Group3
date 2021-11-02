package com.curahealthyme.model;

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
	@GeneratedValue
	@Column(name = "appointmentId")
	private long AppointmentId;

	@Column(name = "joinid")
	public long JoinId;

	@Column(name = "appointmentStartTime")
	public Date AppointmentStartTime;

	@Column(name = "appointmentEndTime")
	public Date AppointmentEndTime;

	@Column(name = "reasonForVisit")
	public String ReasonForVisit;

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

	public Date getAppointmentStartTime() {
		return AppointmentStartTime;
	}

	public void setAppointmentStartTime(Date appointmentStartTime) {
		AppointmentStartTime = appointmentStartTime;
	}

	public Date getAppointmentEndTime() {
		return AppointmentEndTime;
	}

	public void setAppointmentEndTime(Date appointmentEndTime) {
		AppointmentEndTime = appointmentEndTime;
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
