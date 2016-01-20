package com.cloudteddy.gemcs01test.dao.impl;

import com.cloudteddy.gemcs01test.dao.AbstractDao;
import com.cloudteddy.gemcs01test.dao.BillDao;
import com.cloudteddy.gemcs01test.model.Bill;
import com.cloudteddy.gemcs01test.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kimtung on 1/20/16.
 */
@Repository("bill")
public class BillDaoImpl extends AbstractDao implements BillDao {
    @Override
    public void saveBill(Bill bill) {
        persist(bill);
    }

    @Override
    public List<Bill> findAllBills() {
        Criteria criteria = getSession().createCriteria(Bill.class);
        return criteria.list();
    }

    @Override
    public Bill findBillById(long id) {
        Criteria criteria = getSession().createCriteria(Bill.class);
        criteria.add(Restrictions.eq("id", id));
        return (Bill) criteria.uniqueResult();
    }

    @Override
    public void deleteBill(long id) {
        Query deleteQuery  = getSession().createSQLQuery("DELETE FROM bill where bill_id = :id");
        deleteQuery.setLong("id", id);
        deleteQuery.executeUpdate();
    }

    @Override
    public void updateBill(Product product) {
        getSession().update(product);
    }
}
