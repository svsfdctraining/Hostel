package com.school.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORGANIZATION")
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORG_ID")
	private Integer orgId;
	@Column(name = "ORG_NAME")
	private String orgName;
	@Column(name = "ORG_REG_NUM")
	private String regNum;
	@Column(name = "EST_YEAR")
	private Integer year;
	@Column(name = "STREET")
	private String street;
	@Column(name = "MANDAL")
	private String mandal;
	@Column(name = "TALUK")
	private String taluk;
	@Column(name = "DISTRICT")
	private String district;
	@Column(name = "STATE")
	private String state;
	@Column(name = "Country")
	private String country;
	@Column(name = "OTHER")
	private String other;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	@Column(name = "HOSTEL_AVAILABILITY")
	private String isHostel;
	@Column(name = "EXPIRY_DATE")
	private Date expiryDate;
	@Column(name = "TOT_STUDENTS")
	private Integer totalStudents;
	@Column(name = "LICENCE_STUDENTS")
	private Integer licencedStudents;
	@Column(name = "ACTIVE_STUDENTS")
	private Integer activeStudents;
	@Column(name = "INACTIVE_STUDENTS")
	private Integer inactiveStudents;

	public Organization() {

	}

	
	public Organization(Integer orgId, String orgName, String regNum, Integer year, String street, String mandal,
			String taluk, String district, String state, String country, String other, String status, Date createdDate,
			String isHostel, Date expiryDate, Integer totalStudents, Integer licencedStudents, Integer activeStudents,
			Integer inactiveStudents) {
		super();
		this.orgId = orgId;
		this.orgName = orgName;
		this.regNum = regNum;
		this.year = year;
		this.street = street;
		this.mandal = mandal;
		this.taluk = taluk;
		this.district = district;
		this.state = state;
		this.country = country;
		this.other = other;
		this.status = status;
		this.createdDate = createdDate;
		this.isHostel = isHostel;
		this.expiryDate = expiryDate;
		this.totalStudents = totalStudents;
		this.licencedStudents = licencedStudents;
		this.activeStudents = activeStudents;
		this.inactiveStudents = inactiveStudents;
	}


	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getMandal() {
		return mandal;
	}

	public void setMandal(String mandal) {
		this.mandal = mandal;
	}

	public String getTaluk() {
		return taluk;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getTotalStudents() {
		return totalStudents;
	}

	public void setTotalStudents(Integer totalStudents) {
		this.totalStudents = totalStudents;
	}

	public Integer getLicencedStudents() {
		return licencedStudents;
	}

	public void setLicencedStudents(Integer licencedStudents) {
		this.licencedStudents = licencedStudents;
	}

	public Integer getActiveStudents() {
		return activeStudents;
	}

	public void setActiveStudents(Integer activeStudents) {
		this.activeStudents = activeStudents;
	}

	public Integer getInactiveStudents() {
		return inactiveStudents;
	}

	public void setInactiveStudents(Integer inactiveStudents) {
		this.inactiveStudents = inactiveStudents;
	}


	public String getIsHostel() {
		return isHostel;
	}


	public void setIsHostel(String isHostel) {
		this.isHostel = isHostel;
	}

	
	
}
