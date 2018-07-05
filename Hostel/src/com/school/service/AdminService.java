package com.school.service;

import java.util.List;

import com.school.pojo.OrganizationMedium;
import com.school.pojo.StudentClass;
import com.school.pojo.StudentClassSection;
import com.school.pojo.User;

public interface AdminService {

	void saveclass(StudentClass studentclass,User user);

	List<StudentClass> getAllClasses(User user);

	void saveEditedClasses(List<StudentClass> classes);

	void savemedium(OrganizationMedium organizationMedium,User user);

	List<OrganizationMedium> getAllMediums(User user);

	void saveEditedMediums(List<OrganizationMedium> mediums);

	void saveSection(StudentClassSection section, User user);

	List<StudentClassSection> getAllSections(String stclass, User user,boolean mode);

	void saveEditedSections(List<StudentClassSection> sections);
}
