package org.ncu.healthcare.service;

import org.ncu.healthcare.entity.Inventory;

import java.util.List;

public interface InventoryService {
    Inventory getInventoryById(int inventoryId);

    Inventory saveOrUpdateInventory(Inventory inventory);

    void deleteInventory(int inventoryId);

    List<Inventory> getAllInventories();
}
