package com.cloudteddy.gemcs01product.rest.controller;

import com.cloudteddy.gemcs01product.dao.ProductDao;
import com.cloudteddy.gemcs01product.dao.filter.ProductFilter;
import com.cloudteddy.gemcs01product.dao.ProductTypeDao;
import com.cloudteddy.gemcs01product.dao.model.Product;
import com.cloudteddy.gemcs01product.rest.message.Response;
import com.cloudteddy.gemcs01product.rest.Constant;
import com.cloudteddy.gemcs01product.rest.message.ProductListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by kimtung on 1/27/16.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductTypeDao productTypeDao;

    @RequestMapping()
    @Transactional
    public ProductListResponse list(
            @RequestParam(name = "keyword", required = false) String keyword,
            @RequestParam(name = "pageSize", defaultValue = "25") int pageSize,
            @RequestParam(name = "page", defaultValue = "0") int pageNum ){

        ProductFilter filter = new ProductFilter();
        filter.setKeyword(keyword)
                .setPageSize(pageSize)
                .setPage(pageNum);
        List<Product> products = productDao.list(filter);

        ProductListResponse response = new ProductListResponse();
        response.setPage(pageNum);
        for (Product product : products) {
            ProductListResponse.ProductItem item = new ProductListResponse.ProductItem();
            item.setId(product.getId())
                    .setName(product.getName())
                    .setType(product.getType().getName())
                    .setDetail(product.getDetail());
            response.getItems().add(item);
        }
        return response;
    }

    @RequestMapping("/count")
    public Long count() {
        return productDao.count();
    }

    @RequestMapping("*")
    public Response fallback() {
        return new Response(false, "I don't know what you're asking :3", null);
    }

    @RequestMapping("/error")
    public Response error() {
        return new Response(false, "Bug again? wtf!!!", null);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = "application/json")
    public Response insert(@RequestBody ProductListResponse.ProductItem product) {
        try {
            if (product.getName() == null) {
                return new Response(false, "name is empty", product);
            } else if (product.getType() == null) {
                return new Response(false, "type is empty", product);
            } else {
                System.out.println(product.getType());
                productDao.insert(new Product(product.getName(), product.getDetail(), productTypeDao.getTypeByName(product.getType())));
            }
        } catch (Exception e) {
            /**
             * handle insert error
             */
            return new Response(false, e.toString(), product);
        }
        /**
         * Handle inserted
         */
        return new Response(true, "inserted", product);
    }

    @RequestMapping(value = "/delete")
    public Response delete(
            @RequestParam(name = "id") long id) {
        try {
            productDao.delete(productDao.getById(id));
        } catch (Exception e) {
            /**
             * handle object not found
             */
            return new Response(false, "item not found", id);
        }
        /**
         * handle deleted
         */
        return new Response(true, "deleted item", id);
    }

    @RequestMapping("/detail")
    public Response viewDetail(
            @RequestParam(name = "id", defaultValue = "0") int id) {
        Product product = productDao.getById(id);
        if(product==null){
            return new Response(false,"Product null!",null);
        }else {
            return new Response(true, "", product);
        }
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            consumes = "application/json")
    public Response processJson(
            @RequestBody @Valid ProductListResponse.ProductItem productItem, BindingResult error) {
        if (error.hasErrors()) return new Response(false, error.getAllErrors().get(0).toString(), null);
        try {

            Product p = productDao.getById(productItem.getId());
            p.setName(productItem.getName());
            p.setDetail(productItem.getDetail());
            Product.Type t = productTypeDao.getTypeByName(productItem.getType());
            p.setType(t);

            productDao.update(p);
            return new Response(false, Constant.HTTPSUCCESS, null);
        } catch (Exception e) {
            return new Response(false, e.getMessage(), null);
        }

    }

}
