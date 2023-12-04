package com.bank.publicinfo.mapstruct;

import com.bank.publicinfo.dto.ATMDTO;
import com.bank.publicinfo.model.ATM;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;


@Service
@Mapper
public interface ATMMapper {
    ATM ATMDTOToATM(ATMDTO atmdto);
}
