package com.cloudteddy.gemcs01test.service.impl;

import com.cloudteddy.gemcs01test.dao.BillDao;
import com.cloudteddy.gemcs01test.model.Bill;
import com.cloudteddy.gemcs01test.model.Product;
import com.cloudteddy.gemcs01test.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by quanda on 27/01/2016.
 */
public class BillServiceImpl implements BillService {

    @Autowired
    private BillDao billDao;

    @Override
    public void saveBill(Bill bill) {
        billDao.saveBill(bill);
    }

    @Override
    public List<Bill> findAllBills() {
        return billDao.findAllBills();
    }

    @Override
    public Bill findBillById(long id) {
        return billDao.findBillById(id);
    }

    @Override
    public void deleteBillById(long id) {
        billDao.deleteBillById(id);
    }

    @Override
    public void updateBill(Product product) {
        billDao.updateBill(product);
    }
}
