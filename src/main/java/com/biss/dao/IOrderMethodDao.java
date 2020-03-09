package com.biss.dao;

import java.util.List;

import com.biss.model.OrderMethod;

public interface IOrderMethodDao {
	Integer saveOrderMethod(OrderMethod ob);
	List<OrderMethod> getAllOrderMethod();
	void deleteOrderMethod(Integer id);
	
	OrderMethod getOneOrderMethod(Integer id);
	void updateOrderMethod(OrderMethod sp);
	
	List<Object[]> getOrderTypeCount();
	List<Object[]> getOmIdAndOmCode(String mode);
}
