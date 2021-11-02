package com.curahealthyme.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patienttestresult")
public class PatientTestResult {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long Id;

	@Column(name = "joinid")
	public long JoinId;

	@Column(name = "filename")
	public String FileName;

	@Column(name = "dateadded")
	public Date DateAdded;
	
	@Column(name = "comments")
	public String Comments;
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getJoinId() {
		return JoinId;
	}

	public void setJoinId(long joinId) {
		JoinId = joinId;
	}
	
	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public Date getDateAdded() {
		return DateAdded;
	}

	public void setTestDate(Date dateAdded) {
		DateAdded = dateAdded;
	}
	
	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}

	public PatientTestResult() {
	}
}
