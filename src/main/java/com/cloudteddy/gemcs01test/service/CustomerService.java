package com.cloudteddy.gemcs01test.service;

import com.cloudteddy.gemcs01test.model.Customer;

import java.util.List;

/**
 * Created by kimtung on 1/20/16.
 */
public interface CustomerService {
    void saveCustomer(Customer customer);

    List<Customer> findAllCustomers();

    Customer findCustomerById(long id);

    void deleteCustomerById(long id);

    void updateCustomer(Customer customer);
}
