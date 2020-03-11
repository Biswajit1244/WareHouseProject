package com.biss.service.impl;

import java.util.Collections;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional(readOnly = true)
	public List<ShipmentType> getAllShipmentType() {
		List<ShipmentType> list=dao.getAllShipmentType();
		Collections.sort(list, (o1,o2)-> o1.getShipId()-o2.getShipId());
		return list;
	}
	@Transactional
	public void deleteShipmentType(Integer id) {
		dao.deleteShipmentType(id);
	}
	@Transactional(readOnly = true)
	public ShipmentType getOneShipment(Integer id) {
		return dao.getOneShipment(id);
	}
	
	@Transactional
	public void updateShipmentType(ShipmentType sp) {
		dao.updateShipmentType(sp);
	}
	@Transactional(readOnly = true)
	public List<Object[]> getShipmentModeCount() {
		return dao.getShipmentModeCount();
	}
	@Transactional(readOnly = true)
	public List<Object[]> getShipmentIdAndCode() {
		return dao.getShipmentIdAndCode();
	}
}
