package com.biss.service;

import java.util.List;

import com.biss.model.Shipping;

public interface IShippingService {
	Integer saveShipping(Shipping ob);
	List<Shipping> getAllShipping();
	void deleteShipping(Integer id);
	
	Shipping getOneShipping(Integer id);
	void updateShipping(Shipping sp);
}
