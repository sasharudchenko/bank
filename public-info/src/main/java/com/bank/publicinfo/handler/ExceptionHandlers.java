package com.bank.publicinfo.handler;

import com.bank.publicinfo.exception.*;
import com.bank.publicinfo.model.Certificate;
import com.bank.publicinfo.model.License;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j(topic = "ExceptionHandlers")
@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handlerValidationException(ValidationException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ATMNotFoundException.class)
    public ResponseEntity<Object> handlerATMNotFoundException(ATMNotFoundException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BankDetailsNotFoundException.class)
    public ResponseEntity<Object> handlerBankDetailsNotFoundException(BankDetailsNotFoundException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BranchNotFoundException.class)
    public ResponseEntity<Object> handlerBranchNotFoundException(BranchNotFoundException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CertificateNotFoundException.class)
    public ResponseEntity<Object> handlerCertificateNotFoundException(CertificateNotFoundException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LicenseNotFoundException.class)
    public ResponseEntity<Object> handlerLicenseNotFoundException(LicenseNotFoundException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<Object> handlerJsonProcessingException(JsonProcessingException ex) {
        log.error(ex.getMessage());
        return  new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
