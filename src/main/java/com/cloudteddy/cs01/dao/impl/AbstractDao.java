package com.cloudteddy.cs01.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kimtung on 01/02/16.
 */
public abstract class AbstractDao implements com.cloudteddy.cs01.dao.AbstractDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
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
}
