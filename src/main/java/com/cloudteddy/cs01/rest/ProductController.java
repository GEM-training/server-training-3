package com.cloudteddy.cs01.rest;

import com.cloudteddy.cs01.dao.filter.ProductFilter;
import com.cloudteddy.cs01.model.Product;
import com.cloudteddy.cs01.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kimtung on 01/02/16.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> list(
            @RequestParam(name = "keyword", required = false) String keyword,
            @RequestParam(name = "pageSize", required = false, defaultValue = "25") int pageSize,
            @RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        ProductFilter filter = new ProductFilter();
        filter.keyword = keyword;
        filter.pageSize = pageSize;
        filter.pageSize = pageSize;
        return productService.list(filter);
    }

    @RequestMapping("/{id}")
    public Product findById(@PathVariable(value = "id") Long id) {
        return productService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void insert(@RequestBody Product product) {
        productService.insert(product, product.getType().getId());
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public void update(@RequestBody Product product) {
        productService.update(product);
    }

    @RequestMapping(method = RequestMethod.DELETE, consumes = "application/json")
    public void delete(@RequestBody Product product) {
        productService.delete(product);
    }

    @RequestMapping(method = RequestMethod.DELETE, consumes = "text/plain")
    public void delete(@RequestBody String id) {
        productService.delete(Long.parseLong(id));
    }

}
