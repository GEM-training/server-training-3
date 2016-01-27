package com.cloudteddy.gemcs01test.service;

import com.cloudteddy.gemcs01test.model.Promotion;

import java.util.List;

/**
 * Created by quanda on 27/01/2016.
 */
public interface PromotionService {
    void savePromotion(Promotion promotion);

    List<Promotion> findAllPromotions();

    Promotion findPromotionById(long id);

    void deletePromotion(long id);

    void updatePromotion(Promotion promotion);

}
