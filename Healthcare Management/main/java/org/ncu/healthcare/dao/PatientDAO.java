package org.ncu.healthcare.dao;

import java.util.List;

import org.ncu.healthcare.entity.Appointment;
import org.ncu.healthcare.entity.MedicalRecord;
import org.ncu.healthcare.entity.Patient;
import org.ncu.healthcare.entity.Prescription;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDAO {
    Patient getPatientById(int patientId);
    Patient saveOrUpdatePatient(Patient patient);
    void deletePatient(int patientId);
    List<Patient> getAllPatients();
    
    
    // Book Appointment
    void bookAppointment(int patientId, Appointment appointment);
    
    // Manage Prescriptions
    void addPrescription(int patientId, Prescription prescription);
    
    // Access Medical Records
    List<MedicalRecord> getMedicalRecords(int patientId);
}