package com.school.dao;

import java.util.List;

import com.school.pojo.Caste;
import com.school.pojo.Hostel;
import com.school.pojo.Organization;
import com.school.pojo.Religion;
import com.school.pojo.UserRole;

public interface UtilityDao {

	boolean saveCaste(Caste caste);

	List<Caste> getAllCastes();

	String validateCaste(String caste);

	List<Religion> getAllReligions();

	boolean saveReligion(Religion religion);

	void saveOrganization(Organization organization);

	List<Organization> getAllOrganizations(Organization organization);

	Organization getOrganization(Organization organization);

	boolean saveRole(UserRole userrole);

	List<UserRole> getAllRoles();

	void saveEditedRoles(List<UserRole> userroles);

	void saveHostel(Hostel hostel);

	List<Hostel> getHostels(int intValue);

	Hostel getHostel(String hostelname);
}
