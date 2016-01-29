package com.cloudteddy.gemcs01product.rest.controller;

import com.cloudteddy.gemcs01product.dao.filter.ProductFilter;
import com.cloudteddy.gemcs01product.dao.model.ListProduct;
import com.cloudteddy.gemcs01product.dao.model.Product;
import com.cloudteddy.gemcs01product.rest.Constant;
import com.cloudteddy.gemcs01product.rest.message.ProductListResponse;
import com.cloudteddy.gemcs01product.rest.message.Response;
import com.cloudteddy.gemcs01product.service.ProductService;
import com.cloudteddy.gemcs01product.service.ProductTypeService;
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
    private ProductService productService;

    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping()
    public ProductListResponse list(
            @RequestParam(name = "keyword", required = false) String keyword,
            @RequestParam(name = "pageSize", defaultValue = "25") int pageSize,
            @RequestParam(name = "page", defaultValue = "0") int pageNum ){

        ProductFilter filter = new ProductFilter();
        filter.setKeyword(keyword)
                .setPageSize(pageSize)
                .setPage(pageNum);
        List<Product> products = productService.list(filter);

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
        return productService.count();
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
                productService.insert(new Product(product.getName(), product.getDetail(), productTypeService.getByName(product.getType())));
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
            productService.delete(productService.getById(id));
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
        Product product = productService.getById(id);
        if (product == null) {
            return new Response(false, "Product null!", null);
        } else {
            return new Response(true, "", product);
        }
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            consumes = "application/json")
    public Response updateProduct(
            @RequestBody @Valid ProductListResponse.ProductItem productItem, BindingResult error) {
        if (error.hasErrors()) return new Response(false, error.getAllErrors().get(0).toString(), null);
        try {

            Product p = productService.getById(productItem.getId());
            p.setName(productItem.getName());
            p.setDetail(productItem.getDetail());
            Product.Type t = productTypeService.getByName(productItem.getType());
            p.setType(t);
            productService.update(p);
            return new Response(false, Constant.HTTPSUCCESS, null);
        } catch (Exception e) {
            return new Response(false, e.getMessage(), null);
        }

    }


    @RequestMapping(value = "/insert2",
            method = RequestMethod.POST,
            consumes = "application/json")
    public Response insert2Product(
            @RequestBody @Valid ListProduct productlist, BindingResult error) {
        try {
            return productService.insert2(productlist);
        } catch (Exception e) {
            return new Response(false, "", null);
        }
    }

}
