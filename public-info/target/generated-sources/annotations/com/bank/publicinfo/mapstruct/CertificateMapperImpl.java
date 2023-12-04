package com.bank.publicinfo.mapstruct;

import com.bank.publicinfo.dto.CertificateDTO;
import com.bank.publicinfo.model.Certificate;
import java.util.Arrays;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-03T01:37:58+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class CertificateMapperImpl implements CertificateMapper {

    @Override
    public Certificate certificateDTOToCertificate(CertificateDTO certificateDTO) {
        if ( certificateDTO == null ) {
            return null;
        }

        Certificate certificate = new Certificate();

        byte[] photo = certificateDTO.getPhoto();
        if ( photo != null ) {
            certificate.setPhoto( Arrays.copyOf( photo, photo.length ) );
        }
        certificate.setBankDetails( certificateDTO.getBankDetails() );

        return certificate;
    }
}
