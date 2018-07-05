package com.school.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.dao.UtilityDao;
import com.school.pojo.Caste;
import com.school.pojo.Hostel;
import com.school.pojo.Organization;
import com.school.pojo.Religion;
import com.school.pojo.UserRole;
import com.school.service.UtilityService;

@Service("utilityService")
@Transactional(readOnly = false)
public class UtilityServiceImpl implements UtilityService {

	@Autowired
	private UtilityDao utilityDao;

	@Override
	public boolean saveCaste(Caste caste) {
		return utilityDao.saveCaste(caste);
	}

	@Override
	public List<Caste> getAllCastes() {

		return utilityDao.getAllCastes();
	}

	@Override
	public String validateCaste(String caste) {

		return null;
	}

	@Override
	public List<Religion> getAllReligions() {

		return utilityDao.getAllReligions();
	}

	@Override
	public boolean saveReligion(Religion religion) {

		return utilityDao.saveReligion(religion);

	}

	@Override
	public void saveOrganization(Organization organization) {

		utilityDao.saveOrganization(organization);
	}

	@Override
	public List<Organization> getAllOrganizations(Organization organization) {
		// organization.setCreatedDate(new Date());
		return utilityDao.getAllOrganizations(organization);
	}

	@Override
	public Organization getOrganization(Organization organization) {

		return utilityDao.getOrganization(organization);
	}

	@Override
	public boolean saveRole(UserRole userrole) {

		return utilityDao.saveRole(userrole);

	}

	@Override
	public List<UserRole> getAllRoles() {

		return utilityDao.getAllRoles();
	}

	@Override
	public void saveEditedRoles(List<UserRole> userroles) {

		utilityDao.saveEditedRoles(userroles);

	}

	@Override
	public void saveHostel(Hostel hostel) {
		hostel.setCreatedDate(new Date());
		Organization org = new Organization();
		org.setOrgName(hostel.getOrgname());
		hostel.setStatus("Active");
		hostel.setOrgid(utilityDao.getOrganization(org).getOrgId());
		utilityDao.saveHostel(hostel);

	}

	@Override
	public List<Hostel> getHostels(String parameter) {

		return utilityDao.getHostels(new Integer(parameter).intValue());
	}
	
	@Override
	public Hostel getHostel(String hostelname) {
		
		return utilityDao.getHostel(hostelname);
	}
}
