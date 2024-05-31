package org.ncu.healthcare.service;

import org.ncu.healthcare.dao.InventoryDAO;
import org.ncu.healthcare.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryDAO inventoryDAO;

    @Override
    @Transactional
    public Inventory getInventoryById(int inventoryId) {
        return inventoryDAO.getInventoryById(inventoryId);
    }

    @Override
    @Transactional
    public Inventory saveOrUpdateInventory(Inventory inventory) {
        return inventoryDAO.saveOrUpdateInventory(inventory);
    }

    @Override
    @Transactional
    public void deleteInventory(int inventoryId) {
        inventoryDAO.deleteInventory(inventoryId);
    }

    @Override
    @Transactional
    public List<Inventory> getAllInventories() {
        return inventoryDAO.getAllInventories();
    }
}
