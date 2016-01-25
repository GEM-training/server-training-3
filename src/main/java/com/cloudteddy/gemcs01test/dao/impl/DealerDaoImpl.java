package com.cloudteddy.gemcs01test.dao.impl;

import com.cloudteddy.gemcs01test.dao.AbstractDao;
import com.cloudteddy.gemcs01test.dao.DealerDao;
import com.cloudteddy.gemcs01test.model.Bill;
import com.cloudteddy.gemcs01test.model.Dealer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kimtung on 1/18/16.
 */
@Repository("dealer")
@Transactional
public class DealerDaoImpl extends AbstractDao implements DealerDao {
    @Override
    public void saveDealer(Dealer dealer) {
        persist(dealer);
    }

    @Override
    public List<Dealer> findAllDealers() {
        Criteria criteria = getSession().createCriteria(Dealer.class);
        return (List<Dealer>) criteria.list();
    }

    @Override
    public void deleteDealerById(long id) {
        Object persistentObject = getSession().load(Bill.class, id);
        getSession().delete(persistentObject);
    }

    @Override
    public Dealer findDealerById(long id) {
        Criteria criteria = getSession().createCriteria(Dealer.class);
        criteria.add(Restrictions.eq("id", id));
        return (Dealer) criteria.uniqueResult();
    }

    @Override
    public void updateDealer(Dealer dealer) {
        getSession().update(dealer);
    }
}
