package org.ncu.healthcare.controller;

import org.ncu.healthcare.entity.Medication;
import org.ncu.healthcare.service.MedicationService;
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
@RequestMapping("/api/medications")
public class MedicationController {

    @Autowired
    private MedicationService medicationService;

    @PostMapping
    public Medication createMedication(@RequestBody Medication medication) {
        return medicationService.saveOrUpdateMedication(medication);
    }

    @GetMapping("/{medicationId}")
    public Medication getMedicationById(@PathVariable int medicationId) {
        return medicationService.getMedicationById(medicationId);
    }

    @PutMapping("/{medicationId}")
    public Medication updateMedication(@PathVariable int medicationId, @RequestBody Medication medication) {
       
        return medicationService.saveOrUpdateMedication(medication);
    }

    @DeleteMapping("/{medicationId}")
    public String deleteMedication(@PathVariable int medicationId) {
        medicationService.deleteMedication(medicationId);
        return "Medication with ID " + medicationId + " deleted successfully";
    }
}