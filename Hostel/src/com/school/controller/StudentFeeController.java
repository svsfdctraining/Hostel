package com.school.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.school.bean.StudentBean;
import com.school.bean.StudentFeeBean;
import com.school.pojo.CollegeFee;
import com.school.pojo.HostelFee;
import com.school.pojo.Student;
import com.school.pojo.User;
import com.school.service.StudentFeeService;
import com.school.validator.HostelFeeValidator;

@Controller
@RequestMapping("fee")
@SessionAttributes("studentFeeBean")
public class StudentFeeController {

	@Autowired
	private StudentFeeService studentFeeService;

	@RequestMapping(value = "/payfee", method = RequestMethod.POST)
	public ModelAndView payfee(Model model, HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("fee/payfee");
		User user = (User) request.getSession().getAttribute("user");
		Integer studentSequence = new Integer(request.getParameter("studentid"));
		String feetype = request.getParameter("feetypee");
		StudentFeeBean studentFeeBean = new StudentFeeBean();
		Student student = studentFeeService.getStudent(studentSequence, user);

		if (feetype.equals("collegefee")) {
			CollegeFee cf = new CollegeFee();
			cf.setPrevBalance(student.getCollegeBlanceFee());
			cf.setCourseYear(student.getStudyingyear());
			cf.setStcourse(student.getStclass());
			cf.setOrgid(user.getOrgId());
			cf.setStudentadmissionNo(student.getAdmissionNo());
			cf.setStudentname(student.getFirstname() + " " + student.getLastname());
			studentFeeBean.setCollegeFee(cf);
			studentFeeBean.setFeeType("college");
		}
		if (feetype.equals("hostelfee")) {
			HostelFee hf = new HostelFee();
			hf.setPrevBalance(student.getHostelBalanceFee());
			hf.setCourseYear(student.getStudyingyear());
			hf.setStcourse(student.getStclass());
			hf.setOrgid(user.getOrgId());
			hf.setStudentadmissionNo(student.getHostelAdmissionNo());
			hf.setStudentname(student.getFirstname() + " " + student.getLastname());
			studentFeeBean.setHostelfee(hf);
			studentFeeBean.setFeeType("hostel");
		}
		model.addAttribute("studentFeeBean", studentFeeBean);
		return mv;
	}
	
	@RequestMapping(value="/paystfee", method=RequestMethod.POST)
	public ModelAndView loaddetails(@ModelAttribute("studentFeeBean") StudentFeeBean studentFeeBean,BindingResult result,HttpServletRequest request){
		
		User user = (User) request.getSession().getAttribute("user");
		if(studentFeeBean.getFeeType().equals("hostel")){
			new HostelFeeValidator().validate(studentFeeBean, result);
		}
		if(studentFeeBean.getFeeType().equals("college")){
			new HostelFeeValidator().validate(studentFeeBean, result);
		}
		if(result.hasErrors()){
			return new ModelAndView("fee/payfee");
		}
		
		if(studentFeeBean.getFeeType().equals("hostel")){
		
			studentFeeService.saveHostelFee(studentFeeBean.getHostelfee(),user);
		}
		ModelAndView mv = new ModelAndView("student/addStudent");
		
		return mv;
	}
}
