package com.bookstore.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookstore.entity.Users;
import com.bookstore.utils.SecurityUtils;

@Transactional
@Repository
public class UserDao extends JpaDAO<Users> implements GenericDAO<Users> {
	
	@Autowired
	SecurityUtils secUtils;
	public UserDao() {
		super();
	}

	@Override
	public Users create(Users t) {
		return super.create(t);

	}
	
	@Override
	public Users find(Class<Users> type, Object id) {
		return super.find(type, id);
	}

	@Override
	public Users update(Users t) {
		// TODO Auto-generated method stub
		return super.update(t);
	}

	@Override
	public Users get(Object i) {
		// TODO Auto-generated method stub
		return super.get(i);
	}

	@Override
	public void delete(Class<Users> type, Object i) {
		// TODO Auto-generated method stub
		super.delete(type, i);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Users> listAll() {
		return super.listAllWithNamedQuery("findAllUsers");
	}

	public long countUsers() {
		return super.countWithNamedQuery("countUsers");
	}

	public Users findUserByEmail(String email) {
		 List<Users> listUsers =  super.findyByEmailWithNameQuery("findByEmail", "email", email);
		 if(listUsers != null && listUsers.size() == 1) {
			 return listUsers.get(0);
		 }
		 return null;
	}
	
	public boolean checkLogIn (String email, String password) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", email);
		
		Users user = super.queryWithManyParams("findByEmail", params);
		boolean correctPass = secUtils.checkMatch(password, user.getPassword());

		if (user != null && correctPass) {
			return true;
		}
		return false;
	}


}
