package com.cloudteddy.gemcs01product.rest.service;

import com.cloudteddy.gemcs01product.CustomRuntimeException;
import com.cloudteddy.gemcs01product.dao.ProductDao;
import com.cloudteddy.gemcs01product.dao.ProductTypeDao;
import com.cloudteddy.gemcs01product.dao.impl.ProductDaoImpl;
import com.cloudteddy.gemcs01product.dao.model.ListProduct;
import com.cloudteddy.gemcs01product.dao.model.Product;
import com.cloudteddy.gemcs01product.rest.message.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by huylv on 29/01/2016.
 */
@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductTypeDao productTypeDao;

    public Response insert2(ListProduct productlist) {
            if (productlist.productItemList.get(0).getName() == null) {
                throw new CustomRuntimeException("Name is empty");
            } else if (productlist.productItemList.get(0).getType() == null) {
                throw new CustomRuntimeException("type is empty");
            } else {
                productDao.insert(new Product(productlist.productItemList.get(0).getName(), productlist.productItemList.get(0).getDetail(), productTypeDao.getTypeByName(productlist.productItemList.get(0).getType())));
            }

            if (productlist.productItemList.get(1).getName() == null) {
                throw new CustomRuntimeException("name2 is empty");
            } else if (productlist.productItemList.get(1).getType() == null) {
                throw new CustomRuntimeException("type2 is empty");
            } else {
                productDao.insert(new Product(productlist.productItemList.get(1).getName(), productlist.productItemList.get(1).getDetail(), productTypeDao.getTypeByName(productlist.productItemList.get(1).getType())));
            }
        return new Response(true, "inserted", productlist);
    }
}
