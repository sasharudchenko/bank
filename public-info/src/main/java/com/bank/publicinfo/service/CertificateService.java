package com.bank.publicinfo.service;

import com.bank.publicinfo.model.Certificate;
import com.bank.publicinfo.model.License;

import java.util.List;

public interface CertificateService {
    Certificate saveCertificate(Certificate certificate);
    Certificate getCertificate(long id);
    List<Certificate> allCertificate();
    void updateCertificate(Certificate certificate, long id);
    void deleteCertificate(long id);
}
