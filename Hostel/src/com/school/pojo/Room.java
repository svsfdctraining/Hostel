package com.school.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "HOSTEL_ROOM", uniqueConstraints = @UniqueConstraint(columnNames = { "ORG_ID", "ROOM_NAME",
		"HOSTEL_NAME" }))
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REC_ID")
	private Long recid;
	@Column(name = "ROOM_NAME")
	private String roomName;
	@Column(name = "MAX_STUDENT")
	private int maxStudents;
	@Column(name = "AVAIL_STUDENTS")
	private int availableStudent;
	@Column(name = "HOSTEL_NAME")
	private String hostelName;
	@Column(name = "Status")
	private String status;
	@Column(name = "ORG_ID")
	private int orgid;

	public Room(Long recid, String roomName, int maxStudents, int availableStudent, String hostelName, String status,
			int orgid) {
		super();
		this.recid = recid;
		this.roomName = roomName;
		this.maxStudents = maxStudents;
		this.availableStudent = availableStudent;
		this.hostelName = hostelName;
		this.status = status;
		this.orgid = orgid;
	}

	public Long getRecid() {
		return recid;
	}

	public void setRecid(Long recid) {
		this.recid = recid;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getMaxStudents() {
		return maxStudents;
	}

	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}

	public int getAvailableStudent() {
		return availableStudent;
	}

	public void setAvailableStudent(int availableStudent) {
		this.availableStudent = availableStudent;
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

}
