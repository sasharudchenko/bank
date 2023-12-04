package com.bank.publicinfo.service;

import com.bank.publicinfo.model.BankDetails;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BankDetailsService {
    BankDetails saveBankDetails(BankDetails bankDetails);
    BankDetails getBankDetails(Long id);
    List<BankDetails> allBankDetails();
    void updateBankDetails(BankDetails bankDetails, Long id);
    void deleteBankDetails(long id);
}
