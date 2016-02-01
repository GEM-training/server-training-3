package com.cloudteddy.cs01.dao;

import com.cloudteddy.cs01.dao.filter.ProductFilter;
import com.cloudteddy.cs01.model.Product;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kimtung on 01/02/16.
 */
public interface ProductDao extends AbstractDao {

    Long count();
    Product findById(Serializable id);
    List<Product> list(ProductFilter filter);

}
