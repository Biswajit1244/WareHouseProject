package com.biss.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.biss.dao.IWhUserTypeDao;
import com.biss.model.WhUserType;
@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveWhUser(WhUserType ob) {
		return (Integer) ht.save(ob);
	}

	@Override
	public List<WhUserType> getAllWhUser() {
		return ht.loadAll(WhUserType.class);
	}

	@Override
	public void deleteWhUser(Integer id) {
		WhUserType wh=new WhUserType();
		wh.setUserId(id);
		ht.delete(wh);
	}
	@Override
	public WhUserType getOneWhUserType(Integer id) {
		return ht.get(WhUserType.class, id);
	}
	@Override
	public void updateWhUserType(WhUserType sp) {
		ht.update(sp);
	}
}
