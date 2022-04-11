package com.bookstore.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.entity.Book;

@Repository
@Transactional
public class BookDAO extends JpaDAO<Book> implements GenericDAO<Book> {
		
	public BookDAO() {
		super();
	}
	
	@Override
	public Book create(Book t) {
		return super.create(t);
	}

	@Override
	public Book update(Book t) {
		return super.update(t);
	}

	@Override
	public Book get(Object i) {
		return super.get(i);
	}

	@Override
	public void delete(Class<Book> type, Object i) {
		super.delete(type, i);
	}

	@Override
	public Book find(Class<Book> type, Object id) {
		return super.find(type, id);
	}

	@Override
	public List<Book> listAll() {
		return super.listAll();
	}

	@Override
	public long count() {
		return super.count();
	}

	@Override
	public Book queryWithManyParams(String namedQuery, Map<String, Object> paramsList) {
		return super.queryWithManyParams(namedQuery, paramsList);
	}
	
	@Override
	public List<Book> queryWithManyParamsListResult(String namedQuery, Map<String, Object> paramsList) {
		return super.queryWithManyParamsListResult(namedQuery, paramsList);
	}
	
	@Override
	public List<Book> querySingleParamsWithLimitedRecord(String namedQuery, String paramsKey, String paramsValue,
			int numberOfRecords) {
		return super.querySingleParamsWithLimitedRecord(namedQuery, paramsKey, paramsValue, numberOfRecords);
	}
}
