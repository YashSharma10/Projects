package org.ncu.healthcare.controller;

import java.util.List;

import org.ncu.healthcare.dao.DoctorDAO;
import org.ncu.healthcare.entity.Doctor;
import org.ncu.healthcare.entity.MedicalRecord;
import org.ncu.healthcare.entity.Prescription;
import org.ncu.healthcare.entity.User;
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
@RequestMapping("/api/doctors")
public class DoctorController {

	 @Autowired
	    private DoctorDAO doctorDAO;

	    @Autowired
	    private UserService userService;

	    @PostMapping
	    public Doctor saveDoctor(@RequestBody Doctor doctor) {
	    	  if (doctor.getUser() == null) {
	              throw new IllegalArgumentException("User is required for creating a doctor.");
	          }
	          User user = userService.findById(doctor.getUser().getUserId());
	          if (user == null) {
	              throw new IllegalArgumentException("User with ID " + doctor.getUser().getUserId() + " does not exist.");
	          }
	          doctor.setUser(user);
	          return doctorDAO.saveOrUpdateDoctor(doctor);
	    }
	    
	    @GetMapping("/{doctorId}")
	    public Doctor getDoctorById(@PathVariable int doctorId) {
	        return doctorDAO.getDoctorById(doctorId);
	    }


	    @PutMapping
	    public Doctor updateDoctor(@RequestBody Doctor doctor) {
	        return doctorDAO.saveOrUpdateDoctor(doctor);
	    }

	    @DeleteMapping("/{doctorId}")
	    public void deleteDoctor(@PathVariable int doctorId) {
	        doctorDAO.deleteDoctor(doctorId);
	    }

	    @GetMapping
	    public List<Doctor> getAllDoctors() {
	        return doctorDAO.getAllDoctors();
	    }
	    
	    
	    // Manage Appointments for Doctor
	    @PostMapping("/{doctorId}/appointments/manage")
	    public void manageAppointmentsForDoctor(@PathVariable int doctorId) {
	        doctorDAO.manageAppointments(doctorId);
	    }

	    // View Patient Medical History for Doctor
	    @GetMapping("/patients/{patientId}/medicalHistory")
	    public List<MedicalRecord> viewPatientMedicalHistoryForDoctor(@PathVariable int patientId) {
	        return doctorDAO.viewPatientMedicalHistory(patientId);
	    }

	    // Prescribe Medications for Doctor
	    @PostMapping("/{doctorId}/prescriptions")
	    public void prescribeMedicationsForDoctor(@PathVariable int doctorId, @RequestBody Prescription prescription) {
	        doctorDAO.prescribeMedications(doctorId, prescription);
    }
}
