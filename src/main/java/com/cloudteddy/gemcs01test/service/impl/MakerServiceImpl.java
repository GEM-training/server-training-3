package com.cloudteddy.gemcs01test.service.impl;

import com.cloudteddy.gemcs01test.dao.MakerDao;
import com.cloudteddy.gemcs01test.model.Maker;
import com.cloudteddy.gemcs01test.service.MakerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by quanda on 27/01/2016.
 */
public class MakerServiceImpl implements MakerService {

    @Autowired
    private MakerDao makerDao;

    @Override
    public void saveMaker(Maker maker) {
        makerDao.saveMaker(maker);
    }

    @Override
    public List<Maker> findAllMakers() {
        return makerDao.findAllMakers();
    }

    @Override
    public Maker findMakerById(long id) {
        return makerDao.findMakerById(id);
    }

    @Override
    public void deleteMakerById(long id) {
        makerDao.deleteMakerById(id);
    }

    @Override
    public void updateMaker(Maker maker) {
        makerDao.updateMaker(maker);
    }
}
