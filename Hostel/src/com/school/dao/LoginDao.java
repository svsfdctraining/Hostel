package com.school.dao;

import com.school.pojo.Organization;
import com.school.pojo.User;

public interface LoginDao {

	Organization validateLogin(User user);

	User login(User user);
}
