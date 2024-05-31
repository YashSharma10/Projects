package org.ncu.healthcare.service;

import org.ncu.healthcare.dao.MedicationDAO;
import org.ncu.healthcare.entity.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService {

    @Autowired
    private MedicationDAO medicationDAO;

    @Override
    public Medication getMedicationById(int medicationId) {
        return medicationDAO.getMedicationById(medicationId);
    }

    @Override
    public Medication saveOrUpdateMedication(Medication medication) {
        return medicationDAO.saveOrUpdateMedication(medication);
    }

    @Override
    public void deleteMedication(int medicationId) {
        medicationDAO.deleteMedication(medicationId);
    }

    @Override
    public List<Medication> getAllMedications() {
        return medicationDAO.getAllMedications();
    }
}
