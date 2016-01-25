package com.cloudteddy.gemcs01test.dao.impl;

import com.cloudteddy.gemcs01test.dao.AbstractDao;
import com.cloudteddy.gemcs01test.dao.MakerDao;
import com.cloudteddy.gemcs01test.model.Bill;
import com.cloudteddy.gemcs01test.model.Maker;
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
@Repository("maker")
@Transactional
public class MakerDaoImpl extends AbstractDao implements MakerDao {
    @Override
    public void saveMaker(Maker maker) {
        persist(maker);
    }

    @Override
    public List<Maker> findAllMakers() {
        Criteria criteria = getSession().createCriteria(Maker.class);
        return criteria.list();
    }

    @Override
    public Maker findMakerById(long id) {
        Criteria criteria = getSession().createCriteria(Bill.class);
        criteria.add(Restrictions.eq("id", id));
        return (Maker) criteria.uniqueResult();
    }

    @Override
    public void deleteMaker(long id) {
        Query deleteQuery  = getSession().createSQLQuery("DELETE FROM maker where maker_id = :id");
        deleteQuery.setLong("id", id);
        deleteQuery.executeUpdate();
    }

    @Override
    public void updateMaker(Maker maker) {
        getSession().update(maker);
    }
}
