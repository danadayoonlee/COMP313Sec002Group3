package com.curahealthyme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userAccess")
public class UserAccess {

	@Id
	@GeneratedValue
	@Column(name = "userAccessId")
	private long UserAccessId;

	@Column(name = "permissionId")
	public long PermissionId;
	
	@Column(name = "userRole")
	public String UserRole;
	
	@Column(name = "active")
	private String Active;
	
	public long getUserAccessId() {
		return UserAccessId;
	}

	public void setUserAccessId(long userAccessId) {
		UserAccessId = userAccessId;
	}
	
	public long getPermissionId() {
		return PermissionId;
	}

	public void setPermissionId(long permissionId) {
		PermissionId = permissionId;
	}
	
	public String getUserRole() {
		return UserRole;
	}

	public void setUserRole(String userRole) {
		UserRole = userRole;
	}
	
	public String getActive() {
		return Active;
	}

	public void setUserActive(String active) {
		Active = active;
	}
	
	public UserAccess() {
	}
}
