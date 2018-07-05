package com.school.dao;

import java.util.List;

import com.school.pojo.User;

public interface UserDao {

	void saveUser(User userPojo);

	List<User> selectAllUsers();

	User getUser(String userName);

	Object getAllUsers();

}
