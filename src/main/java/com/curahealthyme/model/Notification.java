package com.curahealthyme.model;

public class Notification {

	private String name;
	
	private String date;
	
	private String checkup;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCheckup() {
		return checkup;
	}

	public void setCheckup(String checkup) {
		this.checkup = checkup;
	}

	public Notification(String name, String date, String checkup) {
		this.name = name;
		this.date = date;
		this.checkup = checkup;
	}
	
	
}
