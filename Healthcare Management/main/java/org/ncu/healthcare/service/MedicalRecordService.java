package org.ncu.healthcare.service;

import org.ncu.healthcare.entity.MedicalRecord;

import java.util.List;

public interface MedicalRecordService {
    MedicalRecord getMedicalRecordById(int recordId);
    MedicalRecord saveOrUpdateMedicalRecord(MedicalRecord medicalRecord);
    void deleteMedicalRecord(int recordId);
    List<MedicalRecord> getAllMedicalRecords();
}
