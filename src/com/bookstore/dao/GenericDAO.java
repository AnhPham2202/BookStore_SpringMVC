package com.bookstore.dao;

import java.util.List;


public interface GenericDAO<T>{
	public T create(T t);
	public T update(T t);
	public T get(Object i);
	public void delete(Class<T> type, Object i);
	public List<T> listAll();
	public long count();
}
