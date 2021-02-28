package com.springdataone.relationships.services;

import com.springdataone.relationships.models.License;
import com.springdataone.relationships.repositories.LicenseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LicenseService {
    private final LicenseRepository licenseRepository;

    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    public License createLicense(License l){
        License topNumber = licenseRepository.findTopByOrderByNumberDesc();
        int number;
        if (topNumber == null)
            number = 1;
        else {
            number = Integer.parseInt(topNumber.getNumber());
            number++;
        }
        String numberString = String.format("%05d",number);
        l.setNumber(numberString);
        return licenseRepository.save(l);
    }

    public License findLicense(Long id){
        Optional<License> licenseToFind = licenseRepository.findById(id);
        if (licenseToFind.isPresent())
            return licenseToFind.get();
        else
            return null;
    }
}
