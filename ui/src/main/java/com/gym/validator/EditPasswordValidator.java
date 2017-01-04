package com.gym.validator;

import com.gym.transientObject.PasswordHolder;
import com.gym.objects.User;
import com.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EditPasswordValidator implements Validator {

    @Autowired
    UserService userService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public boolean supports(Class<?> aClass) {
        return PasswordHolder.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmNewPassword", "error.password.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPassword", "error.password.empty");

        PasswordHolder passwordHolder = (PasswordHolder)o;

        if(!passwordHolder.getPassword().isEmpty()
                && !passwordHolder.getNewPassword().isEmpty()
                && !passwordHolder.getConfirmNewPassword().isEmpty()) {

            User currentUser = userService.readByLogin(passwordHolder.getLogin());

            if(!passwordHolder.getNewPassword().equals(passwordHolder.getConfirmNewPassword())) {
                errors.rejectValue("password", "error.password.passwords_not_equal");
            }
            if(passwordHolder.getConfirmNewPassword().equals(passwordHolder.getNewPassword()) &&
                    !(encoder.matches(passwordHolder.getPassword(), currentUser.getPassword()))) {
                errors.rejectValue("previousPassword", "error.password.previous_password_incorrect");
            }
        }
    }
}
