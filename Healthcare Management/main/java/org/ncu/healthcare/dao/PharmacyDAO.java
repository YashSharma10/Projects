package org.ncu.healthcare.dao;

import java.util.List;

import org.ncu.healthcare.entity.Pharmacy;

public interface PharmacyDAO {
    Pharmacy getPharmacyById(int pharmacyId);
    Pharmacy saveOrUpdatePharmacy(Pharmacy pharmacy);
    void deletePharmacy(int pharmacyId);
    List<Pharmacy> getAllPharmacies();
}
