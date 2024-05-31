package org.ncu.healthcare.service;

import org.ncu.healthcare.dao.DeliveryDAO;
import org.ncu.healthcare.entity.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryDAO deliveryDAO;

    @Override
    public Delivery getDeliveryById(int deliveryId) {
        return deliveryDAO.getDeliveryById(deliveryId);
    }

    @Override
    public Delivery saveOrUpdateDelivery(Delivery delivery) {
        return deliveryDAO.saveOrUpdateDelivery(delivery);
    }

    @Override
    public void deleteDelivery(int deliveryId) {
        deliveryDAO.deleteDelivery(deliveryId);
    }

    @Override
    public List<Delivery> getAllDeliveries() {
        return deliveryDAO.getAllDeliveries();
    }
}
