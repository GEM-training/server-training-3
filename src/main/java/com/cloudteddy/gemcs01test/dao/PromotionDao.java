package com.cloudteddy.gemcs01test.dao;

import com.cloudteddy.gemcs01test.model.Promotion;

import java.util.List;

/**
 * Created by kimtung on 1/20/16.
 */
public interface PromotionDao {

    void savePromotion(Promotion promotion);

    List<Promotion> findAllPromotions();

    Promotion findPromotionById(long id);

    void deletePromotion(long id);

    void updatePromotion(Promotion promotion);

}
