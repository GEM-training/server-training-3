package com.cloudteddy.cs01.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by kimtung on 01/02/16.
 */
public abstract class AbstractDao<T> implements com.cloudteddy.cs01.dao.AbstractDao<T> {

    @Autowired
    private SessionFactory sessionFactory;
    private Class dataClass;

    public AbstractDao(Class dataClass) {
        this.dataClass = dataClass;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Long count() {
        Criteria criteria = getSession().createCriteria(dataClass);
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }

    @Override
    public T loadById(Serializable id) {
        return (T) getSession().load(dataClass, id);
    }

    @Override
    public T getById(Serializable id) {
        return (T) getSession().get(dataClass, id);
    }

    @Override
    public void persit(Object object) {
        getSession().persist(object);
    }

    @Override
    public void update(Object object) {
        getSession().update(object);
    }

    @Override
    public void delete(Object object) {
        getSession().delete(object);
    }

    @Override
    public void deleteById(Serializable id) {
        Object o = this.loadById(id);
        getSession().delete(o);
    }

    @Override
    public void refresh(Object o) {
        getSession().refresh(o);
    }
}
