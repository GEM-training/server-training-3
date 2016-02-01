package com.cloudteddy.cs01.dao;

import java.io.Serializable;

/**
 * Created by kimtung on 01/02/16.
 */
public interface AbstractDao<T> {

    Long count();
    T loadById(Serializable id);
    T getById(Serializable id);
    void persit(Object o);
    void update(Object o);
    void delete(Object o);
    void deleteById(Serializable id);
    void refresh(Object o);

}
