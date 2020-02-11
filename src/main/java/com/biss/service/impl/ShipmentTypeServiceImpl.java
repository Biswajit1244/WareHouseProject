package com.biss.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biss.dao.IShipmentTypeDao;
import com.biss.model.ShipmentType;
import com.biss.service.IShipmentTypeService;
@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {
	
	@Autowired
	private IShipmentTypeDao dao;
	
	@Transactional
	public Integer saveShipmentType(ShipmentType ob) {
		return dao.saveShipmentType(ob);
	}

}
