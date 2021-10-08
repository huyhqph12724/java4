package DAO;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import JPAConfig.Jpa;
import Model.User;

public abstract class AbstractDAO<T> {
	private  Class<T> entityClass;
	public AbstractDAO(Class<T> cls) {
		this.entityClass = cls;
	}
	
	
	public void insert(T entity) {
		EntityManager em = Jpa.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(entity);
			trans.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
		}		
		em.close();	
	}
	public void update(T entity) {
		EntityManager em = Jpa.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(entity);
			trans.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
		}
		em.close();
	}
	public void delete(Object id) {
		EntityManager em = Jpa.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			T entity = em.find(entityClass, id);
			em.remove(entity);
			trans.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
		}
		em.close();
	}
	public T findById(Object id) {
		EntityManager em = Jpa.getEntityManager();
		EntityTransaction trans = em.getTransaction();
			trans.begin();
			T entity = em.find(entityClass, id);
			return entity;
	}
	@SuppressWarnings("unchecked")
	public List<T> fillAll(){
		@SuppressWarnings("rawtypes")
		EntityManager em = Jpa.getEntityManager();
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return em.createQuery(cq).getResultList();
	}
	@SuppressWarnings("unchecked")
	public Long count(){
		@SuppressWarnings("rawtypes")
		EntityManager em = Jpa.getEntityManager();
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		Root<T> rt = cq.from(entityClass);
		cq.select(em.getCriteriaBuilder().count(rt));
		javax.persistence.Query q =  em.createQuery(cq);
		return (Long) q.getSingleResult();
	}
}
