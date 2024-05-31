package org.ncu.healthcare.dao;

import java.util.List;

import org.ncu.healthcare.entity.MedicalRecord;

public interface MedicalRecordDAO {
    MedicalRecord getMedicalRecordById(int recordId);
    MedicalRecord saveOrUpdateMedicalRecord(MedicalRecord record);
    void deleteMedicalRecord(int recordId);
    List<MedicalRecord> getAllMedicalRecords();
}
