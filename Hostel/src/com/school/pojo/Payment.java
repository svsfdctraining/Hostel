package com.school.pojo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT_PAYMENT")
public class Payment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7868284537722807864L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="REC_ID")
	private Long recid;
	@Column(name="BILL_ID",unique=true)
	private Long billid;
	@Column(name="ADMISSION_NUM")
	private Integer admissionno;
	@Column(name="ROLL_NO")
	private Long rollno;
	@Column(name="STUDENT_NAME")
	private String studentname;
	@Column(name="ST_CLASS")
	private String stclass;
	@Column(name="FEE_DETAILS")
	private String feedetails;
	@Column(name="AMOUNT")
	private Long amount;
	@Column(name="REM_BAL")
	private Long balance;
	@Column(name="PAID_DATE")
	private Date date;
	@Column(name="ORG_ID")
	private Integer orgId;
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Long getRecid() {
		return recid;
	}

	public void setRecid(Long recid) {
		this.recid = recid;
	}

	public Long getBillid() {
		return billid;
	}

	public void setBillid(Long billid) {
		this.billid = billid;
	}

	public Integer getAdmissionno() {
		return admissionno;
	}

	public void setAdmissionno(Integer admissionno) {
		this.admissionno = admissionno;
	}

	public Long getRollno() {
		return rollno;
	}

	public void setRollno(Long rollno) {
		this.rollno = rollno;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStclass() {
		return stclass;
	}

	public void setStclass(String stclass) {
		this.stclass = stclass;
	}

	public String getFeedetails() {
		return feedetails;
	}

	public void setFeedetails(String feedetails) {
		this.feedetails = feedetails;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	
	
	
	
}
