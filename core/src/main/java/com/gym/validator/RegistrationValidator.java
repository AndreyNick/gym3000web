package com.gym.validator;

import com.gym.objects.User;
import com.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.NoSuchElementException;

public class RegistrationValidator implements Validator {

    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        User readByLoginUser = null;
        try{
            readByLoginUser = userService.readByLogin(user.getLogin());
        } catch (NoSuchElementException ignored) {
        }
        if(readByLoginUser != null) errors.rejectValue("login", "error.login.alreadyExists");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "error.login.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password.empty");




    }
}
