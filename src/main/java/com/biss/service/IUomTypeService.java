package com.biss.service;

import java.util.List;

import com.biss.model.UomType;

public interface IUomTypeService {
	Integer saveUomType(UomType ob);
	List<UomType> getAllUomType();
	void deleteUomType(Integer id);
	
	UomType getOneUomType(Integer id);
	void updateUomType(UomType sp);
}
