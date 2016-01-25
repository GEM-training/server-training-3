package com.cloudteddy.gemcs01test.dao.impl;

import com.cloudteddy.gemcs01test.dao.AbstractDao;
import com.cloudteddy.gemcs01test.dao.CustomerDao;
import com.cloudteddy.gemcs01test.model.Bill;
import com.cloudteddy.gemcs01test.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kimtung on 1/20/16.
 */
@Repository("customer")
@Transactional
public class CustomerDaoImpl extends AbstractDao implements CustomerDao {

    @Override
    public void saveCustomer(Customer customer) {
        persist(customer);
    }

    @Override
    public List<Customer> findAllCustomers() {
        Criteria criteria = getSession().createCriteria(Customer.class);
        return criteria.list();
    }

    @Override
    public Customer findCustomerById(long id) {
        Criteria criteria = getSession().createCriteria(Customer.class);
        criteria.add(Restrictions.eq("id", id));
        return (Customer) criteria.uniqueResult();
    }

    @Override
    public void deleteCustomerById(long id) {
        Object persistentObject = getSession().load(Bill.class, id);
        getSession().delete(persistentObject);
    }

    @Override
    public void updateCustomer(Customer customer) {
        getSession().update(customer);
    }
}
