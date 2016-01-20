package com.cloudteddy.springhibernate.dao;

import com.cloudteddy.springhibernate.model.Customer;
import com.cloudteddy.springhibernate.model.Dealer;

import java.util.List;

/**
 * Created by kimtung on 1/20/16.
 */
public interface CustomerDao {
    void saveCustomer(Customer customer);

    List<Customer> findAllCustomers();

    void deleteCustomerById(long id);

    Customer findCustomerById(long id);

    void updateCustomer(Customer customer);

}
