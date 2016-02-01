package com.cloudteddy.cs01.dao;

import com.cloudteddy.cs01.model.Product;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kimtung on 01/02/16.
 */
public interface ProductTypeDao extends AbstractDao {
    Long count();
    Product.Type findById(Serializable id);
    List<Product.Type> list();
}
