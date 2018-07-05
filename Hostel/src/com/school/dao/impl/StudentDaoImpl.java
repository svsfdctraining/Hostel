package com.school.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.school.bean.StudentBean;
import com.school.dao.StudentDao;
import com.school.pojo.Document;
import com.school.pojo.OrganizationMedium;
import com.school.pojo.Student;
import com.school.pojo.StudentClass;
import com.school.pojo.User;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveStudent(StudentBean studentbean, User user) {

		
		Student student = studentbean.getStudent();
		student.setOrgId(user.getOrgId());
		student.setCreatedby(user.getEmail());
		student.setCreateddate(new Date());
		if(student.getCollegeBlanceFee() ==null){
		student.setCollegeBlanceFee(student.getCollegeFee());
		student.setCollegePaidFee(new Long(0));
		}
		if(student.getStudentType().equals("Hostler") && (student.getHostelBalanceFee() == null || student.getHostelBalanceFee() ==0)){
			student.setHostelBalanceFee(student.getHostelFee());
			student.setHostelPaidfee(new Long(0));
		}
		if (studentbean.getPhoto() != null
				&& studentbean.getPhoto().getContent().length != 0 && !StringUtils.isEmpty(student.getPhotoname())) {
			Document photo = studentbean.getPhoto();
			sessionFactory.getCurrentSession().save(photo);
			student.setPhotoid(photo.getRecid());
		}
		if (studentbean.getTc() != null
				&& studentbean.getTc().getContent().length != 0 && !StringUtils.isEmpty(student.getTcname())) {
			Document tc = studentbean.getTc();
			sessionFactory.getCurrentSession().save(tc);
			student.setTcid(tc.getRecid());
		}

		if (studentbean.getCc() != null
				&& studentbean.getCc().getContent().length != 0 && !StringUtils.isEmpty(student.getCcname())) {
			Document cc = studentbean.getCc();
			sessionFactory.getCurrentSession().save(cc);
			student.setCcid(cc.getRecid());
		}

		if (studentbean.getSc() != null
				&& studentbean.getSc().getContent().length != 0 && !StringUtils.isEmpty(student.getScname())) {
			Document sc = studentbean.getSc();
			sessionFactory.getCurrentSession().save(sc);
			student.setScid(sc.getRecid());
		}
		if (studentbean.getMm() != null
				&& studentbean.getMm().getContent().length != 0 && !StringUtils.isEmpty(student.getMmname())) {
			Document mm = studentbean.getMm();
			sessionFactory.getCurrentSession().save(mm);
			student.setMmid(mm.getRecid());
		}
		// Receive documents
		if (studentbean.getRectc() != null
				&& studentbean.getRectc().getContent().length != 0 && !StringUtils.isEmpty(student.getRectcname())) {
			Document rtc = studentbean.getRectc();
			sessionFactory.getCurrentSession().save(rtc);
			student.setRectcid(rtc.getRecid());
		}

		if (studentbean.getReccc() != null
				&& studentbean.getReccc().getContent().length != 0 && !StringUtils.isEmpty(student.getRecccname())) {
			Document rcc = studentbean.getReccc();
			sessionFactory.getCurrentSession().save(rcc);
			student.setRecccid(rcc.getRecid());
		}

		if (studentbean.getRecsc() != null
				&& studentbean.getRecsc().getContent().length != 0 && !StringUtils.isEmpty(student.getRecscname())) {
			Document rsc = studentbean.getRecsc();
			sessionFactory.getCurrentSession().save(rsc);
			student.setRecscid(rsc.getRecid());
		}
		if (studentbean.getRecmm() != null
				&& studentbean.getRecmm().getContent().length != 0 && !StringUtils.isEmpty(student.getRecmmname())) {
			Document rmm = studentbean.getRecmm();
			sessionFactory.getCurrentSession().save(rmm);
			student.setRecmmid(rmm.getRecid());
		}

		sessionFactory.getCurrentSession().saveOrUpdate(
				studentbean.getStudent());

	}

	@Override
	public StudentClass getclassfee(String stclass, User user) {

		List<StudentClass> sclasses = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from StudentClass where classValue=:stcls and organization=:orgid")
				.setParameter("stcls", stclass)
				.setParameter("orgid", user.getOrgId()).list();
		return sclasses.get(0);
	}

	@Override
	public Long getAdmissionNum(User user) {

		List<Long> results = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select max(admissionNo)+1 from Student where orgId=:orgid")
				.setParameter("orgid", user.getOrgId()).list();
		if (!results.isEmpty() && results.get(0) != null) {
			
			return results.get(0);
		}
		return new Long(1);
	}

	@Override
	public Long getStudentRollNum(StudentBean studentbean, User user) {

		List<Long> results = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select max(rollNo)+1 from Student where stclass=:stcls and section=:sectn and medium=:mdm and orgId=:orgid")
				.setParameter("stcls", studentbean.getStudent().getStclass())
				.setParameter("sectn", studentbean.getStudent().getSection())
				.setParameter("mdm", studentbean.getStudent().getMedium())
				.setParameter("orgid", user.getOrgId()).list();
		if (!results.isEmpty() && results.get(0) != null) {
			return results.get(0);
		}
		return new Long(1);
	}
	
	@Override
	public List<Student> getSearchResults(StudentBean studentbean, User user) {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Student.class).add(Restrictions.eq("academicyear", studentbean.getAcademicyear()))
				.add(Restrictions.eq("orgId", user.getOrgId()));
		if(!StringUtils.isEmpty(studentbean.getStclass())){
			criteria.add(Restrictions.eq("stclass", studentbean.getStclass()));
		}
		if(!StringUtils.isEmpty(studentbean.getSection())){
			criteria.add(Restrictions.eq("section", studentbean.getSection()));
		}
		
		if(!StringUtils.isEmpty(studentbean.getMedium())){
			criteria.add(Restrictions.eq("medium", studentbean.getMedium()));
		}
		
		if(!StringUtils.isEmpty(studentbean.getName())){
			criteria.add(Restrictions.like("firstname", studentbean.getName()));
		}
		if(!StringUtils.isEmpty(studentbean.getFname())){
			criteria.add(Restrictions.like("parentName", studentbean.getFname()));
		}
		
		return criteria.list();
	}
	
	@Override
	public Student getStudent(Integer studentSeq) {
		
		List<Student> slist = sessionFactory.getCurrentSession().createCriteria(Student.class).add(Restrictions.eq("studentSeq", studentSeq)).list();
		if(!slist.isEmpty()){
			return slist.get(0);
		}
		return null;
	}
	
	@Override
	public Document getDocumentContent(Long photoid, String type) {
		
		List<Document> docs = sessionFactory.getCurrentSession().createCriteria(Document.class).add(Restrictions.eq("recid", photoid)).list();
		if(!docs.isEmpty()){
			return docs.get(0);
		}
		return null;
	}
	
	@Override
	public void saveUploadedStudents(List<Student> students) {

		for(Student s:students){
			sessionFactory.getCurrentSession().saveOrUpdate(s);
		}
	}
	
	@Override
	public int getCourseYears(String stclass,int orgid) {
		
		StudentClass sc = (StudentClass) sessionFactory.getCurrentSession().createCriteria(StudentClass.class).add(Restrictions.eq("classDesc", stclass)).add(Restrictions.eq("status", "Active")).add(Restrictions.eq("organization", orgid)).list().get(0);
		return sc.getDurationYears();
	}
	
	@Override
	public List<OrganizationMedium> getMediums(int orgId) {
		
		return sessionFactory.getCurrentSession().createCriteria(OrganizationMedium.class).add(Restrictions.eq("organization", orgId)).add(Restrictions.eq("status", "Active")).list();
	}
}
