package org.ncu.healthcare.service;

import org.ncu.healthcare.dao.MedicalRecordDAO;
import org.ncu.healthcare.entity.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

    @Autowired
    private MedicalRecordDAO medicalRecordDAO;

    @Override
    public MedicalRecord getMedicalRecordById(int recordId) {
        return medicalRecordDAO.getMedicalRecordById(recordId);
    }

    @Override
    public MedicalRecord saveOrUpdateMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordDAO.saveOrUpdateMedicalRecord(medicalRecord);
    }

    @Override
    public void deleteMedicalRecord(int recordId) {
        medicalRecordDAO.deleteMedicalRecord(recordId);
    }

    @Override
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordDAO.getAllMedicalRecords();
    }
}
