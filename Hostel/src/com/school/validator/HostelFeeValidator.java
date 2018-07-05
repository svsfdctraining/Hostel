package com.school.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.school.bean.StudentFeeBean;
import com.school.pojo.HostelFee;

public class HostelFeeValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> c) {
		
		return StudentFeeBean.class.isAssignableFrom(c);
	}

	@Override
	public void validate(Object collegefee, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "hostelfee.paymentType", "payment.type.required");
		ValidationUtils.rejectIfEmpty(errors, "hostelfee.description", "payment.description.required");
		ValidationUtils.rejectIfEmpty(errors, "hostelfee.currentPay", "payment.amount.required");
	}

}
