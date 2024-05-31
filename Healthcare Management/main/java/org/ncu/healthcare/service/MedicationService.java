package org.ncu.healthcare.service;

import org.ncu.healthcare.entity.Medication;

import java.util.List;

public interface MedicationService {
    Medication getMedicationById(int medicationId);
    Medication saveOrUpdateMedication(Medication medication);
    void deleteMedication(int medicationId);
    List<Medication> getAllMedications();
}
