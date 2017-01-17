package org.rent.service.internal.doa;

public interface Dao<T> {

	Boolean remove(Integer id,Class<T> entityClass);
	T findSingleById(Integer id,Class<T> entityClass);
	T update(T object);
	T save(T object);
}
