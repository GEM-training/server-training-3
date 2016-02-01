package com.cloudteddy.cs01.dao.impl;

import com.cloudteddy.cs01.dao.ProductTypeDao;
import com.cloudteddy.cs01.model.Product;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kimtung on 01/02/16.
 */
@Repository("dao_productType")
public class ProductTypeDaoImpl extends AbstractDao<Product.Type> implements ProductTypeDao {

    public ProductTypeDaoImpl() {
        super(Product.Type.class);
    }

    @Override
    public Long count() {
        Criteria criteria = getSession().createCriteria(Product.Type.class);
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }

    @Override
    public List<Product.Type> list() {
        Criteria criteria = getSession().createCriteria(Product.Type.class);
        criteria.addOrder(Order.asc("name"));
        return criteria.list();
    }
}
