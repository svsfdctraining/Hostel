package com.school.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_CLASS")
public class StudentClass {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLASS_ID")
	private Integer class_id;
	@Column(name="MEDIUM")
	private String medium;
	@Column(name = "CLASS_DESC")
	private String classDesc;
	@Column(name = "CLASS_VALUE")
	private String classValue;
	@Column(name = "CLASS_HOSTEL_FEE")
	private int classHostelFee;
	@Column(name = "CLASS_COLLEGE_FEE")
	private int classCollegeFee;
	@Column(name="DUR_YEARS")
	private int durationYears;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "ORG_ID")
	private int organization;
	
	public StudentClass() {

	}

	public StudentClass(Integer class_id, String classDesc, String classValue, int classHostelFee, int classCollegeFee,
			int durationYears, String status, int organization) {
		super();
		this.class_id = class_id;
		this.classDesc = classDesc;
		this.classValue = classValue;
		this.classHostelFee = classHostelFee;
		this.classCollegeFee = classCollegeFee;
		this.durationYears = durationYears;
		this.status = status;
		this.organization = organization;
	}

	public int getClassHostelFee() {
		return classHostelFee;
	}



	public void setClassHostelFee(int classHostelFee) {
		this.classHostelFee = classHostelFee;
	}



	public int getClassCollegeFee() {
		return classCollegeFee;
	}



	public void setClassCollegeFee(int classCollegeFee) {
		this.classCollegeFee = classCollegeFee;
	}



	public Integer getClass_id() {
		return class_id;
	}

	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}

	public String getClassDesc() {
		return classDesc;
	}

	public void setClassDesc(String classDesc) {
		this.classDesc = classDesc;
	}

	public String getClassValue() {
		return classValue;
	}

	public void setClassValue(String classValue) {
		this.classValue = classValue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public int getOrganization() {
		return organization;
	}

	public void setOrganization(int organization) {
		this.organization = organization;
	}

	public int getDurationYears() {
		return durationYears;
	}

	public void setDurationYears(int durationYears) {
		this.durationYears = durationYears;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	
}
