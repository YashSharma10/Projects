package org.ncu.healthcare.dao;

import java.util.List;

import org.ncu.healthcare.entity.Pharmacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class PharmacyDAOImpl implements PharmacyDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public Pharmacy getPharmacyById(int pharmacyId) {
        return entityManager.find(Pharmacy.class, pharmacyId);
    }

    @Override
    @Transactional
    public Pharmacy saveOrUpdatePharmacy(Pharmacy pharmacy) {
        return entityManager.merge(pharmacy);
    }

    @Override
    @Transactional
    public void deletePharmacy(int pharmacyId) {
        Pharmacy pharmacy = entityManager.find(Pharmacy.class, pharmacyId);
        if (pharmacy != null) {
            entityManager.remove(pharmacy);
        }
    }

    @Override
    @Transactional
    public List<Pharmacy> getAllPharmacies() {
        return entityManager.createQuery("SELECT p FROM Pharmacy p", Pharmacy.class).getResultList();
    }
}

