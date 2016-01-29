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

import java.util.List;

/**
 * Created by kimtung on 29/01/16.
 */
@Service("service_productType")
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private ProductService productService;


    @Override
    public List<Product.Type> list() {
        return productTypeService.list();
    }

    @Override
    public Long count() {
        return productTypeService.count();
    }

    @Override
    public Product.Type getById(long id) {
        return productTypeService.getById(id);
    }

    @Override
    public Product.Type getByName(String name) {
        return productTypeService.getByName(name);
    }

    @Override
    public void update(Product.Type type) {
        productTypeService.update(type);
    }

    @Override
    public void delete(Product.Type type) {
        productTypeService.insert(type);
    }

    @Override
    public void insert(Product.Type type) {
        productTypeService.insert(type);
    }

    public Response insert2(ListProduct productlist) {
        if (productlist.productItemList.get(0).getName() == null) {
            throw new CustomRuntimeException("Name is empty");
        } else if (productlist.productItemList.get(0).getType() == null) {
            throw new CustomRuntimeException("type is empty");
        } else {
            productService.insert(new Product(productlist.productItemList.get(0).getName(), productlist.productItemList.get(0).getDetail(), productTypeService.getByName(productlist.productItemList.get(0).getType())));
        }

        if (productlist.productItemList.get(1).getName() == null) {
            throw new CustomRuntimeException("name2 is empty");
        } else if (productlist.productItemList.get(1).getType() == null) {
            throw new CustomRuntimeException("type2 is empty");
        } else {
            productService.insert(new Product(productlist.productItemList.get(1).getName(), productlist.productItemList.get(1).getDetail(), productTypeService.getByName(productlist.productItemList.get(1).getType())));
        }
        return new Response(true, "inserted", productlist);
    }
}
