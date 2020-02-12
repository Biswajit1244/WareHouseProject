package com.biss.dao;

import java.util.List;

import com.biss.model.ShipmentType;

public interface IShipmentTypeDao {
	
	Integer saveShipmentType(ShipmentType ob);
	List<ShipmentType> getAllShipmentType();
}
