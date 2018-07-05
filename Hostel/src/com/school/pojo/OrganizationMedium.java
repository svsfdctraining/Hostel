package com.school.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="ORG_MEDIUM",uniqueConstraints = @UniqueConstraint(columnNames = {
		"ORG_ID", "ORG_MEDIUM"}))
public class OrganizationMedium {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORG_NAME")
	private Integer mediumid;
	@Column(name = "ORG_MEDIUM")
	private String mediumname;
	@Column(name = "ORG_ID")
	private int organization;
	@Column(name = "STATUS")
	private String status;
	
	public OrganizationMedium() {
		
	}

	public OrganizationMedium(String mediumname, int organization, String status) {
		super();
		this.mediumname = mediumname;
		this.organization = organization;
		this.status = status;
	}

	public Integer getMediumid() {
		return mediumid;
	}

	public void setMediumid(Integer mediumid) {
		this.mediumid = mediumid;
	}

	public String getMediumname() {
		return mediumname;
	}

	public void setMediumname(String mediumname) {
		this.mediumname = mediumname;
	}

	public int getOrganization() {
		return organization;
	}

	public void setOrganization(int organization) {
		this.organization = organization;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
