package com.biss.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biss.dao.IGRNDao;
import com.biss.model.GRN;
import com.biss.model.GrnDtls;
import com.biss.service.IGRNService;
@Service
public class GRNServiceImpl implements IGRNService {

	@Autowired
	private IGRNDao dao;
	
	@Transactional
	public Integer saveGRN(GRN ob) {
		return dao.saveGRN(ob);
	}
	@Transactional(readOnly = true)
	public List<GRN> getAllGRN() {
		List<GRN> list=dao.getAllGRN();
		Collections.sort(list, (o1,o2)-> o1.getGrnId()-o2.getGrnId());
		return list;
	}
	@Transactional
	public void deleteGRN(Integer id) {
		dao.deleteGRN(id);
	}
	@Transactional(readOnly = true)
	public GRN getOneGRN(Integer id) {
		return dao.getOneGRN(id);
	}
	
	@Transactional
	public void updateGRN(GRN sp) {
		dao.updateGRN(sp);
	}
	@Override
	@Transactional
	public Integer saveGrnDtl(GrnDtls grnDtl) {
		return dao.saveGrnDtl(grnDtl);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<GrnDtls> getGrnDtlByGrnId(Integer grnId) {
		return dao.getGrnDtlByGrnId(grnId);
	}
	
	@Override
	@Transactional
	public void updateGrnDtlPartStatus(Integer grnDtl, String status) {
		dao.updateGrnDtlPartStatus(grnDtl, status);
	}

}
