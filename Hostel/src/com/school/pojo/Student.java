package com.school.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "STUDENT", uniqueConstraints = @UniqueConstraint(columnNames = { "ORG_ID", "ADMISSION_NO" }))
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2530762849823508949L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STUDENT_SEQ")
	private Integer studentSeq;
	@Column(name = "ADMISSION_NO", nullable = false)
	private Long admissionNo;
	@Column(name = "STUDENT_TYPE")
	private String studentType;
	@Column(name = "HOSTEL_ADMISSION_NO")
	private Long hostelAdmissionNo;
	@Column(name = "HOSTEL_NAME")
	private String hostelName;
	@Column(name="ROOM_NO")
	private int roomNo;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "HOSTEL_JOIN_DATE")
	private Date hostelJoinDate;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "HOSTEL_LEFT_DATE")
	private Date hostelLeftDate;
	@Column(name = "HOSTEL_LEFT_REASON")
	private String hostelLeftReason;
	@Column(name = "ACADEMIC_YEAR")
	private String academicyear;
	@Column(name = "CLASS")
	private String stclass;
	@Column(name = "MEDIUM")
	private String medium;
	@Column(name = "ROLL_NO")
	private Long rollNo;
	@Column(name = "SECTION")
	private String section;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "JOIN_DATE")
	private Date joinedDate;
	@Column(name = "HOSTEL_FEE")
	private Long hostelFee;
	@Column(name = "HOSTEL_PAID_FEE")
	private Long hostelPaidfee;
	@Column(name = "HOSTEL_BAL_FEE")
	private Long hostelBalanceFee;
	@Column(name = "COLLEGE_FEE")
	private Long collegeFee;
	@Column(name = "COLLEGE_PAID_FEE")
	private Long collegePaidFee;
	@Column(name = "COLLEGE_BAL_FEE")
	private Long collegeBlanceFee;
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstname;
	@Column(name = "LAST_NAME", nullable = false)
	private String lastname;
	@Column(name = "GENDER", nullable = false)
	private String gender;
	@Column(name = "BIRTH_DATE")
	private Date birthDate;
	@Column(name = "RELIGION")
	private String religion;
	@Column(name = "CASTE")
	private String caste;
	@Column(name = "CASTE_NAME")
	private String castename;
	@Column(name = "PARENT_TYPE", nullable = false)
	private String parentType;
	@Column(name = "PARENT_NAME", nullable = false)
	private String parentName;
	@Column(name = "MOBILE")
	private String mobile;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "OCCUPATION")
	private String occupation;
	@Column(name = "PRESENT_ADDRESS")
	private String presentAddress;
	@Column(name = "PERMANT_ADDRESS")
	private String premanentAddress;
	// previous organisation
	@Column(name = "PREV_SCHOOL")
	private String prevschool;
	@Column(name = "PREV_STUD_CLASS")
	private int prevsStudClass;
	@Column(name = "PREV_STUD_YEAR")
	private String prevsStudyear;
	@Column(name = "PREV_REL_REASON")
	private String prevsReleaveReason;
	@Column(name = "PREV_CONDUCT")
	private String prevconduct;
	@Column(name = "REC_TC")
	private boolean recTc;
	@Column(name = "REC_CC")
	private boolean recCC;
	@Column(name = "REC_SC")
	private boolean recSC;
	@Column(name = "REC_MARKS")
	private boolean recMarks;
	// current organisation
	@Column(name = "ISS_TC")
	private boolean issTc;
	@Column(name = "ISS_CC")
	private boolean issCC;
	@Column(name = "ISS_SC")
	private boolean issSC;
	@Column(name = "ISS_MARKS")
	private boolean issMarks;
	@Column(name = "TC_ISS_DATE")
	private Date tcIssDate;
	@Column(name = "MM_ISS_DATE")
	private Date marksIssDate;
	// Releave Date
	@Column(name = "LEAVE_REASON")
	private String leaveReason;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "LEFT_DATE",nullable=true)
	private Date collegeLeaveDate;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "ISS_CONDUCT")
	private String issuedconduct;
	@Column(name = "PHOTO_ID")
	private Long photoid;
	@Column(name = "PHOTO_NAME")
	private String photoname;
	@Column(name = "TC_ID")
	private Long tcid;
	@Column(name = "TC_NAME")
	private String tcname;
	@Column(name = "CC_ID")
	private Long ccid;
	@Column(name = "CC_NAME")
	private String ccname;
	@Column(name = "SC_ID")
	private Long scid;
	@Column(name = "SC_NAME")
	private String scname;
	@Column(name = "MM_ID")
	private Long mmid;
	@Column(name = "MM_NAME")
	private String mmname;

	// Rec
	@Column(name = "REC_TC_ID")
	private Long rectcid;
	@Column(name = "REC_TC_NAME")
	private String rectcname;
	@Column(name = "REC_CC_ID")
	private Long recccid;
	@Column(name = "REC_CC_NAME")
	private String recccname;
	@Column(name = "REC_SC_ID")
	private Long recscid;
	@Column(name = "REC_SC_NAME")
	private String recscname;
	@Column(name = "REC_MM_ID")
	private Long recmmid;
	@Column(name = "REC_MM_NAME")
	private String recmmname;
	@Column(name = "CREATE_USER")
	private String createdby;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "CREATE_DATE")
	private Date createddate;
	@Column(name = "UPDATE_USER")
	private String updatedby;
	@Column(name = "UPDATE_DATE")
	private Date updateddate;
	@Column(name = "ORG_ID", nullable = false, updatable = true)
	private int orgId;
	@Column(name = "STUDY_YEAR")
	private int studyingyear;

	public Student() {
		// Auto-generated constructor stub
	}

	public Student(Integer studentSeq, Long admissionNo, Long hostelAdmissionNo, String academicyear, String stclass,
			String medium, Long rollNo, String section, Date joinedDate, Long hostelFee, Long hostelPaidfee,
			Long hostelBalanceFee, Long collegeFee, Long collegePaidFee, Long collegeBlanceFee, String firstname,
			String lastname, String gender, Date birthDate, String religion, String caste, String castename,
			String parentType, String parentName, String mobile, String email, String occupation, String presentAddress,
			String premanentAddress, String prevschool, int prevsStudClass, String prevsStudyear,
			String prevsReleaveReason, String prevconduct, boolean recTc, boolean recCC, boolean recSC,
			boolean recMarks, boolean issTc, boolean issCC, boolean issSC, boolean issMarks, Date tcIssDate,
			Date marksIssDate, String leaveReason, Date leaveDate, String status, String issuedconduct, Long photoid,
			String photoname, Long tcid, String tcname, Long ccid, String ccname, Long scid, String scname, Long mmid,
			String mmname, Long rectcid, String rectcname, Long recccid, String recccname, Long recscid,
			String recscname, Long recmmid, String recmmname, String createdby, Date createddate, String updatedby,
			Date updateddate, int orgId, String studentType) {
		super();
		this.studentSeq = studentSeq;
		this.admissionNo = admissionNo;
		this.hostelAdmissionNo = hostelAdmissionNo;
		this.academicyear = academicyear;
		this.stclass = stclass;
		this.medium = medium;
		this.rollNo = rollNo;
		this.section = section;
		this.joinedDate = joinedDate;
		this.hostelFee = hostelFee;
		this.hostelPaidfee = hostelPaidfee;
		this.hostelBalanceFee = hostelBalanceFee;
		this.collegeFee = collegeFee;
		this.collegePaidFee = collegePaidFee;
		this.collegeBlanceFee = collegeBlanceFee;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.birthDate = birthDate;
		this.religion = religion;
		this.caste = caste;
		this.castename = castename;
		this.parentType = parentType;
		this.parentName = parentName;
		this.mobile = mobile;
		this.email = email;
		this.occupation = occupation;
		this.presentAddress = presentAddress;
		this.premanentAddress = premanentAddress;
		this.prevschool = prevschool;
		this.prevsStudClass = prevsStudClass;
		this.prevsStudyear = prevsStudyear;
		this.prevsReleaveReason = prevsReleaveReason;
		this.prevconduct = prevconduct;
		this.recTc = recTc;
		this.recCC = recCC;
		this.recSC = recSC;
		this.recMarks = recMarks;
		this.issTc = issTc;
		this.issCC = issCC;
		this.issSC = issSC;
		this.issMarks = issMarks;
		this.tcIssDate = tcIssDate;
		this.marksIssDate = marksIssDate;
		this.leaveReason = leaveReason;
		this.collegeLeaveDate = leaveDate;
		this.status = status;
		this.issuedconduct = issuedconduct;
		this.photoid = photoid;
		this.photoname = photoname;
		this.tcid = tcid;
		this.tcname = tcname;
		this.ccid = ccid;
		this.ccname = ccname;
		this.scid = scid;
		this.scname = scname;
		this.mmid = mmid;
		this.mmname = mmname;
		this.rectcid = rectcid;
		this.rectcname = rectcname;
		this.recccid = recccid;
		this.recccname = recccname;
		this.recscid = recscid;
		this.recscname = recscname;
		this.recmmid = recmmid;
		this.recmmname = recmmname;
		this.createdby = createdby;
		this.createddate = createddate;
		this.updatedby = updatedby;
		this.updateddate = updateddate;
		this.orgId = orgId;
		this.studentType = studentType;
	}

	public Integer getStudentSeq() {
		return studentSeq;
	}

	public void setStudentSeq(Integer studentSeq) {
		this.studentSeq = studentSeq;
	}

	public Long getAdmissionNo() {
		return admissionNo;
	}

	public void setAdmissionNo(Long admissionNo) {
		this.admissionNo = admissionNo;
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

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public Long getRollNo() {
		return rollNo;
	}

	public void setRollNo(Long rollNo) {
		this.rollNo = rollNo;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getCastename() {
		return castename;
	}

	public void setCastename(String castename) {
		this.castename = castename;
	}

	public String getParentType() {
		return parentType;
	}

	public void setParentType(String parentType) {
		this.parentType = parentType;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getPremanentAddress() {
		return premanentAddress;
	}

	public void setPremanentAddress(String premanentAddress) {
		this.premanentAddress = premanentAddress;
	}

	public String getPrevschool() {
		return prevschool;
	}

	public void setPrevschool(String prevschool) {
		this.prevschool = prevschool;
	}

	public int getPrevsStudClass() {
		return prevsStudClass;
	}

	public void setPrevsStudClass(int prevsStudClass) {
		this.prevsStudClass = prevsStudClass;
	}

	public String getPrevsStudyear() {
		return prevsStudyear;
	}

	public void setPrevsStudyear(String prevsStudyear) {
		this.prevsStudyear = prevsStudyear;
	}

	public String getPrevsReleaveReason() {
		return prevsReleaveReason;
	}

	public void setPrevsReleaveReason(String prevsReleaveReason) {
		this.prevsReleaveReason = prevsReleaveReason;
	}

	public String getIssuedconduct() {
		return issuedconduct;
	}

	public void setIssuedconduct(String issuedconduct) {
		this.issuedconduct = issuedconduct;
	}

	public boolean isRecTc() {
		return recTc;
	}

	public void setRecTc(boolean recTc) {
		this.recTc = recTc;
	}

	public boolean isRecCC() {
		return recCC;
	}

	public void setRecCC(boolean recCC) {
		this.recCC = recCC;
	}

	public boolean isRecSC() {
		return recSC;
	}

	public void setRecSC(boolean recSC) {
		this.recSC = recSC;
	}

	public boolean isRecMarks() {
		return recMarks;
	}

	public void setRecMarks(boolean recMarks) {
		this.recMarks = recMarks;
	}

	public String getPrevconduct() {
		return prevconduct;
	}

	public void setPrevconduct(String prevconduct) {
		this.prevconduct = prevconduct;
	}

	public boolean isIssTc() {
		return issTc;
	}

	public void setIssTc(boolean issTc) {
		this.issTc = issTc;
	}

	public boolean isIssCC() {
		return issCC;
	}

	public void setIssCC(boolean issCC) {
		this.issCC = issCC;
	}

	public boolean isIssSC() {
		return issSC;
	}

	public void setIssSC(boolean issSC) {
		this.issSC = issSC;
	}

	public boolean isIssMarks() {
		return issMarks;
	}

	public void setIssMarks(boolean issMarks) {
		this.issMarks = issMarks;
	}

	public Date getTcIssDate() {
		return tcIssDate;
	}

	public void setTcIssDate(Date tcIssDate) {
		this.tcIssDate = tcIssDate;
	}

	public Date getMarksIssDate() {
		return marksIssDate;
	}

	public void setMarksIssDate(Date marksIssDate) {
		this.marksIssDate = marksIssDate;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getPhotoid() {
		return photoid;
	}

	public void setPhotoid(Long photoid) {
		this.photoid = photoid;
	}

	public Long getTcid() {
		return tcid;
	}

	public void setTcid(Long tcid) {
		this.tcid = tcid;
	}

	public Long getCcid() {
		return ccid;
	}

	public void setCcid(Long ccid) {
		this.ccid = ccid;
	}

	public Long getScid() {
		return scid;
	}

	public void setScid(Long scid) {
		this.scid = scid;
	}

	public Long getMmid() {
		return mmid;
	}

	public void setMmid(Long mmid) {
		this.mmid = mmid;
	}

	public String getPhotoname() {
		return photoname;
	}

	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}

	public String getTcname() {
		return tcname;
	}

	public void setTcname(String tcname) {
		this.tcname = tcname;
	}

	public String getCcname() {
		return ccname;
	}

	public void setCcname(String ccname) {
		this.ccname = ccname;
	}

	public String getScname() {
		return scname;
	}

	public void setScname(String scname) {
		this.scname = scname;
	}

	public String getMmname() {
		return mmname;
	}

	public void setMmname(String mmname) {
		this.mmname = mmname;
	}

	public Long getRectcid() {
		return rectcid;
	}

	public void setRectcid(Long rectcid) {
		this.rectcid = rectcid;
	}

	public String getRectcname() {
		return rectcname;
	}

	public void setRectcname(String rectcname) {
		this.rectcname = rectcname;
	}

	public Long getRecccid() {
		return recccid;
	}

	public void setRecccid(Long recccid) {
		this.recccid = recccid;
	}

	public String getRecccname() {
		return recccname;
	}

	public void setRecccname(String recccname) {
		this.recccname = recccname;
	}

	public Long getRecscid() {
		return recscid;
	}

	public void setRecscid(Long recscid) {
		this.recscid = recscid;
	}

	public String getRecscname() {
		return recscname;
	}

	public void setRecscname(String recscname) {
		this.recscname = recscname;
	}

	public Long getRecmmid() {
		return recmmid;
	}

	public void setRecmmid(Long recmmid) {
		this.recmmid = recmmid;
	}

	public String getRecmmname() {
		return recmmname;
	}

	public void setRecmmname(String recmmname) {
		this.recmmname = recmmname;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public java.util.Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(java.util.Date createddate) {
		this.createddate = createddate;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public Date getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	public Long getHostelFee() {
		return hostelFee;
	}

	public void setHostelFee(Long hostelFee) {
		this.hostelFee = hostelFee;
	}

	public Long getHostelPaidfee() {
		return hostelPaidfee;
	}

	public void setHostelPaidfee(Long hostelPaidfee) {
		this.hostelPaidfee = hostelPaidfee;
	}

	public Long getHostelBalanceFee() {
		return hostelBalanceFee;
	}

	public void setHostelBalanceFee(Long hostelBalanceFee) {
		this.hostelBalanceFee = hostelBalanceFee;
	}

	public Long getCollegeFee() {
		return collegeFee;
	}

	public void setCollegeFee(Long collegeFee) {
		this.collegeFee = collegeFee;
	}

	public Long getCollegePaidFee() {
		return collegePaidFee;
	}

	public void setCollegePaidFee(Long collegePaidFee) {
		this.collegePaidFee = collegePaidFee;
	}

	public Long getCollegeBlanceFee() {
		return collegeBlanceFee;
	}

	public void setCollegeBlanceFee(Long collegeBlanceFee) {
		this.collegeBlanceFee = collegeBlanceFee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getHostelAdmissionNo() {
		return hostelAdmissionNo;
	}

	public void setHostelAdmissionNo(Long hostelAdmissionNo) {
		this.hostelAdmissionNo = hostelAdmissionNo;
	}

	public String getStudentType() {
		return studentType;
	}

	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}

	public int getStudyingyear() {
		return studyingyear;
	}

	public void setStudyingyear(int studyingyear) {
		this.studyingyear = studyingyear;
	}

	public String getHostelName() {
		return hostelName;
	}

	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}

	public Date getHostelJoinDate() {
		return hostelJoinDate;
	}

	public void setHostelJoinDate(Date hostelJoinDate) {
		this.hostelJoinDate = hostelJoinDate;
	}

	public Date getHostelLeftDate() {
		return hostelLeftDate;
	}

	public void setHostelLeftDate(Date hostelLeftDate) {
		this.hostelLeftDate = hostelLeftDate;
	}

	public String getHostelLeftReason() {
		return hostelLeftReason;
	}

	public void setHostelLeftReason(String hostelLeftReason) {
		this.hostelLeftReason = hostelLeftReason;
	}

	public java.util.Date getCollegeLeaveDate() {
		return collegeLeaveDate;
	}

	public void setCollegeLeaveDate(java.util.Date collegeLeaveDate) {
		this.collegeLeaveDate = collegeLeaveDate;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

}
