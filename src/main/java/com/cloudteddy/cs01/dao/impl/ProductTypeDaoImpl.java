package com.cloudteddy.cs01.dao.impl;

import com.cloudteddy.cs01.dao.ProductTypeDao;
import com.cloudteddy.cs01.model.Product;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by kimtung on 01/02/16.
 */
@Repository("dao_productType")
public class ProductTypeDaoImpl extends AbstractDao implements ProductTypeDao {

    @Override
    public Product.Type findById(Serializable id) {
        return (Product.Type) getSession().load(Product.Type.class, id);
    }
}
