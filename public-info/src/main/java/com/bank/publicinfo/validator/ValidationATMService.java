package com.bank.publicinfo.validator;

import com.bank.publicinfo.exception.ValidationException;
import com.bank.publicinfo.model.ATM;
import com.bank.publicinfo.model.BankDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ValidationATMService {
    private final Validator validator;


    public boolean isValidATM(ATM atm) throws ValidationException {

        Set<ConstraintViolation<ATM>> constraintViolations = validator.validate(atm);
        if (!constraintViolations.isEmpty()) {
            String errorMessage = constraintViolations.stream()
                    .map(violation -> violation.getPropertyPath() + " " + violation.getMessage())
                    .collect(Collectors.joining(", "));
            throw new ValidationException(errorMessage);
        }
        return true;
    }
}
