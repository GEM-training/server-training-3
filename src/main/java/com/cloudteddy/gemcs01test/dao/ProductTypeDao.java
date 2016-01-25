package com.cloudteddy.gemcs01test.dao;

import com.cloudteddy.gemcs01test.model.Bill;
import com.cloudteddy.gemcs01test.model.Product;

import java.util.List;

/**
 * Created by kimtung on 25/01/16.
 */
public interface ProductTypeDao {

    void save(Product.Type type);

    void save(Product.Type[] types);

    List<Product.Type> findAll();

    Product.Type findById(long id);

    void delete(long id);

    void update(Product.Type type);

}
