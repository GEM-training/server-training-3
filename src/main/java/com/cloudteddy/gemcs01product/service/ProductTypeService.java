package com.cloudteddy.gemcs01product.service;

import com.cloudteddy.gemcs01product.dao.model.Product;

import java.util.List;

/**
 * Created by kimtung on 29/01/16.
 */
public interface ProductTypeService {

    List<Product.Type> list();

    Long count();

    Product.Type getById(long id);

    Product.Type getByName(String name);

    void update(Product.Type type);

    void delete(Product.Type type);

    void insert(Product.Type type);

}
