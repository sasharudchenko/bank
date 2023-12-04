package com.bank.publicinfo.mapstruct;

import com.bank.publicinfo.dto.LicenseDTO;
import com.bank.publicinfo.model.License;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


    @Mapper
    @Component
    public interface LicenseMapper {

        License licenseDTOToLicense(LicenseDTO licenseDTO);

    }

