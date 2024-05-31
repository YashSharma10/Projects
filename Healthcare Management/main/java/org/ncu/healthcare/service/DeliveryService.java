package org.ncu.healthcare.service;

import java.util.List;

import org.ncu.healthcare.entity.Delivery;

public interface DeliveryService {
    Delivery getDeliveryById(int deliveryId);
    Delivery saveOrUpdateDelivery(Delivery delivery);
    void deleteDelivery(int deliveryId);
    List<Delivery> getAllDeliveries();
}
