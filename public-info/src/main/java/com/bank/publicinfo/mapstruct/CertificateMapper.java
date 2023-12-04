package com.bank.publicinfo.mapstruct;

import com.bank.publicinfo.dto.CertificateDTO;
import com.bank.publicinfo.model.Certificate;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface CertificateMapper {
    Certificate certificateDTOToCertificate(CertificateDTO certificateDTO);
}
