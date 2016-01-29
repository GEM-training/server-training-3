package com.cloudteddy.gemcs01product.service;

import com.cloudteddy.gemcs01product.dao.filter.ProductFilter;
import com.cloudteddy.gemcs01product.dao.model.ListProduct;
import com.cloudteddy.gemcs01product.dao.model.Product;
import com.cloudteddy.gemcs01product.rest.message.Response;

import java.util.List;

/**
 * Created by kimtung on 29/01/16.
 */

public interface ProductService {
    
    List<Product> list();

    List<Product> list(ProductFilter productFilter);

    Long count();

    Product getById(long id);

    void update(Product product);

    void delete(Product product);

    void insert(Product product);

    Response insert2(ListProduct listProduct);
}
