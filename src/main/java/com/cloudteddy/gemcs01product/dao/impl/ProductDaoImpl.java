package com.cloudteddy.gemcs01product.dao.impl;

import com.cloudteddy.gemcs01product.dao.ProductDao;
import com.cloudteddy.gemcs01product.dao.model.Product;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kimtung on 1/27/16.
 */
@Repository("dao_product")
@Transactional
public class ProductDaoImpl extends AbstractDao implements ProductDao {

    @Override
    public void insert(Product product) {

    }

    @Override
    public List<Product> list() {
        Criteria criteria = getSession().createCriteria(Product.class);
        criteria.addOrder(Order.asc("name"));
        return criteria.list();
    }

    @Override
    public List<Product> list(int pageNum, int pageSize) {
        Criteria criteria = getSession().createCriteria(Product.class);
        criteria.addOrder(Order.asc("name"))
                .setFirstResult(pageSize*pageNum)
                .setMaxResults(pageSize)
                .setCacheable(true);
        return criteria.list();
    }

    @Override
    public Long count() {
        Criteria criteria = getSession().createCriteria(Product.class);
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }

    @Override
    public Product getById() {
        return null;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Product product) {

    }
}
