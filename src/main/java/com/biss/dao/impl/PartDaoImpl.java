package com.biss.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.biss.dao.IPartDao;
import com.biss.model.Part;
@Repository
public class PartDaoImpl implements IPartDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer savePart(Part ob) {
		return (Integer) ht.save(ob);
	}
	@Override
	public List<Part> getAllPart() {
		return ht.loadAll(Part.class);
	}
	@Override
	public void deletePart(Integer id) {
		ht.delete(new Part(id));
	}
	@Override
	public Part getOnePart(Integer id) {
		return ht.get(Part.class, id);
	}
	@Override
	public void updatePart(Part sp) {
		ht.update(sp);
	}
	@Override
	public List<Object[]> getPartIdAndCode() {
		String hql=" select partId,partCode from com.biss.model.Part ";
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Object[]> list=(List<Object[]>) ht.find(hql);
		return list;
	}
}
