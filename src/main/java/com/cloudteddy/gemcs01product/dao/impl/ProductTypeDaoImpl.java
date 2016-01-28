package com.cloudteddy.gemcs01product.dao.impl;

import com.cloudteddy.gemcs01product.dao.ProductTypeDao;
import com.cloudteddy.gemcs01product.dao.model.Product;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by quanda on 28/01/2016.
 */
@Repository("dao_product_type")
@Transactional
public class ProductTypeDaoImpl extends AbstractDao implements ProductTypeDao {

    @Override
    public List<Product.Type> lít() {
        Criteria criteria = getSession().createCriteria(Product.Type.class);
        criteria.addOrder(Order.asc("name"));
        return criteria.list();
    }

    @Override
    public Long count() {
        Criteria criteria = getSession().createCriteria(Product.Type.class);
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }

    @Override
    public Product.Type getById(long id) {
        Criteria criteria = getSession().createCriteria(Product.Type.class);
        criteria.add(Restrictions.eq("id", id));
        return (Product.Type) criteria.uniqueResult();
    }

    @Override
    public Product.Type getByName(String name) {
        Criteria criteria = getSession().createCriteria(Product.Type.class);
        criteria.add((Restrictions.eq("name", name)));
        return (Product.Type) criteria.uniqueResult();
    }

    @Override
    public void update(Product.Type type) {
    }

    @Override
    public void delete(Product.Type type) {
        getSession().delete(type);
    }

    @Override
    public void insert(Product.Type type) {
        getSession().save(type);
    }
}
