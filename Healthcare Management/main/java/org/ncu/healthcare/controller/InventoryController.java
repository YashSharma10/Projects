package org.ncu.healthcare.controller;

import org.ncu.healthcare.entity.Inventory;
import org.ncu.healthcare.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    public Inventory createInventory(@RequestBody Inventory inventory) {
        return inventoryService.saveOrUpdateInventory(inventory);
    }

    @GetMapping("/{inventoryId}")
    public Inventory getInventoryById(@PathVariable int inventoryId) {
        return inventoryService.getInventoryById(inventoryId);
    }

    @PutMapping("/{inventoryId}")
    public Inventory updateInventory(@PathVariable int inventoryId, @RequestBody Inventory inventory) {
        inventory.setInventoryId(inventoryId); // Set the ID from the path variable
        return inventoryService.saveOrUpdateInventory(inventory);
    }

    @DeleteMapping("/{inventoryId}")
    public String deleteInventory(@PathVariable int inventoryId) {
        inventoryService.deleteInventory(inventoryId);
        return "Inventory with ID " + inventoryId + " deleted successfully";
    }

    @GetMapping
    public List<Inventory> getAllInventories() {
        return inventoryService.getAllInventories();
    }
}
