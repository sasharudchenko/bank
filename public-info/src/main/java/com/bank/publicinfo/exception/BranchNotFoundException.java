package com.bank.publicinfo.exception;

public class BranchNotFoundException extends RuntimeException{
    public BranchNotFoundException(String message) {
        super(message);
    }
}

