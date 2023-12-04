package com.bank.publicinfo.mapstruct;

import com.bank.publicinfo.dto.LicenseDTO;
import com.bank.publicinfo.model.License;
import java.util.Arrays;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-03T01:37:58+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class LicenseMapperImpl implements LicenseMapper {

    @Override
    public License licenseDTOToLicense(LicenseDTO licenseDTO) {
        if ( licenseDTO == null ) {
            return null;
        }

        License license = new License();

        byte[] photo = licenseDTO.getPhoto();
        if ( photo != null ) {
            license.setPhoto( Arrays.copyOf( photo, photo.length ) );
        }
        license.setBankDetails( licenseDTO.getBankDetails() );

        return license;
    }
}
