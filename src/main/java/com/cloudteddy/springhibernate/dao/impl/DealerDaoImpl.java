package com.cloudteddy.springhibernate.dao.impl;

import com.cloudteddy.springhibernate.dao.AbstractDao;
import com.cloudteddy.springhibernate.dao.DealerDao;
import com.cloudteddy.springhibernate.model.Dealer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kimtung on 1/18/16.
 */
@Repository("dealer")
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
        Query query = getSession().createSQLQuery("DELETE FROM dealer where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
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
