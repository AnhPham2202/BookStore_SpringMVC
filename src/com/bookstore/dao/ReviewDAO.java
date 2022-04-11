package com.bookstore.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.entity.Review;
import com.bookstore.service.ReviewService;

@Repository
@Transactional
public class ReviewDAO extends JpaDAO<Review> implements GenericDAO<Review> {

	@Override
	public Review create(Review t) {
		// TODO Auto-generated method stub
		return super.create(t);
	}

	@Override
	public Review update(Review t) {
		// TODO Auto-generated method stub
		return super.update(t);
	}

	@Override
	public void delete(Class<Review> type, Object i) {
		// TODO Auto-generated method stub
		super.delete(type, i);
	}

	@Override
	public Review find(Class<Review> type, Object id) {
		// TODO Auto-generated method stub
		return super.find(type, id);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return super.count();
	}

	@Override
	public long countWithNamedQuery(String nameQuery) {
		// TODO Auto-generated method stub
		return super.countWithNamedQuery(nameQuery);
	}

	@Override
	public List<Review> listAllWithNamedQuery(String nameQuery) {
		// TODO Auto-generated method stub
		return super.listAllWithNamedQuery(nameQuery);
	}

	@Override
	public Review queryWithManyParams(String namedQuery, Map<String, Object> paramsList) {
		// TODO Auto-generated method stub
		return super.queryWithManyParams(namedQuery, paramsList);
	}

	@Override
	public List<Review> queryWithManyParamsListResult(String namedQuery, Map<String, Object> paramsList) {
		// TODO Auto-generated method stub
		return super.queryWithManyParamsListResult(namedQuery, paramsList);
	}

	@Override
	public List<Review> findyByEmailWithNameQuery(String nameQuery, String paramsKey, String paramsValue) {
		// TODO Auto-generated method stub
		return super.findyByEmailWithNameQuery(nameQuery, paramsKey, paramsValue);
	}

}
