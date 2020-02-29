package com.biss.service;

import java.util.List;

import com.biss.model.ShipmentType;

public interface IShipmentTypeService {
	
	Integer saveShipmentType(ShipmentType ob);
	List<ShipmentType> getAllShipmentType();
	void deleteShipmentType(Integer id);
	
	ShipmentType getOneShipment(Integer id);
	void updateShipmentType(ShipmentType sp);
	
	List<Object[]> getShipmentModeCount();
}
