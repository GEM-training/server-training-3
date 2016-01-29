package com.cloudteddy.gemcs01product.rest.controller;

import com.cloudteddy.gemcs01product.dao.ProductDao;
import com.cloudteddy.gemcs01product.dao.ProductTypeDao;
import com.cloudteddy.gemcs01product.dao.model.Product;
import com.cloudteddy.gemcs01product.rest.message.Response;
import com.cloudteddy.gemcs01product.rest.Constant;
import com.cloudteddy.gemcs01product.rest.message.AllProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
    public AllProductResponse list(
            @RequestParam(name = "pageSize", defaultValue = "25") int pageSize,
            @RequestParam(name = "pageNum", defaultValue = "1") int pageNum) {

        List<Product> products = productDao.list(pageNum, pageSize);
        AllProductResponse response = new AllProductResponse();
        response.setPage(pageNum);
        for (Product product : products) {
            AllProductResponse.ProductItem item = new AllProductResponse.ProductItem();
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
    public Response insert(@RequestBody AllProductResponse.ProductItem product) {
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
    public AllProductResponse.ProductItem viewDetail(
            @RequestParam(name = "id", defaultValue = "0") int id) {
        Product product = productDao.getById(id);
        return new AllProductResponse.ProductItem(product.getId(), product.getName(), product.getDetail(), product.getType().getName());
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            consumes = "application/json")
    public Response processJson(
            @RequestBody @Valid Product product, BindingResult error) {
        if (error.hasErrors()) return new Response(false, error.getAllErrors().get(0).toString(), null);
        try {
            productDao.update(product);
            return new Response(false, Constant.HTTPSUCCESS, null);
        } catch (Exception e) {
            return new Response(false, e.getClass() + " " + e.getMessage(), null);
        }

    }

    @RequestMapping(value = "/get-products")
    public
    @ResponseBody
    List<Product> getProducts(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum) {
        return productDao.getProducts(pageNum, pageSize);
    }
}
