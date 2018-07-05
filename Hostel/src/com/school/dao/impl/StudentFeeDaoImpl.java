package com.school.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.school.dao.StudentFeeDao;
import com.school.pojo.Student;

@Repository("studentFeeDao")
public class StudentFeeDaoImpl implements StudentFeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Student getStudent(Integer studentSequence, int orgId) {

		return (Student) sessionFactory.getCurrentSession()
				.createQuery("from Student where studentSeq=:stseq and orgId=:orgid")
				.setParameter("stseq", studentSequence).setParameter("orgid", orgId).list().get(0);

	}
}
