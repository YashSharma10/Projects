package org.ncu.healthcare.service;

import org.ncu.healthcare.entity.Doctor;
import org.ncu.healthcare.entity.MedicalRecord;
import org.ncu.healthcare.entity.Prescription;

import java.util.List;

public interface DoctorService {
    Doctor getDoctorById(int doctorId);

    Doctor saveOrUpdateDoctor(Doctor doctor);

    void deleteDoctor(int doctorId);

    List<Doctor> getAllDoctors();

    void manageAppointments(int doctorId);

    List<MedicalRecord> viewPatientMedicalHistory(int patientId);

    void prescribeMedications(int doctorId, Prescription prescription);
}
