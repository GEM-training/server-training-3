package com.cloudteddy.gemcs01test.service;

import com.cloudteddy.gemcs01test.model.Bill;
import com.cloudteddy.gemcs01test.model.Product;

import java.util.List;

/**
 * Created by quanda on 27/01/2016.
 */
public interface BillService {

    void saveBill(Bill bill);

    List<Bill> findAllBills();

    Bill findBillById(long id);

    void deleteBillById(long id);

    void updateBill(Product product);
}
