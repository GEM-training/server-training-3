package com.cloudteddy.gemcs01test.service.impl;

import com.cloudteddy.gemcs01test.dao.DealerDao;
import com.cloudteddy.gemcs01test.model.Dealer;
import com.cloudteddy.gemcs01test.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kimtung on 1/18/16.
 */
@RestController
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
    public List<Dealer> findAllDealers() {
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
