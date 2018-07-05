package com.school.bean;

import java.util.List;

import com.school.pojo.OrganizationMedium;
import com.school.pojo.StudentClass;
import com.school.pojo.StudentClassSection;
import com.school.pojo.UserRole;

public class StudentClassBean {

	List<StudentClass> classes;

	List<OrganizationMedium> mediums;

	List<UserRole> userroles;

	List<StudentClassSection> sections;
	
	private String stclass;

	public StudentClassBean() {

	}

	public List<StudentClass> getClasses() {
		return classes;
	}

	public void setClasses(List<StudentClass> classes) {
		this.classes = classes;
	}

	public List<OrganizationMedium> getMediums() {
		return mediums;
	}

	public void setMediums(List<OrganizationMedium> mediums) {
		this.mediums = mediums;
	}

	public List<UserRole> getUserroles() {
		return userroles;
	}

	public void setUserroles(List<UserRole> userroles) {
		this.userroles = userroles;
	}

	public List<StudentClassSection> getSections() {
		return sections;
	}

	public void setSections(List<StudentClassSection> sections) {
		this.sections = sections;
	}

	public String getStclass() {
		return stclass;
	}

	public void setStclass(String stclass) {
		this.stclass = stclass;
	}

}
