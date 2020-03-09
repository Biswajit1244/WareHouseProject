package com.biss.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.biss.dao.IShippingDao;
import com.biss.model.Shipping;
@Repository
public class ShippingDaoImpl implements IShippingDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveShipping(Shipping ob) {
		return (Integer) ht.save(ob);
	}
	@Override
	public List<Shipping> getAllShipping() {
		return ht.loadAll(Shipping.class);
	}
	@Override
	public void deleteShipping(Integer id) {
		ht.delete(new Shipping(id));
	}
	@Override
	public Shipping getOneShipping(Integer id) {
		return ht.get(Shipping.class, id);
	}
	@Override
	public void updateShipping(Shipping sp) {
		ht.update(sp);
	}

}
