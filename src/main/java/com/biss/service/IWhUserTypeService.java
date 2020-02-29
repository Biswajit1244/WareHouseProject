package com.biss.service;

import java.util.List;

import com.biss.model.WhUserType;

public interface IWhUserTypeService {
	Integer saveWhUser(WhUserType ob);
	List<WhUserType> getAllWhUser();
	void deleteWhUser(Integer id);
	
	WhUserType getOneWhUserType(Integer id);
	void updateWhUserType(WhUserType sp);
	
	List<Object[]> getWhuserIdCount();
}
