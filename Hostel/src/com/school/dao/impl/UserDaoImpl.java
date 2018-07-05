package com.school.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.school.dao.UserDao;
import com.school.pojo.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

		
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectAllUsers() {
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	@Override
	public User getUser(String userName) {
		User user=null;
		@SuppressWarnings("unchecked")
		List<User> list = sessionFactory.getCurrentSession().createQuery(" from com.hostel.pojo.User where userName =?").setParameter(0, userName).list();
		if(list.size()>0){
			user= list.get(0);
		}
		return user;
	}
	
	@Override
	public Object getAllUsers() {
		
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}
}
