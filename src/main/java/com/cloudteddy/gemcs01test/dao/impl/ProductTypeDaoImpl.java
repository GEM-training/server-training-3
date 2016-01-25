package com.cloudteddy.gemcs01test.dao.impl;

import com.cloudteddy.gemcs01test.dao.AbstractDao;
import com.cloudteddy.gemcs01test.dao.BillDao;
import com.cloudteddy.gemcs01test.dao.ProductTypeDao;
import com.cloudteddy.gemcs01test.model.Bill;
import com.cloudteddy.gemcs01test.model.Product;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kimtung on 1/20/16.
 */
@Repository("productType")
@Transactional
public class ProductTypeDaoImpl extends AbstractDao implements ProductTypeDao {
    @Override
    public void save(Product.Type type) {
        persist(type);
    }

    @Override
    public void save(Product.Type[] types) {
        for(Product.Type type : types) {
            save(type);
        }
    }

    @Override
    public List<Product.Type> findAll() {
        Criteria criteria = getSession().createCriteria(Product.Type.class);
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }

    @Override
    public Product.Type findById(long id) {
        Criteria criteria = getSession().createCriteria(Product.Type.class);
        criteria.add(Restrictions.eq("id", id));
        return (Product.Type) criteria.uniqueResult();
    }

    @Override
    public void delete(long id) {
        Object persistentObject = getSession().load(Product.Type.class, id);
        getSession().delete(persistentObject);
    }

    @Override
    public void update(Product.Type type) {
        getSession().update(type);
    }
}