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
@Table(name="STUDENT_ATTENDANCE", uniqueConstraints=@UniqueConstraint(columnNames={"ADMISSION_NUM","ROLL_NO","ST_CLASS","ATT_DATE","ORG_ID"}))
public class Attendance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3599170698953173875L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="REC_ID")
	private Long recid;
	@Column(name="ADMISSION_NUM")
	private Long admissionnum;
	@Column(name="ROLL_NO")
	private Long rollno;
	@Column(name="STUDENT_NAME")
	private String stuendtname;
	@Column(name="ST_CLASS")
	private int stclass;
	@Column(name="ATT_DATE")
	private Date attdate;
	@Column(name="STATUS")
	private boolean status;
	@Column(name="ORG_ID",nullable=false)
	private Long orgid;
	
	public Attendance() {
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

	public Long getRollno() {
		return rollno;
	}

	public void setRollno(Long rollno) {
		this.rollno = rollno;
	}

	public String getStuendtname() {
		return stuendtname;
	}

	public void setStuendtname(String stuendtname) {
		this.stuendtname = stuendtname;
	}

	public int getStclass() {
		return stclass;
	}

	public void setStclass(int stclass) {
		this.stclass = stclass;
	}

	public Date getAttdate() {
		return attdate;
	}

	public void setAttdate(Date attdate) {
		this.attdate = attdate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Long getOrgid() {
		return orgid;
	}

	public void setOrgid(Long orgid) {
		this.orgid = orgid;
	}
	
	
}
