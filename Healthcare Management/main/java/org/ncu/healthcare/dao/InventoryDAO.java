package org.ncu.healthcare.dao;

import java.util.List;

import org.ncu.healthcare.entity.Inventory;

public interface InventoryDAO {
    Inventory getInventoryById(int inventoryId);
    Inventory saveOrUpdateInventory(Inventory inventory);
    void deleteInventory(int inventoryId);
    List<Inventory> getAllInventories();
}
