package com.biss.dao;

import java.util.List;

import com.biss.model.GRN;

public interface IGRNDao {
	Integer saveGRN(GRN ob);
	List<GRN> getAllGRN();
	void deleteGRN(Integer id);
	
	GRN getOneGRN(Integer id);
	void updateGRN(GRN sp);
}
