package org.ncu.healthcare.controller;

import org.ncu.healthcare.entity.Pharmacy;
import org.ncu.healthcare.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pharmacies")
public class PharmacyController {

    @Autowired
    private PharmacyService pharmacyService;

    @PostMapping
    public Pharmacy createPharmacy(@RequestBody Pharmacy pharmacy) {
        return pharmacyService.saveOrUpdatePharmacy(pharmacy);
    }

    @GetMapping("/{pharmacyId}")
    public Pharmacy getPharmacyById(@PathVariable int pharmacyId) {
        return pharmacyService.getPharmacyById(pharmacyId);
    }

    @PutMapping("/{pharmacyId}")
    public Pharmacy updatePharmacy(@PathVariable int pharmacyId, @RequestBody Pharmacy pharmacy) {
        pharmacy.setPharmacyId(pharmacyId); // Set the ID from the path variable
        return pharmacyService.saveOrUpdatePharmacy(pharmacy);
    }

    @DeleteMapping("/{pharmacyId}")
    public String deletePharmacy(@PathVariable int pharmacyId) {
        pharmacyService.deletePharmacy(pharmacyId);
        return "Pharmacy with ID " + pharmacyId + " deleted successfully";
    }

    @GetMapping
    public List<Pharmacy> getAllPharmacies() {
        return pharmacyService.getAllPharmacies();
    }
}
