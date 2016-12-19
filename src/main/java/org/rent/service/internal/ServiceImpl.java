package org.rent.service.internal;

import org.rent.service.Services;
import org.rent.service.internal.doa.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceImpl<T> implements Services<T> {

	@Autowired
	Dao<T> dao;
	
	
	@Override
	public Boolean remove(Integer id,Class<T> entityClass) {
		return dao.remove(id, entityClass);
	}

	
	@Override
	public T getSingleById(Integer id,Class<T> entityClass) {
		return dao.findSingleById(id, entityClass);
	}

	@Override
	public T update(T object) {
		return dao.update(object);
	}

	@Override
	public T save(T object) {
		return dao.save(object);
	}

}
