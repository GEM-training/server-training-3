package com.cloudteddy.gemcs01product.service.impl;

import com.cloudteddy.gemcs01product.CustomRuntimeException;
import com.cloudteddy.gemcs01product.dao.ProductTypeDao;
import com.cloudteddy.gemcs01product.dao.model.ListProduct;
import com.cloudteddy.gemcs01product.dao.model.Product;
import com.cloudteddy.gemcs01product.rest.message.Response;
import com.cloudteddy.gemcs01product.service.ProductService;
import com.cloudteddy.gemcs01product.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kimtung on 29/01/16.
 */
@Service("service_productType")
@Transactional
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeDao productTypeDao;

    @Override
    @Transactional
    public List<Product.Type> list() {
        return productTypeDao.list();
    }

    @Override
    public Long count() {
        return productTypeDao.count();
    }

    @Override
    public Product.Type getById(long id) {
        return productTypeDao.getById(id);
    }

    @Override
    public Product.Type getByName(String name) {
        return productTypeDao.getByName(name);
    }

    @Override
    @Transactional
    public void update(Product.Type type) {
        productTypeDao.update(type);
    }

    @Override
    @Transactional
    public void delete(Product.Type type) {
        productTypeDao.insert(type);
    }

    @Override
    @Transactional
    public void insert(Product.Type type) {
        productTypeDao.insert(type);
    }

}
