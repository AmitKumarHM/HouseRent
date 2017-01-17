package org.rent.service;

public interface Services<T> {

	Boolean remove(Integer id,Class<T> entityClass);
	T getSingleById(Integer id,Class<T> entityClass);
	T update(T object);
	T save(T object);
	
}
