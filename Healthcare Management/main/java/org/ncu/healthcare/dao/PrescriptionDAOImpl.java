package org.ncu.healthcare.dao;

import java.util.List;

import org.ncu.healthcare.entity.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class PrescriptionDAOImpl implements PrescriptionDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public Prescription getPrescriptionById(int prescriptionId) {
        return entityManager.find(Prescription.class, prescriptionId);
    }

    @Override
    @Transactional
    public Prescription saveOrUpdatePrescription(Prescription prescription) {
        return entityManager.merge(prescription);
    }

    @Override
    @Transactional
    public void deletePrescription(int prescriptionId) {
        Prescription prescription = entityManager.find(Prescription.class, prescriptionId);
        if (prescription != null) {
            entityManager.remove(prescription);
        }
    }

    @Override
    @Transactional
    public List<Prescription> getAllPrescriptions() {
        return entityManager.createQuery("SELECT p FROM Prescription p", Prescription.class).getResultList();
    }
}
