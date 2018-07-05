package com.school.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.school.dao.UtilityDao;
import com.school.pojo.Caste;
import com.school.pojo.Hostel;
import com.school.pojo.Organization;
import com.school.pojo.Religion;
import com.school.pojo.UserRole;

@Repository("utilityDao")
public class UtilityDaoImpl implements UtilityDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveCaste(Caste caste) {
		List<Caste> excaste = (List<Caste>) sessionFactory.getCurrentSession().createQuery("from Caste where castename=:cstname").setParameter("cstname", caste.getCastename()).list();
		if(excaste.isEmpty()){
		sessionFactory.getCurrentSession().save(caste);
		return true;
		}
		return false;
	}

	@Override
	public List<Caste> getAllCastes() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Caste.class);
		return criteria.list();
	}

	@Override
	public String validateCaste(String caste) {
		List<Caste> castest = ((List<Caste>) sessionFactory.getCurrentSession()
				.createCriteria(Caste.class)
				.add(Restrictions.eq("castename", caste)));
		if (castest.size() > 0)
			return "exist";
		return "notexist";
	}

	@Override
	public List<Religion> getAllReligions() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Religion.class);
		return criteria.list();
	}

	@Override
	public boolean saveReligion(Religion religion) {
		List<Religion> exreligion =  sessionFactory.getCurrentSession().createQuery("from Religion where religionname=:rname").setParameter("rname", religion.getReligionname()).list();
		if(exreligion.isEmpty()){
		sessionFactory.getCurrentSession().save(religion);
		return true;
		}
		return false;
	}

	@Override
	public void saveOrganization(Organization organization) {
		sessionFactory.getCurrentSession().saveOrUpdate(organization);
	}

	@Override
	public List<Organization> getAllOrganizations(Organization organization) {

		Criteria scriteria = sessionFactory.getCurrentSession().createCriteria(
				Organization.class);
		
		if(organization == null)
			return scriteria.list();

		if (organization.getOrgName() != null
				&& !"".equals(organization.getOrgName())) {
			scriteria.add(Restrictions.like("orgName",
					organization.getOrgName(), MatchMode.ANYWHERE));
		}
		if (organization.getRegNum() != null
				&& !"".equals(organization.getRegNum())) {
			scriteria.add(Restrictions.like("regNum", organization.getRegNum(),
					MatchMode.ANYWHERE));
		}
		if (organization.getYear() != null && organization.getYear() != 0) {
			scriteria.add(Restrictions.like("year", organization.getYear()));
		}

		return scriteria.list();

	}

	@Override
	public Organization getOrganization(Organization organization) {

		if(organization.getOrgId() ==null)
			return (Organization) sessionFactory.getCurrentSession().createCriteria(Organization.class).add(Restrictions.eq("orgName", organization.getOrgName())).list().get(0);
		return (Organization) sessionFactory.getCurrentSession().get(
				Organization.class, organization.getOrgId());
	}

	@Override
	public boolean saveRole(UserRole userrole) {
		List<UserRole> exrole = sessionFactory.getCurrentSession().createQuery("from UserRole where roleName=:rolename").setParameter("rolename", userrole.getRoleName()).list();
		if(exrole.isEmpty()){
		sessionFactory.getCurrentSession().save(userrole);
		return true;
		}
		return false;
	}

	@Override
	public List<UserRole> getAllRoles() {

		return sessionFactory.getCurrentSession().createCriteria(UserRole.class).list();
	}
	
	@Override
	public void saveEditedRoles(List<UserRole> userroles) {
		
		for(UserRole role: userroles){
			sessionFactory.getCurrentSession().update(role);
		}
		
	}
	
	@Override
	public void saveHostel(Hostel hostel) {
		sessionFactory.getCurrentSession().save(hostel);
		
	}
	
	@Override
	public List<Hostel> getHostels(int orgId) {
		return sessionFactory.getCurrentSession().createCriteria(Hostel.class).add(Restrictions.eq("orgid", orgId)).list();
	}
	
	@Override
	public Hostel getHostel(String hostelname) {
	
		return (Hostel) sessionFactory.getCurrentSession().createCriteria(Hostel.class).add(Restrictions.eq("hostelName",hostelname)).list().get(0);
	}
}
