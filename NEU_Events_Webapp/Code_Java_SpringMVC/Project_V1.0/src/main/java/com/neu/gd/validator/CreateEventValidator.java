/**
 * 
 */
package com.neu.gd.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.neu.gd.pojo.EventPojo;

/**
 * @author GD
 *
 */
@Component
public class CreateEventValidator implements Validator {

	 
	private static final String IMAGE_PATTERN = "([^\\s\\(.*?\\)]+(\\.(?i)(jpg|png|gif|bmp|JPG|PNG|GIF|BMP))$)";
	
	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class clazz) {
		// TODO Auto-generated method stub
		return clazz.equals(EventPojo.class);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		EventPojo event = (EventPojo) target;
		System.out.println("event date--->"+event.getEventDate());
		if(null==event.getEventDate()){
			errors.rejectValue("eventDate", "Event_Date_Blank");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eventName", "Event_Name_Blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eventDescription", "Event_Description_Blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eventTime", "Event_Time_Blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "eventDate", "Event_Date_Blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressLine1", "Event_AddressLine1_Blank");
		
		Pattern imagePattern = Pattern.compile(IMAGE_PATTERN);
		Matcher patternMatcher;
		MultipartFile eventPhoto;
		
		if(null!=event.getEventPhoto()){
			eventPhoto=event.getEventPhoto();
			patternMatcher = imagePattern.matcher(eventPhoto.getOriginalFilename());
			
//			if(0 == eventPhoto.getSize()) {
//				errors.rejectValue("eventPhoto","Event_File_Empty");
//			}
			if(!patternMatcher.matches()) {
				errors.rejectValue("eventPhoto","Invalid_Format");
			}

			if(10485760 < eventPhoto.getSize()) {
				errors.rejectValue("eventPhoto","Invalid_File_Size"); 
			}
		}		
	}
}
