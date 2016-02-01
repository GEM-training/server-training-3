package com.cloudteddy.cs01.rest;

import com.cloudteddy.cs01.model.Product;
import com.cloudteddy.cs01.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kimtung on 01/02/16.
 */
@RestController
@RequestMapping("/type")
public class ProductTypeController {
    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product.Type> list() {
        return productTypeService.list();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product.Type findById(@PathVariable(value = "id") long id) {
        Product.Type type =  productTypeService.findById(id);
        return type;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json;")
    public void insert(@RequestBody Product.Type type) {
        productTypeService.insert(type);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public void update(@RequestBody Product.Type type) {
        productTypeService.update(type);
    }

    @RequestMapping(method = RequestMethod.DELETE, consumes = "application/json")
    public void delete(@RequestBody Product.Type type) {
        productTypeService.delete(type);
    }

    @RequestMapping(method = RequestMethod.DELETE, consumes = "text/plain")
    public void delete(@RequestBody String id) {
        productTypeService.delete(Long.parseLong(id));
    }

}
