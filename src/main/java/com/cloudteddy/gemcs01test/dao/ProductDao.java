package com.cloudteddy.gemcs01test.dao;

import com.cloudteddy.gemcs01test.model.Product;

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
    public List<Product> findProductByInventoryId(long INVENTORY_ID);
}
