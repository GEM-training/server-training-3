package com.cloudteddy.gemcs01test.service.impl;

import com.cloudteddy.gemcs01test.dao.ProductDao;
import com.cloudteddy.gemcs01test.model.Product;
import com.cloudteddy.gemcs01test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kimtung on 1/20/16.
 */
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

    @Override
    public List<Product> findAllProducts() {
        return productDao.findAllProducts();
    }

    @Override
    public Product findProductById(long id) {
        return productDao.findProductById(id);
    }

    @Override
    public void deleteProduct(long id) {
        productDao.deleteProduct(id);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }
}