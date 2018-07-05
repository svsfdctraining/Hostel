package com.school.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.dao.StudentFeeDao;
import com.school.pojo.HostelFee;
import com.school.pojo.Student;
import com.school.pojo.User;
import com.school.service.StudentFeeService;

@Service("studentFeeService")
@Transactional(readOnly=false)
public class StudentFeeServiceImpl implements StudentFeeService{

	@Autowired
	private StudentFeeDao studentFeeDao;
	
	@Override
	public Student getStudent(Integer studentSequence, User user) {
		
		return studentFeeDao.getStudent(studentSequence,user.getOrgId());
	}
	
	@Override
	public void saveHostelFee(HostelFee hostelfee, User user) {
	hostelfee.setTrnasctionDate(new Date());
	hostelfee.setBalanceFee(hostelfee.getPrevBalance() - hostelfee.getCurrentPay());
	
		
	}
}
