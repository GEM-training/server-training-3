package com.cloudteddy.springhibernate.service;

import com.cloudteddy.springhibernate.model.Dealer;

import java.util.List;

/**
 * Created by kimtung on 1/18/16.
 */
public interface DealerService {

    void saveDealer(Dealer dealer);

    List<Dealer> getAllDealer();

    void DeleteDealerById(long id);

    Dealer findDealerById(long id);

    void updateDealer(Dealer dealer);
}
