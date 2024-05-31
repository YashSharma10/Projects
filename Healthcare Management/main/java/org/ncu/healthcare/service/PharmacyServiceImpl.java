
package org.ncu.healthcare.service;

import org.ncu.healthcare.dao.PharmacyDAO;
import org.ncu.healthcare.entity.Pharmacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class PharmacyServiceImpl implements PharmacyService {

    @Autowired
    private PharmacyDAO pharmacyDAO;

    @Override
    @Transactional
    public Pharmacy getPharmacyById(int pharmacyId) {
        return pharmacyDAO.getPharmacyById(pharmacyId);
    }

    @Override
    @Transactional
    public Pharmacy saveOrUpdatePharmacy(Pharmacy pharmacy) {
        return pharmacyDAO.saveOrUpdatePharmacy(pharmacy);
    }

    @Override
    @Transactional
    public void deletePharmacy(int pharmacyId) {
        pharmacyDAO.deletePharmacy(pharmacyId);
    }

    @Override
    @Transactional
    public List<Pharmacy> getAllPharmacies() {
        return pharmacyDAO.getAllPharmacies();
    }
}
