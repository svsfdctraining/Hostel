package com.school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.dao.LoginDao;
import com.school.pojo.Organization;
import com.school.pojo.User;
import com.school.service.LoginService;

@Service("loginService")
@Transactional(readOnly=false)
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public Organization validatelogin(User user) {
		
		return loginDao.validateLogin(user);
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return loginDao.login(user);
	}
}
