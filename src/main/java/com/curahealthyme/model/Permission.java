package com.curahealthyme.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="permission")
public class Permission {
	
	@Id
	@GeneratedValue
	@Column(name="permissionid")
	private long PermissionId;
	
	@Column(name="permissiontype")
	public String PermissionType;

	public long getPermissionId() {
		return PermissionId;
	}

	public void setPermissionId(long permissionId) {
		PermissionId = permissionId;
	}

	public String getPermissionType() {
		return PermissionType;
	}

	public void setPermissionType(String permissionType) {
		PermissionType = permissionType;
	}
	
	public Permission() {}
	
	public Permission(String permissiontype)
	{
		this.setPermissionType(permissiontype);
	}
}
