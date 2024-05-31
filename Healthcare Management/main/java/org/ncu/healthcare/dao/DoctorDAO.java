package org.ncu.healthcare.dao;

import java.util.List;

import org.ncu.healthcare.entity.Doctor;
import org.ncu.healthcare.entity.MedicalRecord;
import org.ncu.healthcare.entity.Prescription;

public interface DoctorDAO {
	Doctor getDoctorById(int doctorId);

	Doctor saveOrUpdateDoctor(Doctor doctor);

	void deleteDoctor(int doctorId);

	List<Doctor> getAllDoctors();
	
	
	
	// Manage Appointments
    void manageAppointments(int doctorId);
    
    // View Patient Medical History
    List<MedicalRecord> viewPatientMedicalHistory(int patientId);
    
    // Prescribe Medications
    void prescribeMedications(int doctorId, Prescription prescription);
}