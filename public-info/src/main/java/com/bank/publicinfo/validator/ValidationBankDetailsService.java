package com.bank.publicinfo.validator;

import com.bank.publicinfo.exception.ValidationException;
import com.bank.publicinfo.model.BankDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ValidationBankDetailsService {
    private final Validator validator;


    public boolean isValidBankDetails(BankDetails bankDetails) throws ValidationException {

        Set<ConstraintViolation<BankDetails>> constraintViolations = validator.validate(bankDetails);
        if (!constraintViolations.isEmpty()) {
            String errorMessage = constraintViolations.stream()
                    .map(violation -> violation.getPropertyPath() + " " + violation.getMessage())
                    .collect(Collectors.joining(", "));
            throw new ValidationException(errorMessage);
        }
        return true;
    }
}
