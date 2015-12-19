package com.persistence;

import com.core.dao.BaseDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
public abstract class BaseDAOImpl<T> implements BaseDAO<T> {
    @Autowired
    protected SessionFactory sessionFactory;

    protected Class<T> entityClass;

    public BaseDAOImpl() {
        Class<T> tempClass;
        try {
            tempClass = getClassType();
        } catch (Exception e){
            tempClass = null;
        }
        this.entityClass = tempClass;
    }

    @SuppressWarnings("unchecked")
    private Class<T> getClassType() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void create(T entity) {
        getSession().persist(entity);
    }

    @Override
    public T read(String login) {
        return getSession().get(entityClass, login);
    }

    @Override
    public void update(T entity) {
        getSession().update(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll() {
        return getSession().createCriteria(entityClass).list();
    }
}
