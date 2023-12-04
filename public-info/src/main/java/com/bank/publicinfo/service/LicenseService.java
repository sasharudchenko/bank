package com.bank.publicinfo.service;

import com.bank.publicinfo.model.BankDetails;
import com.bank.publicinfo.model.License;

import java.util.List;

public interface LicenseService {
    License saveLicense(License license);
    License getLicense(long id);
    List<License> allLicense();
    void updateLicense(License license, long id);
    void deleteLicense(long id);
}
