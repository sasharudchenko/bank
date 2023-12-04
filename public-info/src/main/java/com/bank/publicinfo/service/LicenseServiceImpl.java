package com.bank.publicinfo.service;

import com.bank.publicinfo.exception.LicenseNotFoundException;
import com.bank.publicinfo.model.License;
import com.bank.publicinfo.repositories.LicenseRepository;
import com.bank.publicinfo.validator.ValidationBankDetailsService;
import com.bank.publicinfo.validator.ValidationLicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LicenseServiceImpl implements LicenseService {
    private final LicenseRepository licenseRepository;
    private final ValidationLicenseService validationLicenseService;

    @Transactional
    @Override
    public License saveLicense(License license) {
        License license1 = new License();
        if (validationLicenseService.isValidLicense(license)) {
            license1 = licenseRepository.save(license);
        } else {
            validationLicenseService.isValidLicense(license);
        }
        return license1;
    }

    @Override
    public License getLicense(long id) {
        return licenseRepository.findById(id).orElseThrow(() ->
                new LicenseNotFoundException("License с  ID " + id + " не существует"));
    }

    @Override
    public List<License> allLicense() {
        return licenseRepository.findAll();
    }

    @Transactional
    @Override
    public void updateLicense(License license, long id) {
        License licenseBD = licenseRepository.findById(id).orElseThrow(() ->
                new LicenseNotFoundException("License с  ID " + id + " не существует"));
        licenseBD.setPhoto(license.getPhoto());
        if (validationLicenseService.isValidLicense(license)) {
            licenseRepository.save(license);
        } else {
            validationLicenseService.isValidLicense(license);
        }
    }

    @Transactional
    @Override
    public void deleteLicense(long id) {
        if (licenseRepository.findById(id).isPresent()) {
            licenseRepository.deleteById(id);
        } else {
            throw new LicenseNotFoundException("License с  ID " + id + " не существует");
        }

    }
}
