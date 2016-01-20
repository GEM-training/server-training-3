package com.cloudteddy.springhibernate.service;

import com.cloudteddy.springhibernate.model.Product;

import java.util.List;

/**
 * Created by kimtung on 1/20/16.
 */
public interface ProductService {

    void saveProduct(Product product);

    List<Product> findAllProducts();

    Product findProductById(long id);

    void deleteProduct(long id);

    void updateProduct(Product product);
}
