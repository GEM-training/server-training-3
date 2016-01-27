package com.cloudteddy.gemcs01test.service;

import com.cloudteddy.gemcs01test.model.Inventory;

import java.util.List;

/**
 * Created by quanda on 27/01/2016.
 */
public interface InventoryService {

    void saveInventory(Inventory inventory);

    List<Inventory> findAllInventories();

    Inventory findInventoryById(long id);

    void deleteInventoryById(long id);

    void updateInventory(Inventory inventory);
}
