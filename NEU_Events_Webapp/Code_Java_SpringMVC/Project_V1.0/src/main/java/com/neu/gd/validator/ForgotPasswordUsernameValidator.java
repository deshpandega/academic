/**
 * 
 */
package com.neu.gd.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.gd.pojo.LoginPojo;

/**
 * @author GD
 *
 */
@Component
public class ForgotPasswordUsernameValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.equals(ForgotPasswordUsernameValidator.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Email_Blank");
	}
	
}
