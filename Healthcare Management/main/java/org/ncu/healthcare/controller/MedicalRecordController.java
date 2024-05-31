package org.ncu.healthcare.controller;

import org.ncu.healthcare.entity.MedicalRecord;
import org.ncu.healthcare.service.MedicalRecordService;
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
@RequestMapping("/api/medicalrecords")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @PostMapping
    public MedicalRecord createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return medicalRecordService.saveOrUpdateMedicalRecord(medicalRecord);
    }

    @GetMapping("/{recordId}")
    public MedicalRecord getMedicalRecordById(@PathVariable int recordId) {
        return medicalRecordService.getMedicalRecordById(recordId);
    }

    @PutMapping("/{recordId}")
    public MedicalRecord updateMedicalRecord(@PathVariable int recordId, @RequestBody MedicalRecord medicalRecord) {
       
        return medicalRecordService.saveOrUpdateMedicalRecord(medicalRecord);
    }

    @DeleteMapping("/{recordId}")
    public String deleteMedicalRecord(@PathVariable int recordId) {
        medicalRecordService.deleteMedicalRecord(recordId);
        return "Medical record with ID " + recordId + " deleted successfully";
    }
}