package com.bank.publicinfo.service;

import com.bank.publicinfo.exception.CertificateNotFoundException;
import com.bank.publicinfo.model.Certificate;
import com.bank.publicinfo.repositories.CertificateRepository;
import com.bank.publicinfo.validator.ValidationCertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository certificateRepository;

    private final ValidationCertificateService validationCertificateService;

    @Override
    @Transactional
    public Certificate saveCertificate(Certificate certificate) {
        Certificate certificate1 = new Certificate();
        if (validationCertificateService.isValidCertificate(certificate)){
            certificate1 = certificateRepository.save(certificate);
        } else {
            validationCertificateService.isValidCertificate(certificate);
        }
            return certificate1;
    }

    @Override
    public Certificate getCertificate(long id) {
        return certificateRepository.findById(id).orElseThrow(() ->
                new CertificateNotFoundException("Certificate с ID " + id + " не существует"));
    }

    @Override
    public List<Certificate> allCertificate() {
        return certificateRepository.findAll();
    }

    @Override
    @Transactional
    public void updateCertificate(Certificate certificate, long id) {
        Certificate certificateBD = certificateRepository.findById(id).orElseThrow(() ->
                new CertificateNotFoundException("Certificate с ID " + id + " не существует"));
        certificateBD.setPhoto(certificate.getPhoto());
        if (validationCertificateService.isValidCertificate(certificate)) {
            certificateRepository.save(certificateBD);
        } else {
            validationCertificateService.isValidCertificate(certificate);
        }

    }

    @Override
    @Transactional
    public void deleteCertificate(long id) {
        if (certificateRepository.findById(id).isPresent()) {
            certificateRepository.deleteById(id);
        } else {
            throw new CertificateNotFoundException("Certificate с ID " + id + " не существует");
        }

    }
}
