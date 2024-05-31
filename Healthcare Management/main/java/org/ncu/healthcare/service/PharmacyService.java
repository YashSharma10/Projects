package org.ncu.healthcare.service;

import org.ncu.healthcare.entity.Pharmacy;

import java.util.List;

public interface PharmacyService {
    Pharmacy getPharmacyById(int pharmacyId);

    Pharmacy saveOrUpdatePharmacy(Pharmacy pharmacy);

    void deletePharmacy(int pharmacyId);

    List<Pharmacy> getAllPharmacies();
}