package com.biss.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.biss.dao.IGRNDao;
import com.biss.model.GRN;
import com.biss.model.GrnDtls;

@Repository
public class GRNDaoImpl implements IGRNDao {
	@Autowired
	HibernateTemplate ht;
	
	@Override
	public Integer saveGRN(GRN ob) {
		return (Integer) ht.save(ob);
	}
	@Override
	public List<GRN> getAllGRN() {
		return ht.loadAll(GRN.class);
	}
	@Override
	public void deleteGRN(Integer id) {
		ht.delete(new GRN(id));
	}
	@Override
	public GRN getOneGRN(Integer id) {
		return ht.get(GRN.class, id);
	}
	@Override
	public void updateGRN(GRN sp) {
		ht.update(sp);
	}
	@Override
	public Integer saveGrnDtl(GrnDtls grnDtl) {
		return (Integer) ht.save(grnDtl);
	}
	
	@Override
	public List<GrnDtls> getGrnDtlByGrnId(Integer gId) {
		return ht.execute(new HibernateCallback<List<GrnDtls>>() {
			@Override
			public List<GrnDtls> doInHibernate(Session ses) 
					throws HibernateException {
				String hql=" select dtl "
						+ " from in.nit.model.GrnDtls dtl "
						+ " join dtl.grn as grn"
						+" where grn.grnId=:gId ";
				@SuppressWarnings("unchecked")
				List<GrnDtls> dtls=ses.createQuery(hql) 
				.setParameter("gId", gId)
				.list();
				return dtls;
			}
		});
	}
	
	@Override
	public void updateGrnDtlPartStatus(Integer grnDtl,String status) {
		ht.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) 
					throws HibernateException {
				String hql=" update in.nit.model.GrnDtls dtl "
						+ "  set dtl.partStatus=:status "
						+ "  where dtl.id=:grnDtl ";
				
				int count=
						session.createQuery(hql)
				.setParameter("status", status)
				.setParameter("grnDtl", grnDtl)
				.executeUpdate();
				
				return count;
			}
		});
	}
}
