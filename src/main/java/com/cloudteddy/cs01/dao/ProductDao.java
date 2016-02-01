package com.cloudteddy.cs01.dao;

import com.cloudteddy.cs01.dao.filter.ProductFilter;
import com.cloudteddy.cs01.model.Product;

import java.util.List;

/**
 * Created by kimtung on 01/02/16.
 */
public interface ProductDao extends AbstractDao<Product> {

    List<Product> list(ProductFilter filter);

}
