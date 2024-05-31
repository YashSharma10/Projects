package org.ncu.healthcare.dao;
import java.util.List;

import org.ncu.healthcare.entity.Appointment;
import org.ncu.healthcare.entity.Doctor;
import org.ncu.healthcare.entity.MedicalRecord;
import org.ncu.healthcare.entity.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class DoctorDAOImpl implements DoctorDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public Doctor getDoctorById(int doctorId) {
        return entityManager.find(Doctor.class, doctorId);
    }

    @Override
    @Transactional
    public Doctor saveOrUpdateDoctor(Doctor doctor) {
        return entityManager.merge(doctor);
    }

    @Override
    @Transactional
    public void deleteDoctor(int doctorId) {
        Doctor doctor = entityManager.find(Doctor.class, doctorId);
        if (doctor != null) {
            entityManager.remove(doctor);
        }
    }

    @Override
    @Transactional
    public List<Doctor> getAllDoctors() {
        return entityManager.createQuery("SELECT d FROM Doctor d", Doctor.class).getResultList();
    }
    
    
    
    @Override
    @Transactional
    public void manageAppointments(int doctorId) {
        Doctor doctor = entityManager.find(Doctor.class, doctorId);
        if (doctor != null) {
            // Retrieve the list of appointments for the doctor
            List<Appointment> appointments = doctor.getAppointments();
            
            // Implement appointment management logic here
            // For example, you can iterate through the appointments and perform actions
            for (Appointment appointment : appointments) {
                // Here, you can update or cancel appointments as needed
                // For demonstration purposes, let's just print out the appointment details
                System.out.println("Appointment ID: " + appointment.getAppointmentId());
                System.out.println("Date & Time: " + appointment.getAppointmentDateTime());
                System.out.println("Patient: " + appointment.getPatient().getUser().getUsername());
                // Add more actions as per your requirements
            }
        }
    }

    @Override
    @Transactional
    public List<MedicalRecord> viewPatientMedicalHistory(int patientId) {
        // Create a query to retrieve medical records for the specified patient ID
        TypedQuery<MedicalRecord> query = entityManager.createQuery(
            "SELECT m FROM MedicalRecord m WHERE m.patient.patientId = :patientId", MedicalRecord.class);
        query.setParameter("patientId", patientId);
        
        // Execute the query and return the list of medical records
        return query.getResultList();
    }

    @Override
    @Transactional
    public void prescribeMedications(int doctorId, Prescription prescription) {
        Doctor doctor = entityManager.find(Doctor.class, doctorId);
        if (doctor != null) {
            doctor.getPrescriptions().add(prescription);
            entityManager.merge(doctor);
        }
    }
}
