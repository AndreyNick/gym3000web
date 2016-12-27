package com.gym.validator;

import com.gym.objects.ProgramTemplate;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProgramTemplateValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return ProgramTemplate.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.test");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.test");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "note", "error.test");
    }
}
