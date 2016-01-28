package com.cloudteddy.gemcs01product.dao;

import com.cloudteddy.gemcs01product.dao.model.Product;

import java.util.List;

/**
 * Created by quanda on 28/01/2016.
 */
public interface ProductTypeDao {

    List<Product.Type> lít();

    Long count();

    Product.Type getById(long id);

    Product.Type getByName(String name);

    void update(Product.Type type);

    void delete(Product.Type type);

    void insert(Product.Type type);
}
