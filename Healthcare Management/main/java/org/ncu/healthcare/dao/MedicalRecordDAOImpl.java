package org.ncu.healthcare.dao;

import java.util.List;

import org.ncu.healthcare.entity.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class MedicalRecordDAOImpl implements MedicalRecordDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public MedicalRecord getMedicalRecordById(int recordId) {
        return entityManager.find(MedicalRecord.class, recordId);
    }

    @Override
    @Transactional
    public MedicalRecord saveOrUpdateMedicalRecord(MedicalRecord medicalRecord) {
        return entityManager.merge(medicalRecord);
    }

    @Override
    @Transactional
    public void deleteMedicalRecord(int recordId) {
        MedicalRecord medicalRecord = entityManager.find(MedicalRecord.class, recordId);
        if (medicalRecord != null) {
            entityManager.remove(medicalRecord);
        }
    }

    @Override
    @Transactional
    public List<MedicalRecord> getAllMedicalRecords() {
        return entityManager.createQuery("SELECT m FROM MedicalRecord m", MedicalRecord.class).getResultList();
    }
}

