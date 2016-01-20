package com.cloudteddy.springhibernate.dao;

import com.cloudteddy.springhibernate.model.Product;

import java.util.List;

/**
 * Created by kimtung on 1/20/16.
 */
public interface ProductDao {

    void saveProduct(Product product);

    List<Product> findAllProducts();

    Product findProductById(long id);

    void deleteProduct(long id);

    void updateProduct(Product product);

}
