package com.cloudteddy.gemcs01test.service.impl;

import com.cloudteddy.gemcs01test.dao.DealerDao;
import com.cloudteddy.gemcs01test.model.Dealer;
import com.cloudteddy.gemcs01test.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kimtung on 1/18/16.
 */
@Service("dealerService")
@Transactional
public class DealerServiceImpl implements DealerService {

    @Autowired
    private DealerDao dealerDao;

    @Override
    public void saveDealer(Dealer dealer) {
        dealerDao.saveDealer(dealer);
    }

    @Override
    public List<Dealer> getAllDealer() {
        return dealerDao.findAllDealers();
    }

    @Override
    public void DeleteDealerById(long id) {
        dealerDao.deleteDealerById(id);
    }

    @Override
    public Dealer findDealerById(long id) {
        return dealerDao.findDealerById(id);
    }

    @Override
    public void updateDealer(Dealer dealer) {
        dealerDao.updateDealer(dealer);
    }

}
