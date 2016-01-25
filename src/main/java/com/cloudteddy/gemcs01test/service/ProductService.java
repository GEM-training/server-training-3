package com.cloudteddy.gemcs01test.service;

import com.cloudteddy.gemcs01test.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kimtung on 1/20/16.
 */
public interface ProductService {

    void saveProduct(Product product);

    List<Product> findAllProducts();

    Product findProductById(long id);

    void deleteProduct(long id);

    void updateProduct(Product product);
    public List<Product> findProductByInventoryId(long INVENTORY_ID);
}
