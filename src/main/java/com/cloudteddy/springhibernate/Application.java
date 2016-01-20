package com.cloudteddy.springhibernate;

import com.cloudteddy.springhibernate.configuration.AppConfigure;
import com.cloudteddy.springhibernate.model.Customer;
import com.cloudteddy.springhibernate.model.Dealer;
import com.cloudteddy.springhibernate.model.Product;
import com.cloudteddy.springhibernate.service.CustomerService;
import com.cloudteddy.springhibernate.service.DealerService;
import com.cloudteddy.springhibernate.service.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;

/**
 * Created by kimtung on 1/18/16.
 */
public class Application {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfigure.class);
        DealerService dealerService = (DealerService) context.getBean("dealerService");
        ProductService productService = (ProductService) context.getBean("productService");
        CustomerService customerService = (CustomerService) context.getBean("customerService");

        List<Dealer> dealers = dealerService.getAllDealer();
        for(Dealer dealer : dealers) {
            System.out.println(dealer);
        }

        List<Product> products = productService.findAllProducts();
        for (Product product : products) {
            System.out.println(product);
        }

        List<Customer> customers = customerService.findAllCustomers();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

}
