package com.biss.service;

import java.util.List;

import com.biss.model.Sale;

public interface ISaleService {
	Integer saveSale(Sale ob);
	List<Sale> getAllSale();
	void deleteSale(Integer id);
	
	Sale getOneSale(Integer id);
	void updateSale(Sale sp);
}
