package com.bank.publicinfo.controllers;

import com.bank.publicinfo.dto.LicenseDTO;
import com.bank.publicinfo.mapstruct.LicenseMapper;
import com.bank.publicinfo.model.License;
import com.bank.publicinfo.service.LicenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/license")
@RequiredArgsConstructor
@Tag(name = "Лицензия", description = "Методы для работы с лицензией")

public class LicenseRestController {

    private final LicenseService licenseService;
    private final LicenseMapper licenseMapper;


    @PostMapping()
    @Operation(summary = "Добавление данных")
    public ResponseEntity<HttpStatus> save(@RequestBody @Valid LicenseDTO licenseDTO) {

        License license = licenseService.saveLicense(licenseMapper.licenseDTOToLicense(licenseDTO));
        return new ResponseEntity(license, HttpStatus.OK);
    }



    @GetMapping("/{id}")
    @Operation(summary = "Данные лицензии по ID")
    public ResponseEntity<License> getById(@PathVariable("id") Long id) {

        return new ResponseEntity<>(licenseService.getLicense(id), HttpStatus.OK);
    }
    @PatchMapping("/update/{id}")
    @Operation(summary = "Обновление данных лицензии по ID")
    public ResponseEntity<HttpStatus> update(@RequestBody @Valid LicenseDTO licenseDTO,
            @PathVariable("id") Long id) {
        licenseService.updateLicense(licenseMapper
                .licenseDTOToLicense(licenseDTO), id);
        return ResponseEntity.ok(HttpStatus.OK) ;
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Удаление данных лицензии")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        licenseService.deleteLicense(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/all")
    @Operation(summary = "Данные всех лицензий")
    public ResponseEntity<List<License>> all() {
        return new ResponseEntity<>(licenseService.allLicense(), HttpStatus.OK);
    }

}
