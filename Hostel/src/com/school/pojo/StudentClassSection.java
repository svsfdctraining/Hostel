package com.school.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CLASS_SECTION", uniqueConstraints = @UniqueConstraint(columnNames = {
		"ORG_ID", "ST_CLASS","COURSE_YEAR", "SECTION_NAME" }))
public class StudentClassSection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REC_ID")
	private Long recid;
	@Column(name="COURSE_YEAR")
	private int year;
	@Column(name = "SECTION_NAME")
	private String sectionname;
	@Column(name = "ST_CLASS")
	private String stclass;
	@Column(name = "NO_OF_STUDENTS")
	private int students;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "ORG_ID")
	private int orgid;
	@Column(name="AVAIL_STUDENTS")
	private int noofstudents;

	public StudentClassSection() {
		// TODO Auto-generated constructor stub
	}

	public Long getRecid() {
		return recid;
	}

	public void setRecid(Long recid) {
		this.recid = recid;
	}

	public String getSectionname() {
		return sectionname;
	}

	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}

	public String getStclass() {
		return stclass;
	}

	public void setStclass(String stclass) {
		this.stclass = stclass;
	}

	public int getStudents() {
		return students;
	}

	public void setStudents(int students) {
		this.students = students;
	}

	
	public int getOrgid() {
		return orgid;
	}

	public void setOrgid(int orgid) {
		this.orgid = orgid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getNoofstudents() {
		return noofstudents;
	}

	public void setNoofstudents(int noofstudents) {
		this.noofstudents = noofstudents;
	}

}
