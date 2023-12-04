package com.bank.publicinfo.exception;

public class BankDetailsNotFoundException extends RuntimeException{
    public BankDetailsNotFoundException(String message) {
        super(message);
    }
}
