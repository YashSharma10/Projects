package org.ncu.healthcare.service;

import java.util.List;

import org.ncu.healthcare.entity.Appointment;
import org.ncu.healthcare.entity.MedicalRecord;
import org.ncu.healthcare.entity.Patient;
import org.ncu.healthcare.entity.Prescription;

public interface PatientService {
	
	 Patient getPatientById(int patientId);
	    Patient saveOrUpdatePatient(Patient patient);
	    void deletePatient(int patientId);
	    List<Patient> getAllPatients();
	    void bookAppointment(int patientId, Appointment appointment);
	    void addPrescription(int patientId, Prescription prescription);
	    List<MedicalRecord> getMedicalRecords(int patientId);

}
