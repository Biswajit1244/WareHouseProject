package com.biss.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.biss.dao.ISaleDao;
import com.biss.model.Sale;

@Repository
public class SaleDaoImpl implements ISaleDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveSale(Sale ob) {
		return (Integer) ht.save(ob);
	}
	@Override
	public List<Sale> getAllSale() {
		return ht.loadAll(Sale.class);
	}
	@Override
	public void deleteSale(Integer id) {
		ht.delete(new Sale(id));
	}
	@Override
	public Sale getOneSale(Integer id) {
		return ht.get(Sale.class, id);
	}
	@Override
	public void updateSale(Sale sp) {
		ht.update(sp);
	}


}
