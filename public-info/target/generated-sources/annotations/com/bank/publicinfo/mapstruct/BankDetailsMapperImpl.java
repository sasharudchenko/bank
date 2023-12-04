package com.bank.publicinfo.mapstruct;

import com.bank.publicinfo.dto.BankDetailsDTO;
import com.bank.publicinfo.model.BankDetails;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-03T01:37:58+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class BankDetailsMapperImpl implements BankDetailsMapper {

    @Override
    public BankDetails bankDetailsDTOToBankDetails(BankDetailsDTO bankDetailsDTO) {
        if ( bankDetailsDTO == null ) {
            return null;
        }

        BankDetails bankDetails = new BankDetails();

        bankDetails.setBik( bankDetailsDTO.getBik() );
        bankDetails.setInn( bankDetailsDTO.getInn() );
        bankDetails.setKpp( bankDetailsDTO.getKpp() );
        bankDetails.setCorAccount( bankDetailsDTO.getCorAccount() );
        bankDetails.setCity( bankDetailsDTO.getCity() );
        bankDetails.setJointStockCompany( bankDetailsDTO.getJointStockCompany() );
        bankDetails.setName( bankDetailsDTO.getName() );
        bankDetails.setLicense( bankDetailsDTO.getLicense() );
        bankDetails.setCertificate( bankDetailsDTO.getCertificate() );

        return bankDetails;
    }
}
