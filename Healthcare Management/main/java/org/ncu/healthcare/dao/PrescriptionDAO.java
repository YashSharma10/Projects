package org.ncu.healthcare.dao;

import java.util.List;

import org.ncu.healthcare.entity.Prescription;

public interface PrescriptionDAO {
    Prescription getPrescriptionById(int prescriptionId);
    Prescription saveOrUpdatePrescription(Prescription prescription);
    void deletePrescription(int prescriptionId);
    List<Prescription> getAllPrescriptions();
}