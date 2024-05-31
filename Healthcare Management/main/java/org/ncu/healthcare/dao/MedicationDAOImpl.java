package org.ncu.healthcare.dao;

import java.util.List;

import org.ncu.healthcare.entity.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class MedicationDAOImpl implements MedicationDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public Medication getMedicationById(int medicationId) {
        return entityManager.find(Medication.class, medicationId);
    }

    @Override
    @Transactional
    public Medication saveOrUpdateMedication(Medication medication) {
        return entityManager.merge(medication);
    }

    @Override
    @Transactional
    public void deleteMedication(int medicationId) {
        Medication medication = entityManager.find(Medication.class, medicationId);
        if (medication != null) {
            entityManager.remove(medication);
        }
    }

    @Override
    @Transactional
    public List<Medication> getAllMedications() {
        return entityManager.createQuery("SELECT m FROM Medication m", Medication.class).getResultList();
    }
}
