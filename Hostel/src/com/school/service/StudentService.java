package com.school.service;

import java.util.List;

import com.school.bean.StudentBean;
import com.school.bean.StudentResult;
import com.school.pojo.Organization;
import com.school.pojo.OrganizationMedium;
import com.school.pojo.Student;
import com.school.pojo.StudentClass;
import com.school.pojo.User;
import com.school.util.bean.YearBean;

public interface StudentService {

	void saveStudent(StudentBean studentbean, User user);

	StudentClass getclassfee(String stclass, User user);

	String saveDocument(StudentBean studentbean, User user);

	Long getAdmissionNo(User user);

	Long getStudentRollNum(StudentBean studentbean, User user);

	List<StudentClass> getPrevclasses(StudentBean studentbean);

	List<YearBean> getAcademicyears(User user, Organization organization);

	List<Student> getSearchResults(StudentBean studentbean, User user);

	Student getStudent(Integer studentSeq);

	String getDocumentPath(Long documentid);

	void uploadFile(StudentBean studentbean, User user);

	void saveUploadedData(List<StudentResult> uploadresults);

	String downloadStudents(StudentBean studentbean,User user);

	List<YearBean> getCourseYears(String stclass, User user);

	List<OrganizationMedium> getMediums(User user);

}
