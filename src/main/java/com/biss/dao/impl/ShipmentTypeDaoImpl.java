package com.biss.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.biss.dao.IShipmentTypeDao;
import com.biss.model.ShipmentType;
@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveShipmentType(ShipmentType ob) {
		return (Integer) ht.save(ob);
	}
	@Override
	public List<ShipmentType> getAllShipmentType() {
		return ht.loadAll(ShipmentType.class);
	}
	@Override
	public void deleteShipmentType(Integer id) {
		ht.delete(new ShipmentType(id));
	}
	@Override
	public ShipmentType getOneShipment(Integer id) {
		return ht.get(ShipmentType.class, id);
	}
	@Override
	public void updateShipmentType(ShipmentType sp) {
		ht.update(sp);
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getShipmentModeCount() {
		String hql=" select shipMode,count(shipMode) "
				+ " from com.biss.model.ShipmentType "
				+ " group by shipMode ";
		return (List<Object[]>) ht.find(hql);
	}
}
