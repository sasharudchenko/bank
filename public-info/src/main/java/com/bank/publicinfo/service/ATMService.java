package com.bank.publicinfo.service;

import com.bank.publicinfo.model.ATM;
import com.bank.publicinfo.model.License;

import java.util.List;

public interface ATMService {
    ATM saveATM(ATM atm);
    ATM getATM(long id);
    List<ATM> allATM();
    void updateATM(ATM atm, long id);
    void deleteATM(long id);
}
