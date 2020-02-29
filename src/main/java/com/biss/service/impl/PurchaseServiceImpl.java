package com.biss.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biss.dao.IPurchaseDao;
import com.biss.model.Purchase;
import com.biss.service.IPurchaseService;
@Service
public class PurchaseServiceImpl implements IPurchaseService {
	@Autowired
	private IPurchaseDao dao;
	
	@Transactional
	public Integer savePurchase(Purchase ob) {
		return dao.savePurchase(ob);
	}
	@Transactional(readOnly = true)
	public List<Purchase> getAllPurchase() {
		List<Purchase> list=dao.getAllPurchase();
		Collections.sort(list, (o1,o2)-> o1.getPurId()-o2.getPurId());
		return list;
	}
	@Transactional
	public void deletePurchase(Integer id) {
		dao.deletePurchase(id);
	}
	@Transactional(readOnly = true)
	public Purchase getOnePurchase(Integer id) {
		return dao.getOnePurchase(id);
	}
	
	@Transactional
	public void updatePurchase(Purchase sp) {
		dao.updatePurchase(sp);
	}

}
