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
public class SignUpValidator implements Validator{
	public boolean supports(Class clazz){
		return clazz.equals(LoginPojo.class);
	}
	
	public void validate(Object obj, Errors errors){
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "person.firstName", "First_Name_Blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "person.lastName", "Last_Name_Blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "neuID", "NUID_Blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "person.phoneNumber", "Phone_Blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Email_Blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Password_Blank");
	}
}
