package com.biss.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.biss.dao.IDocumentDao;
import com.biss.model.Document;

@Repository
public class DocumentDaoImpl implements IDocumentDao{
	@Autowired
	HibernateTemplate ht;

	@Override
	public Integer saveDocument(Document doc) {
		return (Integer) ht.save(doc);
	}
	@Override
	public List<Object[]> getFileIdAndName() {
		String hql="select fileId,fileName from com.biss.model.Document";
		return (List<Object[]>) ht.find(hql);
	}@Override
	public Document getOneDocument(Integer id) {
		return ht.get(Document.class,id);
	}
}
