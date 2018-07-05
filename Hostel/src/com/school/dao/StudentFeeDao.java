package com.school.dao;

import com.school.pojo.Student;

public interface StudentFeeDao {

	Student getStudent(Integer studentSequence, int orgId);

}
