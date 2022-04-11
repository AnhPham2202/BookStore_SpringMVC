package com.bookstore.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.entity.OrderDetail;

@Repository
@Transactional
public class OrderDetailDAO extends JpaDAO<OrderDetail> implements GenericDAO<OrderDetail> {

	@Override
	public OrderDetail create(OrderDetail t) {
		return super.create(t);
	}

	@Override
	public OrderDetail update(OrderDetail t) {
		return super.update(t);
	}

	@Override
	public void delete(Class<OrderDetail> type, Object i) {
		super.delete(type, i);
	}

	@Override
	public OrderDetail find(Class<OrderDetail> type, Object id) {
		return super.find(type, id);
	}

	@Override
	public List<OrderDetail> listAll() {
		return super.listAll();
	}

	@Override
	public List<OrderDetail> queryWithManyParamsListResult(String namedQuery, Map<String, Object> paramsList) {
		return super.queryWithManyParamsListResult(namedQuery, paramsList);
	}
	
	
	

}
