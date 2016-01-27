package com.cloudteddy.gemcs01test.service.impl;

import com.cloudteddy.gemcs01test.dao.InventoryDao;
import com.cloudteddy.gemcs01test.model.Inventory;
import com.cloudteddy.gemcs01test.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by quanda on 27/01/2016.
 */
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryDao inventoryDao;


    @Override
    public void saveInventory(Inventory inventory) {
        inventoryDao.saveInventory(inventory);
    }

    @Override
    public List<Inventory> findAllInventories() {
        return inventoryDao.findAllInventories();
    }

    @Override
    public Inventory findInventoryById(long id) {
        return inventoryDao.findInventoryById(id);
    }

    @Override
    public void deleteInventoryById(long id) {
        inventoryDao.deleteInventoryById(id);
    }

    @Override
    public void updateInventory(Inventory inventory) {
        inventoryDao.updateInventory(inventory);
    }
}
