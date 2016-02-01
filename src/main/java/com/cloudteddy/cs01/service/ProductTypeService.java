package com.cloudteddy.cs01.service;

import com.cloudteddy.cs01.dao.ProductTypeDao;
import com.cloudteddy.cs01.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kimtung on 01/02/16.
 */
@Service("service_productType")
@Transactional
public class ProductTypeService {

    @Autowired
    private ProductTypeDao productTypeDao;

    public Product.Type findById(Serializable id) {
        return productTypeDao.getById(id);
    }

    public List<Product.Type> list() {
        return productTypeDao.list();
    }

    public Long count() {
        return productTypeDao.count();
    }

    public void insert(Product.Type type) {
        productTypeDao.persit(type);
    }

    public void update(Product.Type type) {
        productTypeDao.update(type);
    }

    public void delete(Product.Type type) {
        productTypeDao.delete(type);
    }

    public void delete(Serializable id) {
        productTypeDao.deleteById(id);
    }
}
