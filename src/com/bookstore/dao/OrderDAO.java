package com.bookstore.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Customer;

@Repository
@Transactional
public class OrderDAO extends JpaDAO<BookOrder> implements GenericDAO<BookOrder> {
	public OrderDAO() {
		super();
	}

	@Override
	public BookOrder create(BookOrder c) {
		return super.create(c);
	}

	@Override
	public BookOrder update(BookOrder t) {
		// TODO Auto-generated method stub
		return super.update(t);
	}

	@Override
	public void delete(Class<BookOrder> type, Object i) {
		// TODO Auto-generated method stub
		super.delete(type, i);
	}

	@Override
	public BookOrder find(Class<BookOrder> type, Object id) {
		// TODO Auto-generated method stub
		return super.find(type, id);
	}

	@Override
	public List<BookOrder> listAll() {
		// TODO Auto-generated method stub
		return super.listAll();
	}

}
