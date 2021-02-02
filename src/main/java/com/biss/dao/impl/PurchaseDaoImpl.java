package com.biss.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.biss.dao.IPurchaseDao;
import com.biss.model.Purchase;
import com.biss.model.PurchaseDtls;
@Repository
public class PurchaseDaoImpl implements IPurchaseDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer savePurchase(Purchase ob) {
		return (Integer) ht.save(ob);
	}
	@Override
	public List<Purchase> getAllPurchase() {
		return ht.loadAll(Purchase.class);
	}
	@Override
	public void deletePurchase(Integer id) {
		ht.delete(new Purchase(id));
	}
	@Override
	public Purchase getOnePurchase(Integer id) {
		return ht.get(Purchase.class, id);
	}
	@Override
	public void updatePurchase(Purchase sp) {
		ht.update(sp);
	}
	@Override
	public Integer savePurchaseDtls(PurchaseDtls dtls) {
		return (Integer) ht.save(dtls);
	}
	@Override
	public void deletePurchaseDtls(Integer id) {
		PurchaseDtls pd=new PurchaseDtls();
		pd.setPurDtlsId(id);
		ht.delete(pd);
	}
	@Override
	public void updatePurchaseStatus(Integer id,String status) {
		ht.execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session ses) throws HibernateException {
				String hql=" update com.biss.model.Purchase "+
							" set purDfltSts=:a where purId=:b ";
				int count=ses.createQuery(hql)
						.setParameter("a",status)
						.setParameter("b", id)
						.executeUpdate();
				return count;
			}
		});
	}
	@Override
	public List<Object[]> getPurIdAndCode() {
		return ht.execute(new HibernateCallback<List<Object[]>>() {

			@Override
			public List<Object[]> doInHibernate(Session session) throws HibernateException {
				CriteriaBuilder builder=session.getCriteriaBuilder();
				//Specify output type
				CriteriaQuery<Object[]> query=builder.createQuery(Object[].class);
				//Specify Root class
				Root<Purchase> root=query.from(Purchase.class);
				//specify select clause
				query.multiselect(root.get("purId"),root.get("purCode"));
				//specify where condition
				query.where(builder.equal(root.get("purDfltSts"),"INVOICED"));
				
				//execute the query
				Query<Object[]> q=session.createQuery(query);
				List<Object[]> list=q.list();
				
				return list;
			}
		});
	}
}
