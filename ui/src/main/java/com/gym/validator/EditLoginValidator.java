package com.gym.validator;

import com.gym.objects.User;
import com.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.NoSuchElementException;

public class EditLoginValidator implements Validator {

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
            //this exception means that user doesn't exists
            //and it is positive sign
            //we don't nee to mark this exception somehow
        }
        if(readByLoginUser != null) errors.rejectValue("login", "error.login.alreadyExists");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "error.login.empty");
    }
}
