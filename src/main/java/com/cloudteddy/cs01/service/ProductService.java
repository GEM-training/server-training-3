package com.cloudteddy.cs01.service;

import com.cloudteddy.cs01.dao.ProductDao;
import com.cloudteddy.cs01.dao.ProductTypeDao;
import com.cloudteddy.cs01.dao.filter.ProductFilter;
import com.cloudteddy.cs01.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kimtung on 01/02/16.
 */
@Service("service_product")
@Transactional
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductTypeDao productTypeDao;

    public Product findById(Serializable id) {
        return productDao.getById(id);
    }

    public List<Product> list(ProductFilter filter) {
        return productDao.list(filter);
    }

    public Long count() {
        return productDao.count();
    }

    public void insert(Product product) {
        productDao.persit(product);
    }

    public void insert(Product product, Serializable typeId) {
        Product.Type type = productTypeDao.loadById(typeId);
        product.setType(type);
        productDao.persit(product);
    }

    public void update(Product product) {
        productDao.update(product);
    }

    public void delete(Product product) {
        productDao.delete(product);
    }

    public void delete(Serializable id) {
        productDao.deleteById(id);
    }


}
