package com.cloudteddy.gemcs01test;

import com.cloudteddy.gemcs01test.configuration.AppConfigure;
import com.cloudteddy.gemcs01test.model.Customer;
import com.cloudteddy.gemcs01test.model.Dealer;
import com.cloudteddy.gemcs01test.model.Product;
import com.cloudteddy.gemcs01test.service.CustomerService;
import com.cloudteddy.gemcs01test.service.DealerService;
import com.cloudteddy.gemcs01test.service.ProductService;
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

        List<Dealer> dealers = dealerService.findAllDealers();
        for(Dealer dealer : dealers) {
            System.out.println(dealer);
        }
    }

}
