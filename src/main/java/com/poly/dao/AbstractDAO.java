package com.poly.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import com.poly.entity.Video;
import com.poly.util.JpaUtil;

public class AbstractDAO<T> {

	public static final EntityManager entityManger = JpaUtil.getEntityManager();

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		entityManger.close();
		super.finalize();
	}

	public T findById(Class<T> clazz, Integer id) {
		return entityManger.find(clazz, id);
	}

	public List<T> findAll(Class<T> clazz, boolean existIsActive) {
		String entityName = clazz.getSimpleName();
		StringBuilder jqpl = new StringBuilder();
		jqpl.append("SELECT o FROM ").append(entityName).append(" o");
		if (existIsActive == true) {
			jqpl.append(" WHERE o.isActive = 1");
		}

		TypedQuery<T> query = entityManger.createQuery(jqpl.toString(), clazz);
		return query.getResultList();
	}

	public List<T> findAll(Class<T> clazz, boolean existIsActive, boolean isNew, String column) {
		String entityName = clazz.getSimpleName();
		StringBuilder jqpl = new StringBuilder();
		jqpl.append("SELECT o FROM ").append(entityName).append(" o");
		if (existIsActive == true) {
			jqpl.append(" WHERE o.isActive = 1");
		}
		if (isNew == true) {
			jqpl.append("ORDER BY o." + column + " DESC");
		}

		TypedQuery<T> query = entityManger.createQuery(jqpl.toString(), clazz);
		return query.getResultList();
	}

	public List<T> findAll(Class<T> clazz, boolean existIsActive, boolean isNew, String column, boolean isRandom,
			String columnRandom, int numberRandom) {
		String entityName = clazz.getSimpleName();
		StringBuilder jqpl = new StringBuilder();
		jqpl.append("SELECT o FROM ").append(entityName).append(" o");
		if (existIsActive == true) {
			jqpl.append(" WHERE o.isActive = 1");
		}
		if (isNew == true) {
			jqpl.append("ORDER BY o." + column + " DESC");
		}

		TypedQuery<T> query = entityManger.createQuery(jqpl.toString(), clazz);
		return query.getResultList();
	}

	public List<T> findAll(Class<T> clazz, boolean existIsActive, int pageNumber, int pageSize) {
		String entityName = clazz.getSimpleName();
		StringBuilder jqpl = new StringBuilder();
		jqpl.append("SELECT o FROM ").append(entityName).append(" o");
		if (existIsActive == true) {
			jqpl.append(" WHERE isActive = 1 ");
		}
		TypedQuery<T> query = entityManger.createQuery(jqpl.toString(), clazz);
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	public List<T> findAll(Class<T> clazz, boolean existIsActive, int pageNumber, int pageSize, boolean isNew,
			String column) {
		String entityName = clazz.getSimpleName();
		StringBuilder jqpl = new StringBuilder();
		jqpl.append("SELECT o FROM ").append(entityName).append(" o");
		if (existIsActive == true) {
			jqpl.append(" WHERE isActive = 1 ");
		}
		if (isNew == true) {
			jqpl.append("ORDER BY o." + column + " DESC");
		}
		TypedQuery<T> query = entityManger.createQuery(jqpl.toString(), clazz);
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	public T findOne(Class<T> clazz, String jqpl, Object... params) {
		TypedQuery<T> query = entityManger.createQuery(jqpl, clazz);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List<T> result = query.getResultList();
		if (result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}

	public List<T> findMany(Class<T> clazz, String jqpl, Object... params) {
		TypedQuery<T> query = entityManger.createQuery(jqpl, clazz);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> findManyByNativeQuery(String sql, Object... params) {
		Query query = entityManger.createNativeQuery(sql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> callStore(String namedStored, Map<String, Object> params) {
		StoredProcedureQuery query = entityManger.createNamedStoredProcedureQuery(namedStored);
		params.forEach((key, value) -> query.setParameter(key, value));
		return (List<T>) query.getResultList();
	}

	public T create(T entity) {
		try {
			entityManger.getTransaction().begin();

			entityManger.persist(entity);
			entityManger.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			entityManger.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	public T update(T entity) {
		try {
			entityManger.getTransaction().begin();
			entityManger.merge(entity);
			entityManger.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			entityManger.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

	public T delete(T entity) {
		try {
			entityManger.getTransaction().begin();
			entityManger.remove(entity);
			entityManger.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			entityManger.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

}
