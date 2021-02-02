package com.biss.dao;

import java.util.List;

import com.biss.model.Purchase;
import com.biss.model.PurchaseDtls;

public interface IPurchaseDao {
	Integer savePurchase(Purchase ob);
	List<Purchase> getAllPurchase();
	void deletePurchase(Integer id);
	
	Purchase getOnePurchase(Integer id);
	void updatePurchase(Purchase sp);
	
	Integer savePurchaseDtls(PurchaseDtls dtls);
	void deletePurchaseDtls(Integer id);
	void updatePurchaseStatus(Integer id,String status);
	
	List<Object[]> getPurIdAndCode();
}
