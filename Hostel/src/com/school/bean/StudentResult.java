package com.school.bean;

import com.school.pojo.Student;

public class StudentResult {

	private int rownum;
	private Long admissionnum;
	private String firstname;
	private String lastname;
	private String status;
	private Student student;
	
	public StudentResult() {
		
	}

	public StudentResult(int rownum, Long admissionnum, String firstname,
			String lastname, String status) {
		super();
		this.rownum = rownum;
		this.admissionnum = admissionnum;
		this.firstname = firstname;
		this.lastname = lastname;
		this.status = status;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public Long getAdmissionnum() {
		return admissionnum;
	}

	public void setAdmissionnum(Long admissionnum) {
		this.admissionnum = admissionnum;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
