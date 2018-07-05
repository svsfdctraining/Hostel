package com.school.service;

import java.util.List;
import java.util.Map;

import com.school.bean.UserBean;
import com.school.bean.UserOrgBean;
import com.school.pojo.User;

public interface UserService {

	void addUser(User user);

	Map<String, User> getUsers();

	UserBean getUser(String userName);
	
	List<UserOrgBean> getOrganizations();

	Object getAllUsers();

}
