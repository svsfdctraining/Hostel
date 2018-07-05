package com.school.bean;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.school.pojo.Caste;
import com.school.pojo.Document;
import com.school.pojo.Hostel;
import com.school.pojo.OrganizationMedium;
import com.school.pojo.Religion;
import com.school.pojo.Student;
import com.school.pojo.StudentClass;
import com.school.pojo.StudentClassSection;
import com.school.util.bean.YearBean;

public class StudentBean {

	private List<Hostel> hostels;
	private List<YearBean> studyingYears;
	private List<Religion> relegions;
	private List<Caste> castes;
	private List<StudentClass> classes;
	private List<OrganizationMedium> mediums;
	private List<StudentClassSection> sections;
	private String uploadtype;
	private Document photo;
	private Document tc;
	private Document cc;
	private Document sc;
	private Document mm;
	private Document rectc;
	private Document reccc;
	private Document recsc;
	private Document recmm;
	private CommonsMultipartFile filedata;
	private String photopath;
	List<StudentClass> prevclasses;
	private String dob;
	private Student student;
	private String action;
	private CommonsMultipartFile uploadfile;
	private List<StudentResult> uploadresults;
	private boolean uploadstatus;

	public boolean isUploadstatus() {
		return uploadstatus;
	}

	public void setUploadstatus(boolean uploadstatus) {
		this.uploadstatus = uploadstatus;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	// Search conditions
	private String academicyear;
	private String stclass;
	private String section;
	private String medium;
	private List<Student> results;
	private List<YearBean> academicyears;
	private String name;
	private String fname;
	private String operation;
	private String status;
	private Integer studentSeq;

	public Integer getStudentSeq() {
		return studentSeq;
	}

	public CommonsMultipartFile getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(CommonsMultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}

	public void setStudentSeq(Integer studentSeq) {
		this.studentSeq = studentSeq;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getAcademicyear() {
		return academicyear;
	}

	public void setAcademicyear(String academicyear) {
		this.academicyear = academicyear;
	}

	public String getStclass() {
		return stclass;
	}

	public void setStclass(String stclass) {
		this.stclass = stclass;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public CommonsMultipartFile getFiledata() {
		return filedata;
	}

	public void setFiledata(CommonsMultipartFile filedata) {
		this.filedata = filedata;
	}

	public StudentBean() {
		// TODO Auto-generated constructor stub
	}

	public List<Religion> getRelegions() {
		return relegions;
	}

	public void setRelegions(List<Religion> relegions) {
		this.relegions = relegions;
	}

	public List<Caste> getCastes() {
		return castes;
	}

	public void setCastes(List<Caste> castes) {
		this.castes = castes;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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

	public List<StudentClassSection> getSections() {
		return sections;
	}

	public void setSections(List<StudentClassSection> sections) {
		this.sections = sections;
	}

	public Document getPhoto() {
		return photo;
	}

	public void setPhoto(Document photo) {
		this.photo = photo;
	}

	public Document getTc() {
		return tc;
	}

	public void setTc(Document tc) {
		this.tc = tc;
	}

	public Document getCc() {
		return cc;
	}

	public void setCc(Document cc) {
		this.cc = cc;
	}

	public Document getSc() {
		return sc;
	}

	public void setSc(Document sc) {
		this.sc = sc;
	}

	public Document getMm() {
		return mm;
	}

	public void setMm(Document mm) {
		this.mm = mm;
	}

	public String getUploadtype() {
		return uploadtype;
	}

	public void setUploadtype(String uploadtype) {
		this.uploadtype = uploadtype;
	}

	public Document getRectc() {
		return rectc;
	}

	public void setRectc(Document rectc) {
		this.rectc = rectc;
	}

	public Document getReccc() {
		return reccc;
	}

	public void setReccc(Document reccc) {
		this.reccc = reccc;
	}

	public Document getRecsc() {
		return recsc;
	}

	public void setRecsc(Document recsc) {
		this.recsc = recsc;
	}

	public Document getRecmm() {
		return recmm;
	}

	public void setRecmm(Document recmm) {
		this.recmm = recmm;
	}

	public String getPhotopath() {
		return photopath;
	}

	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}

	public List<StudentClass> getPrevclasses() {
		return prevclasses;
	}

	public void setPrevclasses(List<StudentClass> prevclasses) {
		this.prevclasses = prevclasses;
	}

	public List<Student> getResults() {
		return results;
	}

	public void setResults(List<Student> results) {
		this.results = results;
	}

	public List<YearBean> getAcademicyears() {
		return academicyears;
	}

	public void setAcademicyears(List<YearBean> academicyears) {
		this.academicyears = academicyears;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public List<StudentResult> getUploadresults() {
		return uploadresults;
	}

	public void setUploadresults(List<StudentResult> uploadresults) {
		this.uploadresults = uploadresults;
	}

	public List<YearBean> getStudyingYears() {
		return studyingYears;
	}

	public void setStudyingYears(List<YearBean> studyingYears) {
		this.studyingYears = studyingYears;
	}

	public List<Hostel> getHostels() {
		return hostels;
	}

	public void setHostels(List<Hostel> hostels) {
		this.hostels = hostels;
	}

}
