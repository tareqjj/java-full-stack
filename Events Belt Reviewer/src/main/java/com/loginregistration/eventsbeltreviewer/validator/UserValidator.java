package com.loginregistration.eventsbeltreviewer.validator;

import com.loginregistration.eventsbeltreviewer.modles.User;
import com.loginregistration.eventsbeltreviewer.services.EventsUsersServices;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    private final EventsUsersServices eventsUsersServices;

    public UserValidator(EventsUsersServices eventsUsersServices) {
        this.eventsUsersServices = eventsUsersServices;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (!user.getPasswordConfirmation().equals(user.getPassword()))
            errors.rejectValue("passwordConfirmation", "Match");
        if (eventsUsersServices.findByEmail(user.getEmail()) != null)
            errors.rejectValue("email", "Registered");
    }
}
