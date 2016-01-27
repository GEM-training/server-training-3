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
    public List<Product> findProductByType(Product.Type type) {
        return productDao.findProductByType(type);
    }

    @Override
    public List<Product> findProductByInventoryId(long id) {
        return productDao.findProductByInventoryId(id);
    }

    @Override
    public Product findProductById(long id) {
        return productDao.findProductById(id);
    }

    @Override
    public void deleteProduct(long id) {
        productDao.deleteProductById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }


}
