package com.cloudteddy.gemcs01test.dao;

import com.cloudteddy.gemcs01test.model.Bill;
import com.cloudteddy.gemcs01test.model.Product;

import java.util.List;

/**
 * Created by kimtung on 25/01/16.
 */
public interface ProductTypeDao {

    void saveType(Product.Type type);

    void saveTypes(Product.Type[] types);

    List<Product.Type> findAllTypes();

    Product.Type findTypeById(long id);

    void deleteTypeById(long id);

    void updateType(Product.Type type);

}
