package com.bank.publicinfo.validator;

import com.bank.publicinfo.model.Branch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ValidationBranchService {
    private final Validator validator;

    public boolean isValidBranch(Branch branch) throws ValidationException {
        Set<ConstraintViolation<Branch>> constraintViolations = validator.validate(branch);
        if (!constraintViolations.isEmpty()) {
            String errorMessage = constraintViolations.stream()
                    .map(violation -> violation.getPropertyPath() + " " + violation.getMessage())
                    .collect(Collectors.joining(", "));
            throw new ValidationException(errorMessage);
        }
        return true;
    }
}
