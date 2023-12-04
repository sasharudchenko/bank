package com.bank.publicinfo.service;

import com.bank.publicinfo.exception.ATMNotFoundException;
import com.bank.publicinfo.mapstruct.ATMMapper;
import com.bank.publicinfo.model.ATM;
import com.bank.publicinfo.repositories.ATMRepository;
import com.bank.publicinfo.validator.ValidationATMService;
import com.bank.publicinfo.validator.ValidationBranchService;
import liquibase.pro.packaged.A;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ATMServiceImpl implements ATMService {

    private final ATMRepository atmRepository;
    private final ValidationATMService validationATMService;

    @Override
    public ATM saveATM(ATM atm) {
        ATM atm1 = new ATM() ;
        if (validationATMService.isValidATM(atm)) {
           atm1 = atmRepository.save(atm);
        } else {
             validationATMService.isValidATM(atm);
        }
        return atm1;
    }


    @Override
    public ATM getATM(long id) {

        return atmRepository.findById(id).orElseThrow(() -> new ATMNotFoundException("ATM c ID " + id +
                " не существует"));
    }

    @Override
    public List<ATM> allATM() {
        return atmRepository.findAll();
    }

    @Override
    public void updateATM(ATM atm, long id) {

        ATM atmBD = atmRepository.findById(id).orElseThrow(() -> new ATMNotFoundException("ATM c ID " + id +
                " не существует"));
        atmBD.setAddress(atm.getAddress());
        atmBD.setStartOfWork(atm.getStartOfWork());
        atmBD.setEndOfWork(atm.getEndOfWork());
        atmBD.setAllHours(atm.isAllHours());
        if (validationATMService.isValidATM(atm)) {
            atmRepository.save(atmBD);
        } else {
            validationATMService.isValidATM(atm);
        }
    }

    @Override
    public void deleteATM(long id) {
        if (atmRepository.findById(id).isPresent()) {
            atmRepository.deleteById(id);
        } else {
            throw new ATMNotFoundException("ATM c ID " + id +
                    " не существует");
        }
    }
}
