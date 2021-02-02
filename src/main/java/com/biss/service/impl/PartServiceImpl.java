package com.biss.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biss.dao.IPartDao;
import com.biss.model.Part;
import com.biss.service.IPartService;
@Service
public class PartServiceImpl implements IPartService {
	@Autowired
	private IPartDao dao;
	
	@Transactional
	public Integer savePart(Part ob) {
		return dao.savePart(ob);
	}
	@Transactional(readOnly = true)
	public List<Part> getAllPart() {
		List<Part> list=dao.getAllPart();
		Collections.sort(list, (o1,o2)-> o1.getPartId()-o2.getPartId());
		return list;
	}
	@Transactional
	public void deletePart(Integer id) {
		dao.deletePart(id);
	}
	@Transactional(readOnly = true)
	public Part getOnePart(Integer id) {
		return dao.getOnePart(id);
	}
	
	@Transactional
	public void updatePart(Part sp) {
		dao.updatePart(sp);
	}
	@Override
	@Transactional(readOnly = true)
	public List<Object[]> getPartIdAndCode() {
		return dao.getPartIdAndCode();
	}
}
