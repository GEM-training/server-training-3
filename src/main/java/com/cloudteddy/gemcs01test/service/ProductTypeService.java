package com.cloudteddy.gemcs01test.service;

import com.cloudteddy.gemcs01test.model.Product;

import java.util.List;

/**
 * Created by quanda on 27/01/2016.
 */
public interface ProductTypeService {

    void saveType(Product.Type type);

    void saveTypes(Product.Type[] types);

    List<Product.Type> findAllTypes();

    Product.Type findTypeById(long id);

    void deleteType(long id);

    void updateType(Product.Type type);

}
