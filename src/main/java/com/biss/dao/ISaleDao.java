package com.biss.dao;

import java.util.List;

import com.biss.model.Sale;

public interface ISaleDao {
	Integer saveSale(Sale ob);
	List<Sale> getAllSale();
	void deleteSale(Integer id);
	
	Sale getOneSale(Integer id);
	void updateSale(Sale sp);
	
}
