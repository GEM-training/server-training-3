package com.cloudteddy.gemcs01test.dao.impl;

import com.cloudteddy.gemcs01test.dao.AbstractDao;
import com.cloudteddy.gemcs01test.dao.MakerDao;
import com.cloudteddy.gemcs01test.dao.PromotionDao;
import com.cloudteddy.gemcs01test.model.Bill;
import com.cloudteddy.gemcs01test.model.Maker;
import com.cloudteddy.gemcs01test.model.Promotion;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kimtung on 1/20/16.
 */
@Repository("promotion")
@Transactional
public class PromotionDaoImpl extends AbstractDao implements PromotionDao {
    @Override
    public void savePromotion(Promotion promotion) {
        persist(promotion);
    }

    @Override
    public List<Promotion> findAllPromotions() {
        Criteria criteria = getSession().createCriteria(Promotion.class);
        return criteria.list();
    }

    @Override
    public Promotion findPromotionById(long id) {
        Criteria criteria = getSession().createCriteria(Bill.class);
        criteria.add(Restrictions.eq("id", id));
        return (Promotion) criteria.uniqueResult();
    }

    @Override
    public void deletePromotion(long id) {
        Object persistentObject = getSession().load(Bill.class, id);
        getSession().delete(persistentObject);
    }

    @Override
    public void updatePromotion(Promotion promotion) {
        getSession().update(promotion);
    }
}
