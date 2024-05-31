package org.ncu.healthcare.service;

import org.ncu.healthcare.dao.PrescriptionDAO;
import org.ncu.healthcare.entity.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionDAO prescriptionDAO;

    @Override
    public Prescription getPrescriptionById(int prescriptionId) {
        return prescriptionDAO.getPrescriptionById(prescriptionId);
    }

    @Override
    public Prescription saveOrUpdatePrescription(Prescription prescription) {
        return prescriptionDAO.saveOrUpdatePrescription(prescription);
    }

    @Override
    public void deletePrescription(int prescriptionId) {
        prescriptionDAO.deletePrescription(prescriptionId);
    }

    @Override
    public List<Prescription> getAllPrescriptions() {
        return prescriptionDAO.getAllPrescriptions();
    }
}
