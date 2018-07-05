package com.school.pojo;

import java.io.Serializable;

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
@Table(name="CASTE")
public class Caste implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -744878244849894664L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CASTE_ID",nullable=false,unique=true)
	private Integer casteid;
	@Column(name="CASTE_NAME", nullable=false,unique=true)
	private String castename;
	
	public Caste() {
		// TODO Auto-generated constructor stub
	}
	
	public Caste(String castename) {
		super();
		this.castename = castename;
	}



	public Integer getCasteid() {
		return casteid;
	}
	public void setCasteid(Integer casteid) {
		this.casteid = casteid;
	}
	public String getCastename() {
		return castename;
	}
	public void setCastename(String castename) {
		this.castename = castename;
	}

	
	
}
