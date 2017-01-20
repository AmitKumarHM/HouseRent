package org.rent.service.internal.doa.internal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.rent.service.internal.doa.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoImpl<T> implements Dao<T> {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public Boolean remove(Integer id,Class<T> entityClass) {
		 EntityManager entityManager=entityManagerFactory.createEntityManager();
		 EntityTransaction transcation=entityManager.getTransaction();
		 Object entity=entityManager.find(entityClass, id);
		 transcation.begin();
		 entityManager.remove(entity);
		 transcation.commit();
		 entityManager.close();
		 return (entity!=null)?true:false;
	}

	@Override
	public T findSingleById(Integer id,Class<T> entityClass) {
		return entityManager.find(entityClass, id);
	}

	@Override
	public T update(T object) {
		 EntityManager entityManager=entityManagerFactory.createEntityManager();
		 EntityTransaction transcation=entityManager.getTransaction();
		 transcation.begin();
		 T perObj=entityManager.merge(object);
		 transcation.commit();
		 entityManager.close();
		 return perObj;
	}

	@Override
	public T save(T object) {
		 EntityManager entityManager=entityManagerFactory.createEntityManager();
		 EntityTransaction transcation=entityManager.getTransaction();
		 transcation.begin();
		 entityManager.merge(object);
		 transcation.commit();
		 entityManager.close();
		 return object;
	}

}
