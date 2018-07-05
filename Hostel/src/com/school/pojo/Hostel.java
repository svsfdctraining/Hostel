package com.school.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "HOSTEL", uniqueConstraints = @UniqueConstraint(columnNames = { "ORG_ID", "HOSTEL_nAME" }))
public class Hostel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REC_ID")
	private Long recid;
	@Column(name = "HOSTEL_NAME")
	private String hostelName;
	@Column(name = "Status")
	private String status;
	@Column(name = "ORG_ID")
	private int orgid;
	@Column(name = "ORG_NAME")
	private String orgname;
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	@Column(name = "HOSTEL_ADDRESS")
	private String address;
	@Column(name = "TOTAL_DUE_AMOUNT")
	private Long totalDueAmount;
	@Column(name = "BALANCE_AMOUNT")
	private Long balanceAmount;

	public Hostel() {
		// TODO Auto-generated constructor stub
	}

	public Hostel(Long recid, String hostelName, String status, int orgid, String orgname, Date createdDate,
			String address) {
		super();
		this.recid = recid;
		this.hostelName = hostelName;
		this.status = status;
		this.orgid = orgid;
		this.orgname = orgname;
		this.createdDate = createdDate;
		this.address = address;
	}

	public Long getRecid() {
		return recid;
	}

	public void setRecid(Long recid) {
		this.recid = recid;
	}

	public String getHostelName() {
		return hostelName;
	}

	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getOrgid() {
		return orgid;
	}

	public void setOrgid(int orgid) {
		this.orgid = orgid;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getTotalDueAmount() {
		return totalDueAmount;
	}

	public void setTotalDueAmount(Long totalDueAmount) {
		this.totalDueAmount = totalDueAmount;
	}

	public Long getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(Long balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

}
