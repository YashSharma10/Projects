package org.ncu.healthcare.controller;

import org.ncu.healthcare.entity.Prescription;
import org.ncu.healthcare.service.PrescriptionService;
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
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping
    public Prescription createPrescription(@RequestBody Prescription prescription) {
        return prescriptionService.saveOrUpdatePrescription(prescription);
    }

    @GetMapping("/{prescriptionId}")
    public Prescription getPrescriptionById(@PathVariable int prescriptionId) {
        return prescriptionService.getPrescriptionById(prescriptionId);
    }

    @PutMapping("/{prescriptionId}")
    public Prescription updatePrescription(@PathVariable int prescriptionId, @RequestBody Prescription prescription) {
       
        return prescriptionService.saveOrUpdatePrescription(prescription);
    }

    @DeleteMapping("/{prescriptionId}")
    public String deletePrescription(@PathVariable int prescriptionId) {
        prescriptionService.deletePrescription(prescriptionId);
        return "Prescription with ID " + prescriptionId + " deleted successfully";
    }
}