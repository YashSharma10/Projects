package org.ncu.healthcare.service;

import java.util.List;

import org.ncu.healthcare.dao.PatientDAO;
import org.ncu.healthcare.entity.Appointment;
import org.ncu.healthcare.entity.MedicalRecord;
import org.ncu.healthcare.entity.Patient;
import org.ncu.healthcare.entity.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
    private PatientDAO patientDAO;

    @Override
    @Transactional
    public Patient getPatientById(int patientId) {
        return patientDAO.getPatientById(patientId);
    }

    @Override
    @Transactional
    public Patient saveOrUpdatePatient(Patient patient) {
        return patientDAO.saveOrUpdatePatient(patient);
    }

    @Override
    @Transactional
    public void deletePatient(int patientId) {
        patientDAO.deletePatient(patientId);
    }

    @Override
    @Transactional
    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }

    @Override
    @Transactional
    public void bookAppointment(int patientId, Appointment appointment) {
        patientDAO.bookAppointment(patientId, appointment);
    }

    @Override
    @Transactional
    public void addPrescription(int patientId, Prescription prescription) {
        patientDAO.addPrescription(patientId, prescription);
    }

    @Override
    @Transactional
    public List<MedicalRecord> getMedicalRecords(int patientId) {
        return patientDAO.getMedicalRecords(patientId);
    }

}
