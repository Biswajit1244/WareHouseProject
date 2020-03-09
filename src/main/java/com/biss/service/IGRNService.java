package com.biss.service;

import java.util.List;

import com.biss.model.GRN;

public interface IGRNService {
	Integer saveGRN(GRN ob);
	List<GRN> getAllGRN();
	void deleteGRN(Integer id);
	
	GRN getOneGRN(Integer id);
	void updateGRN(GRN sp);
}
