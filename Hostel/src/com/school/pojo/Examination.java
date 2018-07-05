package com.school.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "EXAMINATION",uniqueConstraints=@UniqueConstraint(columnNames={"EXAM_NO","SUBJECT","EXAM_TYPE","ST_CLASS"}))
public class Examination implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6435105351948386466L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REC_ID")
	private Long recid;
	@Column(name = "EXAM_NO", nullable = false)
	private Long examno;
	@Column(name = "SUBJECT",nullable=false)
	private String Subject;
	@Column(name = "EXAM_TYPE",nullable=false)
	private String examtype;
	@Column(name = "ST_CLASS",nullable=false)
	private String stclass;
	@Column(name = "MAX_MARKS", nullable = false)
	private int maxmarks;
	@Column(name = "PASS_MARKS",nullable=false)
	private int passmarks;
	@Column(name = "STATUS")
	private String status;
	@Column(name="SCHEDULE_DATE",nullable=false)
	private Date scheduledate;
	@Column(name = "ORG_ID", nullable = false)
	private Long orgid;

	public Examination() {
		// TODO Auto-generated constructor stub
	}

	public Long getRecid() {
		return recid;
	}

	public void setRecid(Long recid) {
		this.recid = recid;
	}

	public Long getExamno() {
		return examno;
	}

	public void setExamno(Long examno) {
		this.examno = examno;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getExamtype() {
		return examtype;
	}

	public void setExamtype(String examtype) {
		this.examtype = examtype;
	}

	public String getStclass() {
		return stclass;
	}

	public void setStclass(String stclass) {
		this.stclass = stclass;
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

	public Date getScheduledate() {
		return scheduledate;
	}

	public void setScheduledate(Date scheduledate) {
		this.scheduledate = scheduledate;
	}

	
}
