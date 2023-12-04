package com.bank.publicinfo.mapstruct;

import com.bank.publicinfo.dto.ATMDTO;
import com.bank.publicinfo.model.ATM;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-03T01:37:58+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ATMMapperImpl implements ATMMapper {

    @Override
    public ATM ATMDTOToATM(ATMDTO atmdto) {
        if ( atmdto == null ) {
            return null;
        }

        ATM aTM = new ATM();

        aTM.setAddress( atmdto.getAddress() );
        aTM.setStartOfWork( atmdto.getStartOfWork() );
        aTM.setEndOfWork( atmdto.getEndOfWork() );
        aTM.setAllHours( atmdto.isAllHours() );
        aTM.setBranch( atmdto.getBranch() );

        return aTM;
    }
}
