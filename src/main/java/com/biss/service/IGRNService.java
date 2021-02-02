package com.biss.service;

import java.util.List;

import com.biss.model.GRN;
import com.biss.model.GrnDtls;

public interface IGRNService {
	Integer saveGRN(GRN ob);
	List<GRN> getAllGRN();
	void deleteGRN(Integer id);

	GRN getOneGRN(Integer id);
	void updateGRN(GRN sp);

	//---childs screen#2--------
	Integer saveGrnDtl(GrnDtls grnDtl);
	List<GrnDtls> getGrnDtlByGrnId(Integer grnId);
	void updateGrnDtlPartStatus(Integer grnDtl,String status);
}
