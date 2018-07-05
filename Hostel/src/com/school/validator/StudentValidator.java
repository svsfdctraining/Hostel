package com.school.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.school.bean.StudentBean;
import com.school.pojo.Student;

public class StudentValidator implements Validator{

	@Override
	public boolean supports(Class<?> c) {
		
		return Student.class.isAssignableFrom(c);
	}

	@Override
	public void validate(Object studentobj, Errors errors) {
		
		StudentBean student = (StudentBean)studentobj;
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date d = null;
		if(student.getDob() != null){
		try {
			
			d = format.parse(student.getDob());
			student.getStudent().setBirthDate(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
		
		ValidationUtils.rejectIfEmpty(errors, "student.firstname", "student.firstname.required");
		ValidationUtils.rejectIfEmpty(errors, "student.lastname", "student.lastname.required");
		ValidationUtils.rejectIfEmpty(errors, "student.admissionNo", "student.admissionnum.required");
		if(student.getStudent().getBirthDate()==null)
		errors.reject("student.birthDate", "student.birthdate.empty");
		if("".equals(student.getStudent().getReligion()))
		errors.reject("student.religion", "student.religion.empty");
		if("".equals(student.getStudent().getCaste()))
		errors.reject("student.caste", "student.caste.empty");
		if("".equals(student.getStudent().getCastename()))
			errors.reject("student.castename", "student.castename.empty");
		ValidationUtils.rejectIfEmpty(errors, "student.parentName", "student.parent.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "student.mobile", "Student.parent.mobile");
		
		ValidationUtils.rejectIfEmpty(errors, "student.occupation", "parent.occupation");
		ValidationUtils.rejectIfEmpty(errors, "student.presentAddress", "present.address.empty");
		ValidationUtils.rejectIfEmpty(errors, "student.premanentAddress", "permanent.address.empty");
		ValidationUtils.rejectIfEmpty(errors, "student.prevschool", "student.prev.school");
		//errors.reject("student.prevsStudClass", "prev.class.invalid");
		ValidationUtils.rejectIfEmpty(errors, "student.prevsReleaveReason", "prev.release.reason");
			ValidationUtils.rejectIfEmpty(errors, "student.prevconduct", "prev.conduct.required");
		
		
		
		
	}

}
