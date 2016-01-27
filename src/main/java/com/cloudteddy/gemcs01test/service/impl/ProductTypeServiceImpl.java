package com.cloudteddy.gemcs01test.service.impl;

import com.cloudteddy.gemcs01test.dao.ProductTypeDao;
import com.cloudteddy.gemcs01test.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by quanda on 27/01/2016.
 */
public class ProductTypeServiceImpl implements com.cloudteddy.gemcs01test.service.ProductTypeService {

    @Autowired
    private ProductTypeDao productTypeDao;

    @Override
    public void saveType(Product.Type type) {
        productTypeDao.saveType(type);
    }

    @Override
    public void saveTypes(Product.Type[] types) {
        productTypeDao.saveTypes(types);
    }

    @Override
    public List<Product.Type> findAllTypes() {
        return productTypeDao.findAllTypes();
    }

    @Override
    public Product.Type findTypeById(long id) {
        return productTypeDao.findTypeById(id);
    }

    @Override
    public void deleteType(long id) {
        productTypeDao.deleteTypeById(id);
    }

    @Override
    public void updateType(Product.Type type) {
        productTypeDao.updateType(type);
    }
}
