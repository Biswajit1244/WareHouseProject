package com.biss.dao;

import java.util.List;

import com.biss.model.UomType;
import com.biss.model.UomType;

public interface IUomTypeDao {
	Integer saveUomType(UomType ob);
	List<UomType> getAllUomType();
	void deleteUomType(Integer id);
	
	UomType getOneUomType(Integer id);
	void updateUomType(UomType sp);
}
