package com.cloudteddy.springhibernate.dao;

import com.cloudteddy.springhibernate.model.Dealer;

import java.util.List;

/**
 * Created by kimtung on 1/18/16.
 */
public interface DealerDao {

    void saveDealer(Dealer dealer);

    List<Dealer> findAllDealers();

    void deleteDealerById(long id);

    Dealer findDealerById(long id);

    void updateDealer(Dealer dealer);
}
