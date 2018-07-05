package com.school.service;

import com.school.pojo.Organization;
import com.school.pojo.User;

public interface LoginService {

	Organization validatelogin(User user);
	User login(User user);
}
