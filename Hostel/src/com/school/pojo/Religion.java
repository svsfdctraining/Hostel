package com.school.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RELIGION")
public class Religion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1152303825526833777L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REL_ID",nullable=false)
	private Integer religionid;
	
	@Column(name="REL_NAME",nullable=false,unique=true)
	private String religionname;
	
	public Religion() {
		// TODO Auto-generated constructor stub
	}
	
	public Religion( String religionname) {
		super();
		this.religionname = religionname;
		
	}
	public Integer getReligionid() {
		return religionid;
	}
	public void setReligionid(Integer religionid) {
		this.religionid = religionid;
	}
	public String getReligionname() {
		return religionname;
	}
	public void setReligionname(String religionname) {
		this.religionname = religionname;
	}

	
}
