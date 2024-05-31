package org.ncu.healthcare.service;

import org.ncu.healthcare.dao.DoctorDAO;
import org.ncu.healthcare.entity.Doctor;
import org.ncu.healthcare.entity.MedicalRecord;
import org.ncu.healthcare.entity.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorDAO doctorDAO;

    @Override
    @Transactional
    public Doctor getDoctorById(int doctorId) {
        return doctorDAO.getDoctorById(doctorId);
    }

    @Override
    @Transactional
    public Doctor saveOrUpdateDoctor(Doctor doctor) {
        return doctorDAO.saveOrUpdateDoctor(doctor);
    }

    @Override
    @Transactional
    public void deleteDoctor(int doctorId) {
        doctorDAO.deleteDoctor(doctorId);
    }

    @Override
    @Transactional
    public List<Doctor> getAllDoctors() {
        return doctorDAO.getAllDoctors();
    }

    @Override
    @Transactional
    public void manageAppointments(int doctorId) {
        doctorDAO.manageAppointments(doctorId);
    }

    @Override
    @Transactional
    public List<MedicalRecord> viewPatientMedicalHistory(int patientId) {
        return doctorDAO.viewPatientMedicalHistory(patientId);
    }

    @Override
    @Transactional
    public void prescribeMedications(int doctorId, Prescription prescription) {
        doctorDAO.prescribeMedications(doctorId, prescription);
    }
}
