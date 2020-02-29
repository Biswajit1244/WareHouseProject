package com.biss.dao;

import java.util.List;

import com.biss.model.Purchase;

public interface IPurchaseDao {
	Integer savePurchase(Purchase ob);
	List<Purchase> getAllPurchase();
	void deletePurchase(Integer id);
	
	Purchase getOnePurchase(Integer id);
	void updatePurchase(Purchase sp);
	
}
