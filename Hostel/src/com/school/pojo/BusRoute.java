package com.school.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "SCHOOL_BUS_ROUTE",
uniqueConstraints=@UniqueConstraint(columnNames={"ROUTE_NO","ORG_ID"}))
public class BusRoute implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1104894767518744917L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REC_ID")
	private Long recid;
	@Column(name = "ROUTE_NO")
	private int routeno;
	@Column(name = "SRC_PLACE")
	private String source;
	@Column(name = "DEST_PLACE")
	private String destination;
	@Column(name = "VIA_PLACES")
	private String places;
	@Column(name = "BUS_FARE")
	private Long busfare;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "ORG_ID")
	private Long orgid;

	public BusRoute() {
		
	}

	public Long getRecid() {
		return recid;
	}

	public void setRecid(Long recid) {
		this.recid = recid;
	}

	public int getRouteno() {
		return routeno;
	}

	public void setRouteno(int routeno) {
		this.routeno = routeno;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getPlaces() {
		return places;
	}

	public void setPlaces(String places) {
		this.places = places;
	}

	public Long getBusfare() {
		return busfare;
	}

	public void setBusfare(Long busfare) {
		this.busfare = busfare;
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
