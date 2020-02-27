package com.biss.service;

import java.util.List;

import com.biss.model.Document;

public interface IDocumentService {
	Integer saveDocument(Document doc);

	List<Object[]> getFileIdAndName();

	Document getOneDocument(Integer id);
}
