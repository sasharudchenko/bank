package com.bank.publicinfo.exception;

public class CertificateNotFoundException extends RuntimeException{
    public CertificateNotFoundException(String message) {
        super(message);
    }
}