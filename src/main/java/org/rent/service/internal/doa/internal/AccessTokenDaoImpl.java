package org.rent.service.internal.doa.internal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.rent.model.AccessToken;
import org.rent.service.internal.doa.AccessTokenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccessTokenDaoImpl implements AccessTokenDao{

	
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
	public AccessToken validToken(AccessToken accessToken) {
		Query userList = entityManager.createNamedQuery(AccessToken.GET_ACCESSTOKEN_BY_ID_ACCESSTOKEN);
		userList.setParameter("accessToken", accessToken.getAccessToken());
		userList.setParameter("userId", accessToken.getUser().getUserId());
		AccessToken persistedAccessToken=(AccessToken)userList.getSingleResult();
		entityManager.refresh(persistedAccessToken);
		return persistedAccessToken;
	}

	@Override
	public AccessToken findById(Integer id) {
		Query userList = entityManager.createNamedQuery(AccessToken.GET_ACCESSTOKEN_BY_ID);
		userList.setParameter("userId", id);
		AccessToken persistedAccessToken=(AccessToken)userList.getSingleResult();
		entityManager.refresh(persistedAccessToken);
		return persistedAccessToken;
	}

	@Override
	public AccessToken update(AccessToken accessToken) {
		 EntityManager entityManager=entityManagerFactory.createEntityManager();
		 EntityTransaction transcation=entityManager.getTransaction();
		 transcation.begin();
		 AccessToken perAt=entityManager.merge(accessToken);
		 transcation.commit();
		 entityManager.close();
		 return perAt;
	}

	@Override
	public Integer save(AccessToken accessToken) {
		 EntityManager entityManager=entityManagerFactory.createEntityManager();
		 EntityTransaction transcation=entityManager.getTransaction();
		 transcation.begin();
		 entityManager.persist(accessToken);
		 transcation.commit();
		 Integer id =(Integer)accessToken.getAccessTokenId();
		 entityManager.close();
		 return id;
	}

}
