package com.cloudteddy.gemcs01test.service.impl;

import com.cloudteddy.gemcs01test.dao.CustomerDao;
import com.cloudteddy.gemcs01test.model.Customer;
import com.cloudteddy.gemcs01test.service.CustomerService;
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
    public Customer findCustomerById(long id) {
        return customerDao.findCustomerById(id);
    }

    @Override
    public void deleteCustomerById(long id) {
        customerDao.deleteCustomerById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }


}
