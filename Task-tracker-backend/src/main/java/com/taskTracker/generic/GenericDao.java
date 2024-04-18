package com.taskTracker.generic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public abstract class GenericDao<E> {

    private static final String PERSISTENCE_UNIT_NAME = "task_tracker";
    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	protected Class<E> entityClass ;
	
	public GenericDao() {
		setEntityClass();
	}
	
	public abstract void setEntityClass();

	public E create(E object) {
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction transaction = em.getTransaction();
	    E createdObject = null;

	    try {
	        transaction.begin();
	        em.persist(object);
	        transaction.commit();
	        createdObject = object;
	    } catch (Exception e) {
	        if (transaction.isActive()) transaction.rollback();
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }
	    
	    return createdObject;
	}

    public void update(E object) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(object);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void delete(E object) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.remove(em.merge(object));
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
    public List<E> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e");
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public E findById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(entityClass, id);
        } finally {
            em.close();
        }
    }

    public E findByCode(String code) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e WHERE e.code = :code");
            query.setParameter("code", code);
            return (E) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public List<E> findByColumn(String columnName, Object value) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e WHERE e." + columnName + " = :value");
            query.setParameter("value", value);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
