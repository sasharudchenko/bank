package com.bank.publicinfo.validator;

import com.bank.publicinfo.model.Certificate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ValidationCertificateService {
    private final Validator validator;

    public boolean isValidCertificate(Certificate certificate) throws ValidationException {
        Set<ConstraintViolation<Certificate>> constraintViolations = validator.validate(certificate);
        if (!constraintViolations.isEmpty()) {
            String errorMessage = constraintViolations.stream()
                    .map(violation -> violation.getPropertyPath() + " " + violation.getMessage())
                    .collect(Collectors.joining(", "));
            throw new ValidationException(errorMessage);
        }
        return true;
    }

}
