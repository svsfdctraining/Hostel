package com.school.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ROLE")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROLE_ID")
	private Integer roleId;
	@Column(name = "ROLE_NUM", nullable = false, unique = true)
	private Integer roleNum;
	@Column(name = "ROLE_NAME", nullable = false, unique = true)
	private String roleName;
	@Column(name = "ROLE_STATUS", nullable = false)
	private String status;
	@Column(name="CREATED_DATE")
	private Date createdDate;

	public UserRole() {

	}

	public UserRole(Integer roleNum, String roleName, String status,Date createdDate) {
		super();
		this.roleNum = roleNum;
		this.roleName = roleName;
		this.status = status;
		this.createdDate = createdDate;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getRoleNum() {
		return roleNum;
	}

	public void setRoleNum(Integer roleNum) {
		this.roleNum = roleNum;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
