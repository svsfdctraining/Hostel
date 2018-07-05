package com.school.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.school.pojo.CollegeFee;

public class CollegeFeeValidator implements Validator{
	@Override
	public boolean supports(Class<?> c) {
		
		return CollegeFee.class.isAssignableFrom(c);
	}

	@Override
	public void validate(Object collegefee, Errors errors) {
	
		
		ValidationUtils.rejectIfEmpty(errors, "collegeFee.paymentType", "payment.type.required");
		ValidationUtils.rejectIfEmpty(errors, "collegeFee.description", "payment.description.required");
		ValidationUtils.rejectIfEmpty(errors, "collegeFee.currentPay", "payment.amount.required");
	}

}
