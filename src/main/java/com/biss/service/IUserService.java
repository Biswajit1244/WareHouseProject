package com.biss.service;

import java.util.List;

import com.biss.model.User;

public interface IUserService {
	Integer saveUser(User ob);
	List<User> getAllUser();
	void deleteUser(Integer id);
	
	User getOneUser(Integer id);
	void updateUser(User sp);
}
