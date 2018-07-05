package com.school.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.school.dao.LoginDao;
import com.school.pojo.Organization;
import com.school.pojo.User;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Organization validateLogin(User user) {

		List<Organization> organizations = (List<Organization>) sessionFactory.getCurrentSession().createCriteria(Organization.class)
					.add(Restrictions.eq("orgId", user.getOrgId()))
					.add(Restrictions.eq("status", "Active")).list();
					
		if(!organizations.isEmpty()){
			return organizations.get(0);
		}
					
		return null;
	}


	@Override
	public User login(User user) {
		List<User> users=(List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("email", user.getEmail())).
				add(Restrictions.eq("userPassword", user.getUserPassword())).
				add(Restrictions.eq("status", "Active")).list();
		if(!users.isEmpty())
			return users.get(0);
		
		return null;
	}
}
