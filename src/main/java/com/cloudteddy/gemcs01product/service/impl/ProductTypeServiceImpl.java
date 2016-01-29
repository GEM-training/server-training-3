package com.cloudteddy.gemcs01product.service.impl;

import com.cloudteddy.gemcs01product.CustomRuntimeException;
import com.cloudteddy.gemcs01product.dao.ProductTypeDao;
import com.cloudteddy.gemcs01product.dao.model.ListProduct;
import com.cloudteddy.gemcs01product.dao.model.Product;
import com.cloudteddy.gemcs01product.rest.message.Response;
import com.cloudteddy.gemcs01product.service.ProductService;
import com.cloudteddy.gemcs01product.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kimtung on 29/01/16.
 */
@Service("service_productType")
@Transactional
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeDao productTypeDao;

    @Autowired
    private ProductService productService;


    @Override
    @Transactional
    public List<Product.Type> list() {
        return productTypeDao.list();
    }

    @Override
    public Long count() {
        return productTypeDao.count();
    }

    @Override
    public Product.Type getById(long id) {
        return productTypeDao.getById(id);
    }

    @Override
    public Product.Type getByName(String name) {
        return productTypeDao.getByName(name);
    }

    @Override
    @Transactional
    public void update(Product.Type type) {
        productTypeDao.update(type);
    }

    @Override
    @Transactional
    public void delete(Product.Type type) {
        productTypeDao.insert(type);
    }

    @Override
    @Transactional
    public void insert(Product.Type type) {
        productTypeDao.insert(type);
    }

    @Transactional
    public Response insert2(ListProduct productlist) {
        if (productlist.productItemList.get(0).getName() == null) {
            throw new CustomRuntimeException("Name is empty");
        } else if (productlist.productItemList.get(0).getType() == null) {
            throw new CustomRuntimeException("type is empty");
        } else {
            productService.insert(new Product(productlist.productItemList.get(0).getName(), productlist.productItemList.get(0).getDetail(), productTypeDao.getByName(productlist.productItemList.get(0).getType())));
        }

        if (productlist.productItemList.get(1).getName() == null) {
            throw new CustomRuntimeException("name2 is empty");
        } else if (productlist.productItemList.get(1).getType() == null) {
            throw new CustomRuntimeException("type2 is empty");
        } else {
            productService.insert(new Product(productlist.productItemList.get(1).getName(), productlist.productItemList.get(1).getDetail(), productTypeDao.getByName(productlist.productItemList.get(1).getType())));
        }
        return new Response(true, "inserted", productlist);
    }
}
