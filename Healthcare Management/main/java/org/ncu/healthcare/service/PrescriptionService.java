package org.ncu.healthcare.service;

import org.ncu.healthcare.entity.Prescription;

import java.util.List;

public interface PrescriptionService {
    Prescription getPrescriptionById(int prescriptionId);
    Prescription saveOrUpdatePrescription(Prescription prescription);
    void deletePrescription(int prescriptionId);
    List<Prescription> getAllPrescriptions();
}
