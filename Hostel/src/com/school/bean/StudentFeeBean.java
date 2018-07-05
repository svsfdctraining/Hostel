package com.school.bean;

import com.school.pojo.CollegeFee;
import com.school.pojo.HostelFee;
import com.school.pojo.Student;

public class StudentFeeBean {

	private HostelFee hostelfee;
	private CollegeFee collegeFee;
	private Student student;
	private String feeType;

	public StudentFeeBean() {
		// TODO Auto-generated constructor stub
	}

	public HostelFee getHostelfee() {
		return hostelfee;
	}

	public void setHostelfee(HostelFee hostelfee) {
		this.hostelfee = hostelfee;
	}

	public CollegeFee getCollegeFee() {
		return collegeFee;
	}

	public void setCollegeFee(CollegeFee collegeFee) {
		this.collegeFee = collegeFee;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

}
