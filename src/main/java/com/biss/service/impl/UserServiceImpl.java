package com.biss.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biss.dao.IUserDao;
import com.biss.model.User;

@Service
public class UserServiceImpl implements IUserDao{
	@Autowired
	private IUserDao dao;
	
	@Transactional
	public Integer saveUser(User ob) {
		return dao.saveUser(ob);
	}
	@Transactional(readOnly = true)
	public List<User> getAllUser() {
		List<User> list=dao.getAllUser();
		Collections.sort(list, (o1,o2)-> o1.getUserId()-o2.getUserId());
		return list;
	}
	@Transactional
	public void deleteUser(Integer id) {
		dao.deleteUser(id);
	}
	@Transactional(readOnly = true)
	public User getOneUser(Integer id) {
		return dao.getOneUser(id);
	}
	
	@Transactional
	public void updateUser(User sp) {
		dao.updateUser(sp);
	}
}
