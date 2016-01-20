package com.cloudteddy.gemcs01test.dao;

import com.cloudteddy.gemcs01test.model.Maker;
import com.cloudteddy.gemcs01test.model.Product;

import java.util.List;

/**
 * Created by kimtung on 1/20/16.
 */
public interface MakerDao {

    void saveMaker(Maker maker);

    List<Maker> findAllMakers();

    Maker findMakerById(long id);

    void deleteMaker(long id);

    void updateMaker(Maker maker);

}
