package com.biss.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.biss.dao.IUserDao;
import com.biss.model.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	HibernateTemplate ht;
	
	@Override
	public Integer saveUser(User ob) {
		return (Integer) ht.save(ob);
	}
	@Override
	public List<User> getAllUser() {
		return ht.loadAll(User.class);
	}
	@Override
	public void deleteUser(Integer id) {
		ht.delete(new User(id));
	}
	@Override
	public User getOneUser(Integer id) {
		return ht.get(User.class, id);
	}
	@Override
	public void updateUser(User sp) {
		ht.update(sp);
	}

}
