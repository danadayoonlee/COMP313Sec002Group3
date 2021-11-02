package com.curahealthyme.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@GeneratedValue
	@Column(name = "patientid")
	private long PatientId;

	@Column(name = "name")
	public String Name;

	@Column(name = "dob")
	public Date Dob;

	@Column(name = "gender")
	public String Gender;

	@Column(name = "street")
	public String Street;
	
	@Column(name = "city")
	public String City;

	@Column(name = "province")
	public String Province;
	
	@Column(name = "country")
	public String Country;

	@Column(name = "postal")
	public String Postal;
	
	@Column(name = "phone")
	public String Phone;

	@Column(name = "email")
	public String Email;
	
	@Column(name = "loginid")
	public long LoginId;

	public long getPatientId() {
		return PatientId;
	}

	public void setPatientId(long patientId) {
		PatientId = patientId;
	}
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Date getDob() {
		return Dob;
	}

	public void setDob(Date dob) {
		Dob = dob;
	}
	
	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}
	
	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}
	
	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}
	
	public String getProvince() {
		return Province;
	}

	public void setProvince(String province) {
		Province = province;
	}
	
	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}
	
	public String getPostal() {
		return Postal;
	}

	public void setPostal(String postal) {
		Postal = postal;
	}
	
	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}
	
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	public long getLoginId() {
		return LoginId;
	}

	public void setLoginId(long loginId) {
		LoginId = loginId;
	}

	public Patient() {
	}
}
