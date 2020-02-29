package com.biss.service;

import java.util.List;

import com.biss.model.Part;

public interface IPartService {
	Integer savePart(Part ob);
	List<Part> getAllPart();
	void deletePart(Integer id);
	
	Part getOnePart(Integer id);
	void updatePart(Part sp);
}
