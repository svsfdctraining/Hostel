package com.school.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.school.dao.AdminDao;
import com.school.pojo.OrganizationMedium;
import com.school.pojo.StudentClass;
import com.school.pojo.StudentClassSection;
import com.school.pojo.User;

@Repository("adminDao")
public class AdminDaoImpl  implements AdminDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveclass(StudentClass studentclass) {

		sessionFactory.getCurrentSession().save(studentclass);

	}

	@Override
	public List<StudentClass> getAllClasses(User user) {

		return sessionFactory.getCurrentSession()
				.createCriteria(StudentClass.class).add(Restrictions.eq("organization", user.getOrgId())).list();
	}

	@Override
	public void saveEditedClasses(List<StudentClass> classes) {

		for (StudentClass sc : classes) {
			sessionFactory.getCurrentSession().update(sc);
		}
	}
	
	@Override
	public void saveMedium(OrganizationMedium organizationMedium) {
		
		sessionFactory.getCurrentSession().save(organizationMedium);
		
	}
	
	@Override
	public List<OrganizationMedium> getAllMediums(User user) {
					
		Session session = sessionFactory.openSession();
		List<OrganizationMedium> list = session.createCriteria(OrganizationMedium.class).add(Restrictions.eq("organization", user.getOrgId())).list();
		session.close();
		return list;
	}
	
	@Override
	public void saveEditedMediums(List<OrganizationMedium> mediums) {
		
		for (OrganizationMedium md : mediums) {
			sessionFactory.getCurrentSession().update(md);
		}
	}

	@Override
	public void saveSection(StudentClassSection section) {
		
		sessionFactory.getCurrentSession().save(section);
		
	}
	
	@Override
	public List<StudentClassSection> getClassSections(String stclass, User user,boolean mode) {
		
		if(stclass ==null){
			return (List<StudentClassSection>) sessionFactory.getCurrentSession().createCriteria(StudentClassSection.class).
					add(Restrictions.eq("orgid", user.getOrgId())).list();
		}
		if(mode){
			return (List<StudentClassSection>) sessionFactory.getCurrentSession().createCriteria(StudentClassSection.class).
					add(Restrictions.eq("stclass", stclass)).
					add(Restrictions.eq("orgid", user.getOrgId())).list();
		}
		
		return sessionFactory.getCurrentSession().createQuery("from StudentClassSection sc where sc.stclass=:stcls and sc.status=:sts and sc.orgid=:orgId and sc.noofstudents<sc.students")
		.setParameter("stcls", stclass)
		.setParameter("sts", "Active")
		.setParameter("orgId", user.getOrgId()).list();
		/*return (List<StudentClassSection>) sessionFactory.getCurrentSession().createCriteria(StudentClassSection.class).
				add(Restrictions.eq("stclass", stclass)).add(Restrictions.eq("status", "Active")).
				add(Restrictions.eq("orgid", user.getOrgId())).list();*/
	}
	
	
	@Override
	public void saveEditedSections(List<StudentClassSection> sections) {

		for(StudentClassSection section : sections){
			
			sessionFactory.getCurrentSession().update(section);
		}
	}
}
