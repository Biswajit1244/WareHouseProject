package com.biss.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.biss.dao.IUomTypeDao;
import com.biss.model.UomType;
@Repository
public class UomTypeDaoImpl implements IUomTypeDao {
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveUomType(UomType ob) {
		return (Integer) ht.save(ob);
	}

	@Override
	public List<UomType> getAllUomType() {
		return ht.loadAll(UomType.class);
	}

	@Override
	public void deleteUomType(Integer id) {
		ht.delete(new UomType(id));
	}

}
