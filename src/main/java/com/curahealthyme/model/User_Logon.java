package com.curahealthyme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_logon")
public class User_Logon {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long Id;

	@Column(name = "username")
	public String Username;
	
	@Column(name = "password")
	public String Password;
	
	@Column(name = "userAccessid")
	private long UserAccessId;
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}
	
	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}
	
	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	public long getUserAccessId() {
		return UserAccessId;
	}

	public void setUserAccessId(long userAccessId) {
		UserAccessId = userAccessId;
	}
	
	public User_Logon() {
	}
}
