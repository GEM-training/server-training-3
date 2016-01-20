package com.cloudteddy.springhibernate.service.impl;

import com.cloudteddy.springhibernate.dao.CustomerDao;
import com.cloudteddy.springhibernate.dao.ProductDao;
import com.cloudteddy.springhibernate.model.Customer;
import com.cloudteddy.springhibernate.model.Product;
import com.cloudteddy.springhibernate.service.CustomerService;
import com.cloudteddy.springhibernate.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kimtung on 1/20/16.
 */
@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerDao.findAllCustomers();
    }

    @Override
    public void deleteCustomerById(long id) {
        customerDao.deleteCustomerById(id);
    }

    @Override
    public Customer findCustomerById(long id) {
        return customerDao.findCustomerById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }
}
