package com.biss.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biss.dao.ISaleDao;
import com.biss.model.Sale;
import com.biss.service.ISaleService;
@Service
public class SaleServiceImpl implements ISaleService {
	@Autowired
	private ISaleDao dao;
	
	@Transactional
	public Integer saveSale(Sale ob) {
		return dao.saveSale(ob);
	}
	@Transactional(readOnly = true)
	public List<Sale> getAllSale() {
		List<Sale> list=dao.getAllSale();
		Collections.sort(list, (o1,o2)-> o1.getSaleId()-o2.getSaleId());
		return list;
	}
	@Transactional
	public void deleteSale(Integer id) {
		dao.deleteSale(id);
	}
	@Transactional(readOnly = true)
	public Sale getOneSale(Integer id) {
		return dao.getOneSale(id);
	}
	
	@Transactional
	public void updateSale(Sale sp) {
		dao.updateSale(sp);
	}

}
