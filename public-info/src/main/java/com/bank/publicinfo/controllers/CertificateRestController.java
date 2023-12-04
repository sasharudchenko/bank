package com.bank.publicinfo.controllers;

import com.bank.publicinfo.dto.CertificateDTO;
import com.bank.publicinfo.mapstruct.CertificateMapper;
import com.bank.publicinfo.model.Certificate;
import com.bank.publicinfo.service.CertificateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/certificate")
@RequiredArgsConstructor
@Tag(name = "Сертификат", description = "Методы для работы с сертификатом")

public class CertificateRestController {
    private final CertificateService certificateService;
    private final CertificateMapper certificateMapper;

    @PostMapping
    @Operation(summary = "Добавление данных")
    public ResponseEntity<HttpStatus> save(@RequestBody @Valid CertificateDTO certificateDTO) {
        Certificate certificate = certificateService.saveCertificate(certificateMapper.certificateDTOToCertificate(certificateDTO));
        return new ResponseEntity(certificate, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @Operation(summary = "показать сертификат по ID")
    public ResponseEntity<Certificate> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(certificateService.getCertificate(id), HttpStatus.OK);
    }
    @GetMapping("/all")
    @Operation(summary = "показать все сертификаты")
    public ResponseEntity<List<Certificate>> all() {
        return new ResponseEntity<>(certificateService.allCertificate(), HttpStatus.OK);
    }
    @PatchMapping("/update/{id}")
    @Operation(summary = "обновить сертификат по ID")
    public ResponseEntity<HttpStatus> update(@RequestBody @Valid CertificateDTO certificateDTO,
            @PathVariable("id") Long id) {
        certificateService.updateCertificate(certificateMapper.certificateDTOToCertificate(certificateDTO),
                id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Обновить сертификат по ID")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        certificateService.deleteCertificate(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
