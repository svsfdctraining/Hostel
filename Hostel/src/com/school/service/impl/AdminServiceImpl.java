package com.school.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.dao.AdminDao;
import com.school.pojo.OrganizationMedium;
import com.school.pojo.StudentClass;
import com.school.pojo.StudentClassSection;
import com.school.pojo.User;
import com.school.service.AdminService;

@Service("adminService")
@Transactional(readOnly = false)
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Override
	public void saveclass(StudentClass studentclass,User user) {

		studentclass.setOrganization(user.getOrgId());
		studentclass.setClassValue(studentclass.getClassDesc());
		adminDao.saveclass(studentclass);

	}

	@Override
	public List<StudentClass> getAllClasses(User user) {

		return adminDao.getAllClasses(user);
	}

	@Override
	public void saveEditedClasses(List<StudentClass> classes) {

		adminDao.saveEditedClasses(classes);
	}

	@Override
	public void savemedium(OrganizationMedium organizationMedium,User user) {
		
		organizationMedium.setOrganization(user.getOrgId());
		adminDao.saveMedium(organizationMedium);
	}

	@Override
	public List<OrganizationMedium> getAllMediums(User user) {

		return adminDao.getAllMediums(user);
	}

	@Override
	public void saveEditedMediums(List<OrganizationMedium> mediums) {

		adminDao.saveEditedMediums(mediums);
	}

	@Override
	public void saveSection(StudentClassSection section,User user) {
		section.setOrgid(user.getOrgId());
		section.setStatus("Active");
		adminDao.saveSection(section);
	}
	
	@Override
	public List<StudentClassSection> getAllSections(String stclass, User user,boolean mode) {
		
		return adminDao.getClassSections(stclass,user,mode);
	}
	
	@Override
	public void saveEditedSections(List<StudentClassSection> sections) {

		adminDao.saveEditedSections(sections);
	}
}
