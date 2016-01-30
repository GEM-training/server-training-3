package com.cloudteddy.gemcs01product.service.impl;

import com.cloudteddy.gemcs01product.CustomRuntimeException;
import com.cloudteddy.gemcs01product.dao.ProductDao;
import com.cloudteddy.gemcs01product.dao.ProductTypeDao;
import com.cloudteddy.gemcs01product.dao.filter.ProductFilter;
import com.cloudteddy.gemcs01product.dao.model.ListProduct;
import com.cloudteddy.gemcs01product.dao.model.Product;
import com.cloudteddy.gemcs01product.rest.message.Response;
import com.cloudteddy.gemcs01product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kimtung on 29/01/16.
 */
@Service("service_product")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductTypeDao productTypeDao;

    @Override
    public List<Product> list() {
        return productDao.list();
    }

    @Override
    @Transactional
    public List<Product> list(ProductFilter productFilter) {
        return productDao.list(productFilter);
    }

    @Override
    public Long count() {
        return productDao.count();
    }

    @Override
    public Product getById(long id) {
        return productDao.getById(id);
    }

    @Override
    @Transactional
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    @Transactional
    public void delete(Product product) {
        productDao.delete(product);
    }

    @Override
    @Transactional
    public void insert(Product product) {
        productDao.insert(product);
    }

    @Override
    @Transactional
    public Response insert2(ListProduct listProduct) {
        if (listProduct.productItemList.get(0).getName() == null) {
            throw new CustomRuntimeException("Name is empty");
        } else if (listProduct.productItemList.get(0).getType() == null) {
            throw new CustomRuntimeException("type is empty");
        } else {
            productDao.insert(new Product(listProduct.productItemList.get(0).getName(), listProduct.productItemList.get(0).getDetail(), productTypeDao.getByName(listProduct.productItemList.get(0).getType())));
        }

        if (listProduct.productItemList.get(1).getName() == null) {
            throw new CustomRuntimeException("name2 is empty");
        } else if (listProduct.productItemList.get(1).getType() == null) {
            throw new CustomRuntimeException("type2 is empty");
        } else {
            productDao.insert(new Product(listProduct.productItemList.get(1).getName(), listProduct.productItemList.get(1).getDetail(), productTypeDao.getByName(listProduct.productItemList.get(1).getType())));
        }
        return new Response(true, "inserted", listProduct);
    }
}