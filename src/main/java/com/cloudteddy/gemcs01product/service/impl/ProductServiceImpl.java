package com.cloudteddy.gemcs01product.service.impl;

import com.cloudteddy.gemcs01product.dao.ProductDao;
import com.cloudteddy.gemcs01product.dao.filter.ProductFilter;
import com.cloudteddy.gemcs01product.dao.model.ListProduct;
import com.cloudteddy.gemcs01product.dao.model.Product;
import com.cloudteddy.gemcs01product.rest.message.Response;
import com.cloudteddy.gemcs01product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kimtung on 29/01/16.
 */
@Service("service_product")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> list() {
        return productDao.list();
    }

    @Override
    public List<Product> list(ProductFilter productFilter) {
        return productDao.list(productFilter);
    }

    @Override
    public Long count() {
        return productDao.count();
    }

    @Override
    public Product getById(long id) {
        return productDao.getById(id);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void delete(Product product) {
        productDao.delete(product);
    }

    @Override
    public void insert(Product product) {
        productDao.insert(product);
    }

    @Override
    public Response insert2(ListProduct listProduct) {
        return null;
    }
}
