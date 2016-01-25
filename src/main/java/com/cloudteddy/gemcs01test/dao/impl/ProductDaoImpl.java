package com.cloudteddy.gemcs01test.dao.impl;

import com.cloudteddy.gemcs01test.dao.AbstractDao;
import com.cloudteddy.gemcs01test.dao.ProductDao;
import com.cloudteddy.gemcs01test.model.Bill;
import com.cloudteddy.gemcs01test.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kimtung on 1/20/16.
 */
@Repository("product")
@Transactional
public class ProductDaoImpl extends AbstractDao implements ProductDao {

    @Override
    public void save(Product product) {
        persist(product);
    }

    @Override
    public List<Product> findByType(Product.Type type) {
        Product.Type persitentType = (Product.Type) getSession().load(Product.Type.class, type.getId());
        List<Product> products = new ArrayList<>(0);
        products.addAll(persitentType.getProducts().stream().collect(Collectors.toList()));
        return products;
    }

    @Override
    public List<Product> findAll() {
        Criteria criteria = getSession().createCriteria(Product.class);
        return criteria.list();
    }

    @Override
    public Product findById(long id) {
        Criteria criteria = getSession().createCriteria(Product.class);
        criteria.add(Restrictions.eq("id", id));
        return (Product) criteria.uniqueResult();
    }

    @Override
    public void delete(long id) {
        Object persistentObject = getSession().load(Product.class, id);
        getSession().delete(persistentObject);
    }

    @Override
    public void update(Product product) {
        getSession().update(product);
    }
}
