package com.biss.service;

import java.util.List;

import com.biss.model.Purchase;

public interface IPurchaseService {
	Integer savePurchase(Purchase ob);
	List<Purchase> getAllPurchase();
	void deletePurchase(Integer id);
	
	Purchase getOnePurchase(Integer id);
	void updatePurchase(Purchase sp);
}
