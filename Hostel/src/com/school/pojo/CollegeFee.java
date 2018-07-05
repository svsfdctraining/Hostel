package com.school.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COLLEGE_FEE")
public class CollegeFee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RECORD_ID")
	private Integer recordId;
	@Column(name = "PREV_BALANCE")
	private Long prevBalance;
	@Column(name = "CURRENT_PAYMENT")
	private Long currentPay;
	@Column(name = "BALANCE_FEE")
	private Long balanceFee;
	@Column(name = "PAYMENT_TYPE")
	private String paymentType;
	@Column(name = "DESCRPTION")
	private String description;
	@Column(name = "TRANSACTION_DATE")
	private Date trnasctionDate;
	@Column(name = "ORG_ID", nullable = false)
	private int orgid;
	@Column(name = "ST_ADMISSION_NO", nullable = false)
	private Long StudentadmissionNo;
	@Column(name = "STUDENT_NAME")
	private String studentname;
	@Column(name = "ST_COURSE")
	private String stcourse;
	@Column(name = "ST_COURSE_YEAR")
	private int courseYear;

	public CollegeFee() {
		// TODO Auto-generated constructor stub
	}

	public CollegeFee(Integer recordId, Long prevBalance, Long currentPay, Long balanceFee, String paymentType,
			String description, Date trnasctionDate, int orgid, Long studentadmissionNo, String stcourse,
			int courseYear, String studentname) {
		super();
		this.recordId = recordId;
		this.prevBalance = prevBalance;
		this.currentPay = currentPay;
		this.balanceFee = balanceFee;
		this.paymentType = paymentType;
		this.description = description;
		this.trnasctionDate = trnasctionDate;
		this.orgid = orgid;
		StudentadmissionNo = studentadmissionNo;
		this.stcourse = stcourse;
		this.courseYear = courseYear;
		this.studentname = studentname;
	}

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public Long getPrevBalance() {
		return prevBalance;
	}

	public void setPrevBalance(Long prevBalance) {
		this.prevBalance = prevBalance;
	}

	public Long getCurrentPay() {
		return currentPay;
	}

	public void setCurrentPay(Long currentPay) {
		this.currentPay = currentPay;
	}

	public Long getBalanceFee() {
		return balanceFee;
	}

	public void setBalanceFee(Long balanceFee) {
		this.balanceFee = balanceFee;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTrnasctionDate() {
		return trnasctionDate;
	}

	public void setTrnasctionDate(Date trnasctionDate) {
		this.trnasctionDate = trnasctionDate;
	}

	public int getOrgid() {
		return orgid;
	}

	public void setOrgid(int orgid) {
		this.orgid = orgid;
	}

	public Long getStudentadmissionNo() {
		return StudentadmissionNo;
	}

	public void setStudentadmissionNo(Long studentadmissionNo) {
		StudentadmissionNo = studentadmissionNo;
	}

	public String getStcourse() {
		return stcourse;
	}

	public void setStcourse(String stcourse) {
		this.stcourse = stcourse;
	}

	public int getCourseYear() {
		return courseYear;
	}

	public void setCourseYear(int courseYear) {
		this.courseYear = courseYear;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

}
