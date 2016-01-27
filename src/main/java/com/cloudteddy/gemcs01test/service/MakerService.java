package com.cloudteddy.gemcs01test.service;

import com.cloudteddy.gemcs01test.model.Maker;

import java.util.List;

/**
 * Created by quanda on 27/01/2016.
 */
public interface MakerService {

    void saveMaker(Maker maker);

    List<Maker> findAllMakers();

    Maker findMakerById(long id);

    void deleteMakerById(long id);

    void updateMaker(Maker maker);
}
