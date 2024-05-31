package org.ncu.healthcare.dao;

import java.util.List;

import org.ncu.healthcare.entity.Medication;

public interface MedicationDAO {
    Medication getMedicationById(int medicationId);
    Medication saveOrUpdateMedication(Medication medication);
    void deleteMedication(int medicationId);
    List<Medication> getAllMedications();
}
