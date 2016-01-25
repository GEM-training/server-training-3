package com.cloudteddy.gemcs01test.dao;

import com.cloudteddy.gemcs01test.model.Product;

import java.util.List;

/**
 * Created by kimtung on 1/20/16.
 */
public interface ProductDao {

    void save(Product product);

    List<Product> findAll();

    Product findById(long id);

    void delete(long id);

    void update(Product product);

}
