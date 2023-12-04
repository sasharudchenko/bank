package com.bank.publicinfo.validator;

import com.bank.publicinfo.exception.ValidationException;
import com.bank.publicinfo.model.License;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class ValidationLicenseService {
    private final Validator validator;


    public boolean isValidLicense(License license) throws ValidationException {

        Set<ConstraintViolation<License>> constraintViolations = validator.validate(license);
        if (!constraintViolations.isEmpty()) {
            String errorMessage = constraintViolations.stream()
                    .map(violation -> violation.getPropertyPath() + " " + violation.getMessage())
                    .collect(Collectors.joining(", "));
            throw new ValidationException(errorMessage);
        }
        return true;
    }
}
