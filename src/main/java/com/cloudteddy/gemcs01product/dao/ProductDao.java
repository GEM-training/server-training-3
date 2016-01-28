package com.cloudteddy.gemcs01product.dao;

import com.cloudteddy.gemcs01product.dao.model.Product;

import java.util.List;

/**
 * Created by kimtung on 1/27/16.
 */
public interface ProductDao {


    List<Product> list();

    public List<Product> list(int pageNum, int pageSize);

    Long count();

    Product getById(long id);

    void update(Product product);

    void delete(Product product);

    void insert(Product product);
}
