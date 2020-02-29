package com.biss.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biss.dao.IUomTypeDao;
import com.biss.model.UomType;
import com.biss.service.IUomTypeService;
@Service
public class UomTypeServiceImpl implements IUomTypeService {
	@Autowired
	private IUomTypeDao dao;
	
	@Transactional
	public Integer saveUomType(UomType ob) {
		return dao.saveUomType(ob);
	}

	@Transactional(readOnly = true)
	public List<UomType> getAllUomType() {
		List<UomType> list=dao.getAllUomType();
		Collections.sort(list,(o1,o2)-> o1.getUomId()-o2.getUomId());
		return list;
	}

	@Transactional
	public void deleteUomType(Integer id) {
		dao.deleteUomType(id);
	}
	@Transactional(readOnly = true)
	public UomType getOneUomType(Integer id) {
		return dao.getOneUomType(id);
	}
	@Transactional
	public void updateUomType(UomType sp) {
		dao.updateUomType(sp);
	}
	
	@Transactional(readOnly = true)
	public List<Object[]> getUomTypeConunt() {
		return dao.getUomTypeConunt();
	}
}
