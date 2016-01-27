package com.cloudteddy.gemcs01test.service.impl;

import com.cloudteddy.gemcs01test.dao.PromotionDao;
import com.cloudteddy.gemcs01test.model.Promotion;
import com.cloudteddy.gemcs01test.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by quanda on 27/01/2016.
 */
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    private PromotionDao promotionDao;

    @Override
    public void savePromotion(Promotion promotion) {
        promotionDao.savePromotion(promotion);
    }

    @Override
    public List<Promotion> findAllPromotions() {
        return promotionDao.findAllPromotions();
    }

    @Override
    public Promotion findPromotionById(long id) {
        return findPromotionById(id);
    }

    @Override
    public void deletePromotion(long id) {
        promotionDao.deletePromotionById(id);
    }

    @Override
    public void updatePromotion(Promotion promotion) {
        promotionDao.updatePromotion(promotion);
    }
}
