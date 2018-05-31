package com.oleh.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.oleh.domain.AddUserRequest;

@Component
public class CheckPasswordMatchValidator 
	implements ConstraintValidator<CheckPasswordMatch, AddUserRequest> {

	@Override
	public boolean isValid(AddUserRequest addUserRequest, ConstraintValidatorContext arg1) {
		
		if(addUserRequest.getPassword() == null || addUserRequest.getPasswordConfirmation() == null) {
			return false;
		}
		
		if(addUserRequest.getPassword().equals(addUserRequest.getPasswordConfirmation())) {
			return true;
		}
		
		return false;
	}	
}
