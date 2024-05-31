package org.ncu.healthcare.controller;

import java.util.List;

import org.ncu.healthcare.entity.Appointment;
import org.ncu.healthcare.entity.MedicalRecord;
import org.ncu.healthcare.entity.Patient;
import org.ncu.healthcare.entity.Prescription;
import org.ncu.healthcare.entity.User;
import org.ncu.healthcare.service.PatientService;
import org.ncu.healthcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private UserService userService;

    @GetMapping("/{patientId}")
    public Patient getPatientById(@PathVariable int patientId) {
        return patientService.getPatientById(patientId);
    }

    @PostMapping
    public Patient savePatient(@RequestBody Patient patient) {
        if (patient.getUser() == null) {
            throw new IllegalArgumentException("User is required for creating a patient.");
        }

        User user = userService.findById(patient.getUser().getUserId());
        if (user == null) {
            throw new IllegalArgumentException("User with ID " + patient.getUser().getUserId() + " does not exist.");
        }

        patient.setUser(user);
        return patientService.saveOrUpdatePatient(patient);
    }

    @PutMapping
    public Patient updatePatient(@RequestBody Patient patient) {
        return patientService.saveOrUpdatePatient(patient);
    }

    @DeleteMapping("/{patientId}")
    public void deletePatient(@PathVariable int patientId) {
        patientService.deletePatient(patientId);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    // Book Appointment for Patient
    @PostMapping("/{patientId}/appointments")
    public void bookAppointmentForPatient(@PathVariable int patientId, @RequestBody Appointment appointment) {
        patientService.bookAppointment(patientId, appointment);
    }

    // Add Prescription for Patient
    @PostMapping("/{patientId}/prescriptions")
    public void addPrescriptionForPatient(@PathVariable int patientId, @RequestBody Prescription prescription) {
        patientService.addPrescription(patientId, prescription);
    }

    // Get Medical Records for Patient
    @GetMapping("/{patientId}/medicalRecords")
    public List<MedicalRecord> getMedicalRecordsForPatient(@PathVariable int patientId) {
        return patientService.getMedicalRecords(patientId);
    }
}
