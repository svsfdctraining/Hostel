package com.school.dao;

import java.util.List;

import com.school.pojo.OrganizationMedium;
import com.school.pojo.StudentClass;
import com.school.pojo.StudentClassSection;
import com.school.pojo.User;

public interface AdminDao {

	void saveclass(StudentClass studentclass);

	List<StudentClass> getAllClasses(User user);

	void saveEditedClasses(List<StudentClass> classes);

	void saveMedium(OrganizationMedium organizationMedium);

	List<OrganizationMedium> getAllMediums(User user);

	void saveEditedMediums(List<OrganizationMedium> mediums);

	void saveSection(StudentClassSection section);

	List<StudentClassSection> getClassSections(String stclass, User user,boolean mode);

	void saveEditedSections(List<StudentClassSection> sections);
}
