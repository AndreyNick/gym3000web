package com.gym.validator;

import com.gym.objects.User;
import com.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EditPasswordValidator implements Validator {

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "error.password.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "previousPassword", "error.password.empty");


        /*if(!user.getPassword().isEmpty()
                && !user.getConfirmPassword().isEmpty()
                && !user.getPreviousPassword().isEmpty()) {

            User currentUser = userService.readByLogin(user.getLogin());


            if(!user.getPassword().equals(user.getConfirmPassword())) {
                errors.rejectValue("password", "error.password.passwords_not_equal");
            }

            if(user.getPassword().equals(user.getConfirmPassword()) &&
                    passwordEncoder.encode(user.getPreviousPassword()).equals(currentUser.getPassword())) {
                errors.rejectValue("previousPassword", "error.password.passwords_not_equal");
            }
        }*/
    }
}
