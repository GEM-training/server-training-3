package com.cloudteddy.gemcs01test.dao;

import com.cloudteddy.gemcs01test.model.Inventory;
import com.cloudteddy.gemcs01test.model.Product;

import java.util.List;

/**
 * Created by kimtung on 1/20/16.
 */
public interface InventoryDao {

    void saveInventory(Inventory inventory);

    List<Inventory> findAllInventories();

    Inventory findInventoryById(long id);

    void deleteInventory(long id);

    void updateInventory(Inventory inventory);

}
