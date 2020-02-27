package com.biss.dao;

import java.util.List;

import com.biss.model.Document;

public interface IDocumentDao {
	Integer saveDocument(Document doc);
	List<Object[]> getFileIdAndName();
	
	Document getOneDocument(Integer id);
}
