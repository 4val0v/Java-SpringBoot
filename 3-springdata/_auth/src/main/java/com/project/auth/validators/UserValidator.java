package com.project.auth.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.project.auth.models.User;

@Component
public class UserValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> c) {
		return User.class.equals(c);
		// user instance can be validated with method below
	}
	
	@Override
	public void validate(Object object, Errors errors) {
		User user = (User) object;
		
		if (!user.getPasswordConfirmation().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirmation", "Match");
		}
		
	}

}
