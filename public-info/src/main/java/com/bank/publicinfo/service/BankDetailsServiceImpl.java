package com.bank.publicinfo.service;

import com.bank.publicinfo.exception.BankDetailsNotFoundException;
import com.bank.publicinfo.mapstruct.BankDetailsMapper;
import com.bank.publicinfo.model.BankDetails;
import com.bank.publicinfo.repositories.BankDetailsRepository;
import com.bank.publicinfo.validator.ValidationBankDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankDetailsServiceImpl implements BankDetailsService {
    private final BankDetailsRepository bankDetailsRepository;
    private final BankDetailsMapper bankDetailsMapper;
    private final ValidationBankDetailsService validationBankDetailsService;




    @Transactional
    @Override
    public BankDetails saveBankDetails(BankDetails bankDetails) {
        BankDetails bankDetails1 = new BankDetails();
        if (validationBankDetailsService.isValidBankDetails(bankDetails)) {
             bankDetails1 = bankDetailsRepository.save(bankDetails);

        } else {
            validationBankDetailsService.isValidBankDetails(bankDetails);
        }
        return bankDetails1;
    }

    @Override
    public BankDetails getBankDetails(Long id) {
        return bankDetailsRepository.findById(id).orElseThrow(() ->
                new BankDetailsNotFoundException("BankDetails с ID " +  id + " не существует"));
    }

    @Override
    public List<BankDetails> allBankDetails() {
        return bankDetailsRepository.findAll();
    }

    @Transactional
    @Override
    public void updateBankDetails(BankDetails bankDetails, Long id) {
        BankDetails bankDetailsBD = bankDetailsRepository.findById(id).orElseThrow(() ->
                new BankDetailsNotFoundException("BankDetails с ID " +  id + " не существует"));
        if (bankDetailsBD.getBik() != bankDetails.getBik()) {
            bankDetailsBD.setBik(bankDetails.getBik());
        }
        if (bankDetailsBD.getInn() != bankDetails.getInn()) {
            bankDetailsBD.setInn(bankDetails.getInn());
        }

        if (bankDetailsBD.getKpp() != bankDetails.getKpp()) {
            bankDetailsBD.setKpp(bankDetails.getKpp());
        }
        if (bankDetailsBD.getCorAccount() != bankDetails.getCorAccount()) {

            bankDetailsBD.setCorAccount(bankDetails.getCorAccount());
        }

        bankDetailsBD.setCity(bankDetails.getCity());
        bankDetailsBD.setJointStockCompany(bankDetails.getJointStockCompany());
        bankDetailsBD.setName(bankDetails.getName());

        if (validationBankDetailsService.isValidBankDetails(bankDetails)) {
            bankDetailsRepository.save(bankDetailsBD);

        } else {
            validationBankDetailsService.isValidBankDetails(bankDetails);
        }
    }

    @Transactional
    @Override
    public void deleteBankDetails(long id) {
        if (bankDetailsRepository.findById(id).isPresent()) {
            bankDetailsRepository.deleteById(id);
        } else {
            throw new BankDetailsNotFoundException("BankDetails с ID " +  id + " не существует");
        }

    }


}
