package com.biss.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biss.dao.IWhUserTypeDao;
import com.biss.model.WhUserType;
import com.biss.service.IWhUserTypeService;
@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {
	@Autowired
	private IWhUserTypeDao dao;
	
	@Transactional
	public Integer saveWhUser(WhUserType ob) {
		return dao.saveWhUser(ob);
	}

	@Transactional(readOnly = true)
	public List<WhUserType> getAllWhUser() {
		List<WhUserType> list=dao.getAllWhUser();
		Collections.sort(list, (o1,o2)->o1.getUserId()-o2.getUserId());
		return list;
	}

	@Transactional
	public void deleteWhUser(Integer id) {
		dao.deleteWhUser(id);
	}

}
