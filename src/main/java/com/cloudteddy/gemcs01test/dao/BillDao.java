package com.cloudteddy.gemcs01test.dao;

import com.cloudteddy.gemcs01test.model.Bill;
import com.cloudteddy.gemcs01test.model.Product;

import java.util.List;

/**
 * Created by kimtung on 1/20/16.
 */
public interface BillDao {

    void save(Bill bill);

    List<Bill> findAll();

    Bill findById(long id);

    void delete(long id);

    void update(Product product);

}
