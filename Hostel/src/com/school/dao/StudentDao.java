package com.school.dao;

import java.util.List;

import com.school.bean.StudentBean;
import com.school.pojo.Document;
import com.school.pojo.OrganizationMedium;
import com.school.pojo.Student;
import com.school.pojo.StudentClass;
import com.school.pojo.User;

public interface StudentDao {

	void saveStudent(StudentBean studentbean, User user);

	StudentClass getclassfee(String stclass, User user);

	Long getAdmissionNum(User user);

	Long getStudentRollNum(StudentBean studentbean, User user);

	List<Student> getSearchResults(StudentBean studentbean, User user);

	Student getStudent(Integer studentSeq);

	Document getDocumentContent(Long photoid,String type);

	void saveUploadedStudents(List<Student> students);

	int getCourseYears(String stclass, int i);

	List<OrganizationMedium> getMediums(int orgId);

	

}
