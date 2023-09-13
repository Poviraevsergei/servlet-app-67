package com.tms.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailEngine implements ConstraintValidator<Email67,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("[A-z0-9]{4,30}@[a-z]{3,5}\\.[a-z]{2,3}");
    }
}
