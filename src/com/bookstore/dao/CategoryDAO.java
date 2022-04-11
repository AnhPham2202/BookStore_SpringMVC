package com.bookstore.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.entity.Category;

@Transactional
@Repository
public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category> {
	public CategoryDAO() {
		super();
	}

	@Override
	public Category create(Category t) {
		return super.create(t);
	}

	@Override
	public Category update(Category t) {
		return super.update(t);
	}

	@Override
	public Category get(Object i) {
		return super.get(i);
	}

	@Override
	public void delete(Class<Category> type, Object i) {
		super.delete(type, i);
	}

	@Override
	public Category find(Class<Category> type, Object id) {
		return super.find(type, id);
	}

	@Override
	public long countWithNamedQuery(String nameQuery) {
		return super.countWithNamedQuery(nameQuery);
	}

	@Override
	public List<Category> listAllWithNamedQuery(String nameQuery) {
		return super.listAllWithNamedQuery(nameQuery);
	}
	
	@Override
	public Category findByField(String nameQuery, String paramsKey, String paramsValue) {
		
		return super.findByField(nameQuery, paramsKey, paramsValue);
	}
	
	
}
