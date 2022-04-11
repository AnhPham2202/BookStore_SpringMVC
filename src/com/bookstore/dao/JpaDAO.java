package com.bookstore.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.SqlResultSetMapping;

import org.springframework.stereotype.Repository;

@Repository
public class JpaDAO<T> implements GenericDAO<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	public JpaDAO() {
	}

	@Override
	public T create(T t) {
		entityManager.persist(t);
		return t;
	}

	@Override
	public T update(T t) {
		entityManager.merge(t);
		return t;
	}

	@Override
	public T get(Object i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Class<T> type, Object i) {
		T t = entityManager.find(type, i);
		entityManager.remove(t);

	}

	public T find(Class<T> type, Object id) {
		T entity = entityManager.find(type, id);
//		if (entity != null) {
//			entityManager.refresh(entity);
//		}
		return entity;
	}

	@Override
	public List<T> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public long countWithNamedQuery(String nameQuery) {
		Query query = entityManager.createNamedQuery(nameQuery);
		return (long) query.getSingleResult();
	}

	public List<T> listAllWithNamedQuery(String nameQuery) {
		Query query = entityManager.createNamedQuery(nameQuery);
		return (List<T>) query.getResultList();
	}

	public List<T> findyByEmailWithNameQuery(String nameQuery, String paramsKey, String paramsValue) {
		Query qr = entityManager.createNamedQuery(nameQuery);

		qr.setParameter(paramsKey, paramsValue);
		return qr.getResultList();
	}

	public T queryWithManyParams(String namedQuery, Map<String, Object> paramsList) {
		Query qr = entityManager.createNamedQuery(namedQuery);

		for (Entry<String, Object> entry : paramsList.entrySet()) {
			qr.setParameter(entry.getKey(), entry.getValue());
		}

		try {
			return (T) qr.getSingleResult();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public List<T> queryWithManyParamsListResult(String namedQuery, Map<String, Object> paramsList) {
		Query qr = entityManager.createNamedQuery(namedQuery);

		for (Entry<String, Object> entry : paramsList.entrySet()) {
			qr.setParameter(entry.getKey(), entry.getValue());
		}

		try {
			return (List<T>) qr.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public T findByField(String nameQuery, String paramsKey, String paramsValue) {
		Query qr = entityManager.createNamedQuery(nameQuery);
		qr.setParameter(paramsKey, paramsValue);

		try {
			return (T) qr.getSingleResult();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	
	public List<T> querySingleParamsWithLimitedRecord(String namedQuery, String paramsKey, String paramsValue, int numberOfRecords) {
		Query qr = entityManager.createNamedQuery(namedQuery).setMaxResults(numberOfRecords);
		
		if (paramsKey != null && paramsValue != null) {			
			qr.setParameter(paramsKey, paramsValue);
		}

		try {
			return (List<T>) qr.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public List<T> nativeQuery() {
		Query qr = entityManager.createNativeQuery(
				"SELECT *, (SUM(bookstoredb.review.rating) / count(bookstoredb.review.review_id)) as rate "
				+ "FROM bookstoredb.book  "
				+ "LEFT JOIN bookstoredb.review "
				+ "ON bookstoredb.book.book_id = bookstoredb.review.book_id "
				+ "group by bookstoredb.book.book_id "
				+ "order by rate;", "sth");
		
		 
		try {
			return (List<T>) qr.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
		
	}

}
