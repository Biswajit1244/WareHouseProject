package com.biss.service;

import java.util.List;

import com.biss.model.OrderMethod;

public interface IOrderMethodService {
	Integer saveOrderMethod(OrderMethod ob);
	List<OrderMethod> getAllOrderMethod();
	void deleteOrderMethod(Integer id);
	
	OrderMethod getOneOrderMethod(Integer id);
	void updateOrderMethod(OrderMethod sp);
}
