package com.bank.publicinfo.exception;

public class ATMNotFoundException extends RuntimeException{
    public ATMNotFoundException(String message) {
        super(message);
    }
}
