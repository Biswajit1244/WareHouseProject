package com.biss.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.biss.dao.IPurchaseDao;
import com.biss.model.Purchase;
@Repository
public class PurchaseDaoImpl implements IPurchaseDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer savePurchase(Purchase ob) {
		return (Integer) ht.save(ob);
	}
	@Override
	public List<Purchase> getAllPurchase() {
		return ht.loadAll(Purchase.class);
	}
	@Override
	public void deletePurchase(Integer id) {
		ht.delete(new Purchase(id));
	}
	@Override
	public Purchase getOnePurchase(Integer id) {
		return ht.get(Purchase.class, id);
	}
	@Override
	public void updatePurchase(Purchase sp) {
		ht.update(sp);
	}
	

}
