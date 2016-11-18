package com.gym.validator;

import com.gym.objects.User;
import com.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EditPasswordValidator implements Validator {

    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "error.password.empty");

        //if values are not empty
        User user = (User) o;
        if(!user.getLogin().equals(user.getConfirmPassword())) {
            errors.rejectValue("password", "error.password.passwords_not_equal");
        }

    }
}
