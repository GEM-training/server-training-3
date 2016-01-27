package com.cloudteddy.gemcs01test.dao.impl;

import com.cloudteddy.gemcs01test.dao.AbstractDao;
import com.cloudteddy.gemcs01test.dao.InventoryDao;
import com.cloudteddy.gemcs01test.dao.ProductDao;
import com.cloudteddy.gemcs01test.model.Bill;
import com.cloudteddy.gemcs01test.model.Inventory;
import com.cloudteddy.gemcs01test.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kimtung on 1/20/16.
 */
@Repository("inventory")
@Transactional
public class InventoryDaoImpl extends AbstractDao implements InventoryDao {

    @Override
    public void saveInventory(Inventory inventory) {
        persist(inventory);
    }

    @Override
    public List<Inventory> findAllInventories() {
        Criteria criteria = getSession().createCriteria(Inventory.class);
        return criteria.list();
    }

    @Override
    public Inventory findInventoryById(long id) {
        Criteria criteria = getSession().createCriteria(Inventory.class);
        criteria.add(Restrictions.eq("id", id));
        return (Inventory) criteria.uniqueResult();
    }

    @Override
    public void deleteInventoryById(long id) {
        Object persistentObject = getSession().load(Bill.class, id);
        getSession().delete(persistentObject);
    }

    @Override
    public void updateInventory(Inventory inventory) {
        getSession().update(inventory);
    }
}
