package com.biss.dao;

import java.util.List;

import com.biss.model.Part;

public interface IPartDao {
	Integer savePart(Part ob);
	List<Part> getAllPart();
	void deletePart(Integer id);
	
	Part getOnePart(Integer id);
	void updatePart(Part sp);
	
	List<Object[]> getPartIdAndCode();
}
