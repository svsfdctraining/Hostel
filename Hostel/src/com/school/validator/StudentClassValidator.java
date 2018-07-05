package com.school.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.school.pojo.StudentClass;

public class StudentClassValidator implements Validator{

	@Override
	public boolean supports(Class<?> c) {
		
		return StudentClass.class.isAssignableFrom(c);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		StudentClass sclass = (StudentClass) obj;
		ValidationUtils.rejectIfEmpty(errors, "classDesc", "class.description.empty");
		if(sclass.getClassHostelFee()==0){
			errors.rejectValue("classfee", "class.fee.empty");
		}
		
	}

}
