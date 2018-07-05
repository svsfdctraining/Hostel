package com.school.bean;

import java.io.Serializable;

import com.school.pojo.User;

public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1604902308016023067L;

	private String Password1;
	private String Password2;
	private User user;

	public UserBean() {
		// TODO Auto-generated constructor stub
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserBean(String password1, String password2, User user) {
		super();
		Password1 = password1;
		Password2 = password2;
		this.user = user;
	}

	public String getPassword1() {
		return Password1;
	}

	public void setPassword1(String password1) {
		Password1 = password1;
	}

	public String getPassword2() {
		return Password2;
	}

	public void setPassword2(String password2) {
		Password2 = password2;
	}

}
