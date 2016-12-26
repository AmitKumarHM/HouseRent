package org.rent.service.internal.doa.internal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.rent.model.Advertisement;
import org.rent.service.internal.doa.AdvertisementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdvertisementDaoImpl implements AdvertisementDao {

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
	public Boolean remove(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advertisement> findByUserId(Integer userId) {
		Query userListQuery = entityManager.createNamedQuery(Advertisement.GET_ADVERTISEMENT_BY_ID);
		@SuppressWarnings("unchecked")
		List<Advertisement> objAdverList =(List<Advertisement>)userListQuery.getResultList();
		return objAdverList;
	}

	@Override
	public Advertisement findById(Integer id) {
			return entityManager.find(Advertisement.class, id);
	}

	@Override
	public Advertisement update(Advertisement advertisement) {
		 EntityManager entityManager=entityManagerFactory.createEntityManager();
		 EntityTransaction transcation=entityManager.getTransaction();
		 transcation.begin();
		 Advertisement perAt=entityManager.merge(advertisement);
		 transcation.commit();
		 entityManager.close();
		 return perAt;
	}

	@Override
	public Integer save(Advertisement advertisement) {
		 EntityManager entityManager=entityManagerFactory.createEntityManager();
		 EntityTransaction transcation=entityManager.getTransaction();
		 transcation.begin();
		 entityManager.persist(advertisement);
		 transcation.commit();
		 Integer id =(Integer)advertisement.getAdvertisementId();
		 entityManager.close();
		 return id;
	}

	@Override
	public List<Advertisement> find() {
		 CriteriaQuery<Advertisement> criteria =entityManager.getCriteriaBuilder().createQuery(Advertisement.class);
		 criteria.select(criteria.from(Advertisement.class));
		 return entityManager.createQuery(criteria).getResultList();
	}

}
