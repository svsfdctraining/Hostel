package com.school.pojo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "STUDENT_MARKS",uniqueConstraints=@UniqueConstraint(columnNames={""}))
public class Marks implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5729016042645466419L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REC_ID")
	private Long recid;
	@Column(name = "ADMISSION_NO")
	private Long admissionnum;
	@Column(name = "ROLL_NO")
	private int rollno;
	@Column(name = "STUDENT_NAME", nullable = false)
	private String studentname;
	@Column(name = "ST_CLASS")
	private String stclass;
	@Column(name = "SUBJECT")
	private String subject;
	@Column(name = "EXAM_TYPE")
	private String examtype;
	@Column(name = "EXAM_NAME")
	private String examname;
	@Column(name = "DATE_HELD")
	private Date examdate;
	@Column(name = "MAX_MARKS")
	private int maxmarks;
	@Column(name = "PASS_MARKS")
	private int passmarks;
	@Column(name = "SECURED_MARKS")
	private int securedmarks;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "ORG_ID")
	private Long orgid;

	public Marks() {
		// TODO Auto-generated constructor stub
	}

	public Long getRecid() {
		return recid;
	}

	public void setRecid(Long recid) {
		this.recid = recid;
	}

	public Long getAdmissionnum() {
		return admissionnum;
	}

	public void setAdmissionnum(Long admissionnum) {
		this.admissionnum = admissionnum;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getExamtype() {
		return examtype;
	}

	public void setExamtype(String examtype) {
		this.examtype = examtype;
	}

	public String getExamname() {
		return examname;
	}

	public void setExamname(String examname) {
		this.examname = examname;
	}

	public Date getExamdate() {
		return examdate;
	}

	public void setExamdate(Date examdate) {
		this.examdate = examdate;
	}

	public int getMaxmarks() {
		return maxmarks;
	}

	public void setMaxmarks(int maxmarks) {
		this.maxmarks = maxmarks;
	}

	public int getPassmarks() {
		return passmarks;
	}

	public void setPassmarks(int passmarks) {
		this.passmarks = passmarks;
	}

	public int getSecuredmarks() {
		return securedmarks;
	}

	public void setSecuredmarks(int securedmarks) {
		this.securedmarks = securedmarks;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getOrgid() {
		return orgid;
	}

	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}

}
