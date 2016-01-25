package com.cloudteddy.gemcs01test.dao.impl;

import com.cloudteddy.gemcs01test.dao.AbstractDao;
import com.cloudteddy.gemcs01test.dao.BillDao;
import com.cloudteddy.gemcs01test.model.Bill;
import com.cloudteddy.gemcs01test.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kimtung on 1/20/16.
 */
@Repository("bill")
@Transactional
public class BillDaoImpl extends AbstractDao implements BillDao {
    @Override
    public void save(Bill bill) {
        persist(bill);
    }

    @Override
    public List<Bill> findAll() {
        Criteria criteria = getSession().createCriteria(Bill.class);
        return criteria.list();
    }

    @Override
    public Bill findById(long id) {
        Criteria criteria = getSession().createCriteria(Bill.class);
        criteria.add(Restrictions.eq("id", id));
        return (Bill) criteria.uniqueResult();
    }

    @Override
    public void delete(long id) {
        Object persistentObject = getSession().load(Bill.class, id);
        getSession().delete(persistentObject);
    }

    @Override
    public void update(Product product) {
        getSession().update(product);
    }
}
