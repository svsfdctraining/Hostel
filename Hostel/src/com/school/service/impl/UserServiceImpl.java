package com.school.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.bean.UserBean;
import com.school.bean.UserOrgBean;
import com.school.dao.UserDao;
import com.school.dao.UtilityDao;
import com.school.pojo.Organization;
import com.school.pojo.User;
import com.school.service.UserService;

@Service("userService")
@Transactional(readOnly=false)
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Autowired
	private UtilityDao utilityDao;
	@Override
	public void addUser(User user) {
		
		user.setCreatedDate(new Date());
		userDao.saveUser(user);
		
	}

	@Override
	public Map<String, User> getUsers() {
		List<User> list = userDao.selectAllUsers();
		Map<String, User> map = new HashMap<String, User>();
		for(User user : list){
			map.put(user.getEmail(), user);
		}
		return map;
	}

	@Override
	public UserBean getUser(String userName) {
		
		User user= userDao.getUser(userName);
		
		if(user == null){
			return null;
		}
		return new UserBean();
	}
	
	@Override
	public List<UserOrgBean> getOrganizations() {
		List<UserOrgBean> list = new ArrayList<UserOrgBean>();
		for(Organization o:utilityDao.getAllOrganizations(new Organization())){
			list.add(new UserOrgBean(o.getOrgId(), o.getOrgName()));
		}
		return list;
	}
	
	@Override
	public Object getAllUsers() {
		
		return userDao.getAllUsers();
	}
}
