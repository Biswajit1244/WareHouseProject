	package com.biss.dao.impl;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.orm.hibernate5.HibernateTemplate;
	import org.springframework.stereotype.Repository;

	import com.biss.dao.IOrderMethodDao;
	import com.biss.model.OrderMethod;
	@Repository
	public class OrderMethodDaoImpl implements IOrderMethodDao {

		@Autowired
		private HibernateTemplate ht;
		@Override
		public Integer saveOrderMethod(OrderMethod ob) {
			return (Integer) ht.save(ob);
		}
		@Override
		public List<OrderMethod> getAllOrderMethod() {
			return ht.loadAll(OrderMethod.class);
		}
		@Override
		public void deleteOrderMethod(Integer id) {
			ht.delete(new OrderMethod(id));
		}
		@Override
		public OrderMethod getOneOrderMethod(Integer id) {
			return ht.get(OrderMethod.class, id);
		}
		@Override
		public void updateOrderMethod(OrderMethod sp) {
			ht.update(sp);
		}
		
	 @SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getOrderTypeCount() {
		String hql="select orderType,count(orderType) from com.biss.model.OrderMethod group by orderType";
		return (List<Object[]>) ht.find(hql);
	}
}
