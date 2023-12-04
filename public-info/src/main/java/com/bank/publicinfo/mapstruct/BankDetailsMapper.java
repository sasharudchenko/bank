package com.bank.publicinfo.mapstruct;

import com.bank.publicinfo.dto.BankDetailsDTO;
import com.bank.publicinfo.model.BankDetails;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Mapper
@Component
public interface BankDetailsMapper {
    BankDetails bankDetailsDTOToBankDetails(BankDetailsDTO bankDetailsDTO);

}
