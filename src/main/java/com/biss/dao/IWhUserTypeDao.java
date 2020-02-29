package com.biss.dao;

import java.util.List;

import com.biss.model.WhUserType;

public interface IWhUserTypeDao {
	Integer saveWhUser(WhUserType ob);
	List<WhUserType> getAllWhUser();
	void deleteWhUser(Integer id);
	
	WhUserType getOneWhUserType(Integer id);
	void updateWhUserType(WhUserType sp);
	
	List<Object[]> getWhuserIdCount();
 }
