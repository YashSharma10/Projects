package org.ncu.healthcare.controller;

import org.ncu.healthcare.entity.Delivery;
import org.ncu.healthcare.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping
    public Delivery createDelivery(@RequestBody Delivery delivery) {
        return deliveryService.saveOrUpdateDelivery(delivery);
    }

    @GetMapping("/{deliveryId}")
    public Delivery getDeliveryById(@PathVariable int deliveryId) {
        return deliveryService.getDeliveryById(deliveryId);
    }

    @PutMapping("/{deliveryId}")
    public Delivery updateDelivery(@PathVariable int deliveryId, @RequestBody Delivery delivery) {
        
        return deliveryService.saveOrUpdateDelivery(delivery);
    }

    @DeleteMapping("/{deliveryId}")
    public String deleteDelivery(@PathVariable int deliveryId) {
        deliveryService.deleteDelivery(deliveryId);
        return "Delivery with ID " + deliveryId + " deleted successfully";
    }
}