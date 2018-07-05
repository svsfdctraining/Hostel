package com.school.bean;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class StudentPhoto {

	private String filename;
	private CommonsMultipartFile fileData;
	
	public StudentPhoto() {
		
	}
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public CommonsMultipartFile getFileData() {
		return fileData;
	}
	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}
	
	
}
