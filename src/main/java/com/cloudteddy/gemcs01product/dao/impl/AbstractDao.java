package com.cloudteddy.gemcs01product.dao.impl;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by kimtung on 1/27/16.
 */
public abstract class AbstractDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        return session;
    }

    public void persist(Object entity) {
        getSession().persist(entity);
    }

    public void save(Object entity) {
        getSession().save(entity);
    }

    public void delete(Object entity) {
        getSession().delete(entity);
    }

    public void refresh(Object object) {
        getSession().refresh(object);
    }
}
