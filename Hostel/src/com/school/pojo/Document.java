package com.school.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "DOCUMENT", uniqueConstraints = @UniqueConstraint(columnNames = {
		"ADM_NUM", "ST_CLASS", "ORG_ID", "DOC_TYPE" }))
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REC_ID")
	private Long recid;
	@Column(name = "ADM_NUM")
	private Long admno;
	@Column(name = "ST_CLASS")
	private String stclass;
	@Column(name = "ORG_ID")
	private int orgid;
	@Column(name = "DOC_TYPE")
	private String doctype;
	@Column(name = "CONTENT", nullable = false)
	private byte[] content;
	@Column(name = "FILE_NAME")
	private String filename;

	public Document() {
		// TODO Auto-generated constructor stub
	}

	public Long getRecid() {
		return recid;
	}

	public void setRecid(Long recid) {
		this.recid = recid;
	}

	public Long getAdmno() {
		return admno;
	}

	public void setAdmno(Long admno) {
		this.admno = admno;
	}

	public String getStclass() {
		return stclass;
	}

	public void setStclass(String stclass) {
		this.stclass = stclass;
	}

	public int getOrgid() {
		return orgid;
	}

	public void setOrgid(int orgid) {
		this.orgid = orgid;
	}

	public String getDoctype() {
		return doctype;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
