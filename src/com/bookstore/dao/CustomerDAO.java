package com.bookstore.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.entity.Category;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Users;
import com.bookstore.utils.SecurityUtils;

@Repository
@Transactional
public class CustomerDAO extends JpaDAO<Customer> implements GenericDAO<Customer>  {
	
	@Autowired
	SecurityUtils secUtils;
	
	public CustomerDAO() {
		super();
	}

	@Override
	public Customer create(Customer c) {
		return super.create(c);
	}

	@Override
	public Customer update(Customer c) {
		return super.update(c);
	}

	@Override
	public Customer get(Object c) {
		return super.get(c);
	}

	@Override
	public void delete(Class<Customer> type, Object i) {
		super.delete(type, i);
	}

	@Override
	public Customer find(Class<Customer> type, Object id) {
		return super.find(type, id);
	}

	@Override
	public List<Customer> listAll() {
		return super.listAll();
	}

	@Override
	public long countWithNamedQuery(String nameQuery) {
		return super.countWithNamedQuery(nameQuery);
	}

	@Override
	public List<Customer> findyByEmailWithNameQuery(String nameQuery, String paramsKey, String paramsValue) {
		return super.findyByEmailWithNameQuery(nameQuery, paramsKey, paramsValue);
	}

	@Override
	public Customer queryWithManyParams(String namedQuery, Map<String, Object> paramsList) {
		return super.queryWithManyParams(namedQuery, paramsList);
	}

	@Override
	public List<Customer> queryWithManyParamsListResult(String namedQuery, Map<String, Object> paramsList) {
		return super.queryWithManyParamsListResult(namedQuery, paramsList);
	}
	
	public Customer checkLogIn (String email, String password) {
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("email", email);
		
		Customer customer = super.queryWithManyParams("findCustomerByEmail", params);
		boolean correctPass = secUtils.checkMatch(password, customer.getPassword());
		
		if (customer != null && correctPass) {
			return customer;
		}
		return null;
	}	
}
