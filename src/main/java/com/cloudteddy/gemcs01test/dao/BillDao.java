package com.cloudteddy.gemcs01test.dao;

import com.cloudteddy.gemcs01test.model.Bill;
import com.cloudteddy.gemcs01test.model.Product;

import java.util.List;

/**
 * Created by kimtung on 1/20/16.
 */
public interface BillDao {

    void saveBill(Bill bill);

    List<Bill> findAllBills();

    Bill findBillById(long id);

    void deleteBill(long id);

    void updateBill(Product product);

}
