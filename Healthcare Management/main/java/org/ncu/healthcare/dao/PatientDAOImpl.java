package org.ncu.healthcare.dao;

import java.util.Collections;
import java.util.List;

import org.ncu.healthcare.entity.Appointment;
import org.ncu.healthcare.entity.MedicalRecord;
import org.ncu.healthcare.entity.Patient;
import org.ncu.healthcare.entity.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class PatientDAOImpl implements PatientDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public Patient getPatientById(int patientId) {
		return entityManager.find(Patient.class, patientId);
	}

	@Override
	@Transactional
	public Patient saveOrUpdatePatient(Patient patient) {
		return entityManager.merge(patient);
	}

	@Override
	@Transactional
	public void deletePatient(int patientId) {
		Patient patient = entityManager.find(Patient.class, patientId);
		if (patient != null) {
			entityManager.remove(patient);
		}
	}

	@Override
	@Transactional
	public List<Patient> getAllPatients() {
		return entityManager.createQuery("SELECT p FROM Patient p", Patient.class).getResultList();
	}
	
	
	@Override
	@Transactional
	public void bookAppointment(int patientId, Appointment appointment) {
	    Patient patient = entityManager.find(Patient.class, patientId);
	    if (patient != null) {
	        patient.getAppointments().add(appointment);
	        entityManager.merge(patient);
	    }
	}

	@Override
	@Transactional
	public void addPrescription(int patientId, Prescription prescription) {
	    Patient patient = entityManager.find(Patient.class, patientId);
	    if (patient != null) {
	        patient.getPrescriptions().add(prescription);
	        entityManager.merge(patient);
	    }
	}

	@Override
	@Transactional
	public List<MedicalRecord> getMedicalRecords(int patientId) {
	    Patient patient = entityManager.find(Patient.class, patientId);
	    if (patient != null) {
	        return patient.getMedicalRecords();
	    }
	    return Collections.emptyList();
	}
}