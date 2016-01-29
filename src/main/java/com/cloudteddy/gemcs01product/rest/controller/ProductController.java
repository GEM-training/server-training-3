package com.cloudteddy.gemcs01product.rest.controller;

import com.cloudteddy.gemcs01product.dao.ProductDao;
import com.cloudteddy.gemcs01product.dao.filter.ProductFilter;
import com.cloudteddy.gemcs01product.dao.ProductTypeDao;
import com.cloudteddy.gemcs01product.dao.model.Product;
import com.cloudteddy.gemcs01product.dao.model.Response;
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
    public String fallback() {
        return "I don't know what you're asking :3";
    }

    @RequestMapping("/error")
    public String error() {
        return "Bug again? wtf!!!";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = "application/json")
    public String insert(@RequestBody ProductListResponse.ProductItem product) {
        try {
            if (product.getName() == null) {
                return "Name is empty";
            } else if (product.getType() == null) {
                return "Type is empty";
            } else {
                productDao.insert(new Product(product.getName(), product.getDetail(), productTypeDao.getByName(product.getType())));
            }
        } catch (Exception e) {
            /**
             * handle insert error
             */
            e.printStackTrace();
            return "Error";
        }
        /**
         * Handle inserted
         */
        return "Insert " + product.toString();
    }

    @RequestMapping("/delete")
    public String delete(
            @RequestParam(name = "id") long id) {
        try {
            Product product = new Product();
            product.setId(id);
            productDao.delete(product);
        } catch (Exception e) {
            /**
             * handle object not found
             */
            return "Object not found";
        }
        /**
         * handle deleted
         */
        return "Deleted item " + id;
    }

    @RequestMapping("/detail")
    public ProductListResponse.ProductItem viewDetail(
            @RequestParam(name = "id", defaultValue = "0") int id) {

        Product product = productDao.getById(id);
        return new ProductListResponse.ProductItem(product.getId(), product.getName(), product.getDetail(), product.getType().getName());
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            consumes = "application/json")
    public Response processJson(
            @RequestBody @Valid Product product, BindingResult error) {
        if(error.hasErrors()) return new Response(false,error.getAllErrors().get(0).toString(),null);
        try{
            productDao.update(product);
            return new Response(false, Constant.HTTPSUCCESS,null);
        }catch (Exception e){
            return new Response(false,e.getClass()+" "+e.getMessage(),null);
        }

    }

}
