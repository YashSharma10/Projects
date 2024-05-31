package org.ncu.healthcare.dao;

import java.util.List;

import org.ncu.healthcare.entity.Delivery;

public interface DeliveryDAO {
    Delivery getDeliveryById(int deliveryId);
    Delivery saveOrUpdateDelivery(Delivery delivery);
    void deleteDelivery(int deliveryId);
    List<Delivery> getAllDeliveries();
}