package com.loginregistration.loginregistration.validator;

import com.loginregistration.loginregistration.models.Show;
import com.loginregistration.loginregistration.models.User;
import com.loginregistration.loginregistration.services.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ShowValidator implements Validator {
    private final UserService userService;

    public ShowValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Show show = (Show) o;
        if (userService.findShowByTitle(show.getTitle()) != null)
            errors.rejectValue("title", "Unique");
    }
}
