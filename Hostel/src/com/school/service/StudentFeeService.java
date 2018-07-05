package com.school.service;

import com.school.pojo.HostelFee;
import com.school.pojo.Student;
import com.school.pojo.User;

public interface StudentFeeService {

	Student getStudent(Integer studentSequence, User user);

	void saveHostelFee(HostelFee hostelfee, User user);

}
