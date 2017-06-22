package iit.cs445.validators;

import iit.cs445.models.users.User;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


@Component
@PropertySource({"classpath:validation.properties"})
public class UserFormValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.userForm.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.userForm.lastName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userForm.password");
        if (user.getFirstName() == null) {
            Logger.getLogger(UserFormValidator.class.getName()).log(Level.INFO, "First name null");
            errors.rejectValue("firstName", "NotEmpty.userForm.firstName");
        }
        if (user.getLastName() == null) {
            Logger.getLogger(UserFormValidator.class.getName()).log(Level.INFO, "Last name null");
            errors.rejectValue("lastName", "NotEmpty.userForm.lastName");
        }
        if (user.getEmail() == null) {
            Logger.getLogger(UserFormValidator.class.getName()).log(Level.INFO, "Email null");
            errors.rejectValue("email", "NotEmpty.userForm.email");
        }
        if (user.getPassword() == null) {
            Logger.getLogger(UserFormValidator.class.getName()).log(Level.INFO, "Password null");
            errors.rejectValue("password", "NotEmpty.userForm.password");
        }
        Date now = new Date();
        user.setCreationTime(now);
        user.setModificationTime(now);
    }

}