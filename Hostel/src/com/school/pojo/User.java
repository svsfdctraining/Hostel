package com.school.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 50120C2029
 *
 */
@Entity
@Table(name = "User")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 724414567730564102L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private Integer userId;
	@Column(name="FIRST_NAME")
	private String userFirstName;
	@Column(name="MIDDLE_NAME")
	private String userMiddleName;
	@Column(name="LAST_NAME")
	private String userLastName;
	@Column(name="USER_ADDRESS")
	private String address;
	@Column(name="PASSWORD")
	private String userPassword;
	@Column(name="EMAIL")
	private String email;
	@Column(name="MOBILE_NUMBER")
	private String mobile;
	@Column(name="STATUS")
	private String status;
	@Column(name="TEMP_PASSWORD")
	private String isTempPassword;
	@Column(name="ORG_ID",nullable=false)
	private int orgId;
	@Column(name="CREATED_DATE")
	private Date createdDate;
	@Column(name="USER_ROLE")
	private Integer role;
	@Column(name="HOSTEL_USER")
	private String isHostelUser;
	
	public User() {
		
	}

	
	public User(Integer userId, String userFirstName, String userMiddleName, String userLastName, String address,
			String userPassword, String email, String mobile, String status, String isTempPassword, int orgId,
			Date createdDate, Integer role, String isHostelUser) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userMiddleName = userMiddleName;
		this.userLastName = userLastName;
		this.address = address;
		this.userPassword = userPassword;
		this.email = email;
		this.mobile = mobile;
		this.status = status;
		this.isTempPassword = isTempPassword;
		this.orgId = orgId;
		this.createdDate = createdDate;
		this.role = role;
		this.isHostelUser = isHostelUser;
	}


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsTempPassword() {
		return isTempPassword;
	}

	public void setIsTempPassword(String isTempPassword) {
		this.isTempPassword = isTempPassword;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getUserMiddleName() {
		return userMiddleName;
	}

	public void setUserMiddleName(String userMiddleName) {
		this.userMiddleName = userMiddleName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}


	public String getIsHostelUser() {
		return isHostelUser;
	}


	public void setIsHostelUser(String isHostelUser) {
		this.isHostelUser = isHostelUser;
	}
	
	
}
