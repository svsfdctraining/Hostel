package com.school.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.school.bean.StudentClassBean;
import com.school.pojo.OrganizationMedium;
import com.school.pojo.StudentClass;
import com.school.pojo.StudentClassSection;
import com.school.pojo.User;
import com.school.service.AdminService;
import com.school.service.StudentService;
import com.school.validator.StudentClassValidator;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="class/add", method=RequestMethod.GET)
	public ModelAndView addclass(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("admin/addclass");
		mv.addObject("mediums",studentService.getMediums((User) request.getSession().getAttribute("user")) );
		mv.addObject("class",new StudentClass());
		return mv;
	}
	
	@RequestMapping(value="class/save", method=RequestMethod.POST)
	public ModelAndView saveclass(@ModelAttribute("class") StudentClass studentclass, BindingResult result,SessionStatus status,HttpServletRequest request){

		User user = (User) request.getSession().getAttribute("user");
		new StudentClassValidator().validate(studentclass, result);
		if(result.hasErrors()){
			return new ModelAndView("admin/addclass");
		}/*
		if(studentclass.getClassDesc().toUpperCase().startsWith("P")){
			studentclass.setClassValue(-3);
		}else
		if(studentclass.getClassDesc().toUpperCase().startsWith("N")){
			studentclass.setClassValue(-2);
		}else
		if(studentclass.getClassDesc().toUpperCase().startsWith("L")){
			studentclass.setClassValue(-1);
		}else if(studentclass.getClassDesc().toUpperCase().startsWith("U")){
			studentclass.setClassValue(0);
		}else{
			try{
				int i = Integer.parseInt(studentclass.getClassDesc());
				studentclass.setClassValue(i);
			}catch (Exception e) {
				return new ModelAndView("error");
			}
		}*/
		studentclass.setOrganization(user.getOrgId());
		studentclass.setStatus("Active");
		adminService.saveclass(studentclass,(User)request.getSession().getAttribute("user"));
		ModelAndView mv = new ModelAndView("admin/addclass");
		mv.addObject("message", "Class "+studentclass.getClassDesc()+" added successfully..");
		mv.addObject("class",new StudentClass());
		return mv;
	}
	
	@RequestMapping(value="class/view", method=RequestMethod.GET)
	public ModelAndView viewclass(@ModelAttribute("class") StudentClass studentclass, BindingResult result,SessionStatus status,HttpServletRequest request){
		studentclass.setStatus("Active");
		ModelAndView mv = new ModelAndView("admin/viewclasses");
		mv.addObject("classes",adminService.getAllClasses((User)request.getSession().getAttribute("user")));
		return mv;
	}
	
	@RequestMapping(value="class/edit", method=RequestMethod.GET)
	public ModelAndView editclasses(@ModelAttribute("classbean") StudentClassBean classbean, BindingResult result,SessionStatus status,HttpServletRequest request){
		
		classbean.setClasses(adminService.getAllClasses((User)request.getSession().getAttribute("user")));		
		ModelAndView mv = new ModelAndView("admin/editclasses");
		mv.addObject("classbean",classbean);
		return mv;
	}
	
	@RequestMapping(value="class/saveedited", method=RequestMethod.POST)
	public String saveeditclasses(@ModelAttribute("classbean") StudentClassBean classbean, BindingResult result,SessionStatus status,HttpServletRequest request){
		
		adminService.saveEditedClasses(classbean.getClasses());
		return "redirect:view.htm";
	}
	
	@RequestMapping(value="medium/add", method=RequestMethod.GET)
	public ModelAndView addmedium(){
		ModelAndView mv = new ModelAndView("admin/addmedium");
		mv.addObject("medium",new OrganizationMedium());
		return mv;
	}
	
	
	@RequestMapping(value="medium/save", method=RequestMethod.POST)
	public ModelAndView savemedium(@ModelAttribute("medium") OrganizationMedium organizationMedium, BindingResult result,SessionStatus status,HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		organizationMedium.setOrganization(user.getOrgId());
		organizationMedium.setStatus("Active");	
		adminService.savemedium(organizationMedium,(User)request.getSession().getAttribute("user"));
		ModelAndView mv = new ModelAndView("admin/addmedium");
		mv.addObject("message", "Medium "+organizationMedium.getMediumname()+" added successfully..");
		mv.addObject("medium",new OrganizationMedium());
		return mv;
	}
	
	@RequestMapping(value="medium/edit", method=RequestMethod.GET)
	public ModelAndView editmediums(@ModelAttribute("classbean") StudentClassBean classbean, BindingResult result,SessionStatus status,HttpServletRequest request){
		
		classbean.setMediums(adminService.getAllMediums((User)request.getSession().getAttribute("user")));		
		ModelAndView mv = new ModelAndView("admin/editmedium");
		mv.addObject("classbean",classbean);
		return mv;
	}
	
	@RequestMapping(value="medium/saveedited", method=RequestMethod.POST)
	public String saveeditmediums(@ModelAttribute("classbean") StudentClassBean classbean, BindingResult result,SessionStatus status,HttpServletRequest request){
		
		adminService.saveEditedMediums(classbean.getMediums());
		return "redirect:view.htm";
	}
	
	@RequestMapping(value="medium/view", method=RequestMethod.GET)
	public ModelAndView viewmediums(HttpServletRequest request){
					
		ModelAndView mv = new ModelAndView("admin/viewmediums");
		mv.addObject("mediums",adminService.getAllMediums((User)request.getSession().getAttribute("user")));
		return mv;
	}
	
	@RequestMapping(value="section/add", method=RequestMethod.GET)
	public ModelAndView addsection(@ModelAttribute("section") StudentClassSection section, BindingResult result,SessionStatus status,HttpServletRequest request){
		ModelAndView mv = new ModelAndView("admin/addSection");
		mv.addObject("classes",adminService.getAllClasses((User)request.getSession().getAttribute("user")));
		mv.addObject("section",new StudentClassSection());
		return mv;
	}
	
	@RequestMapping(value="section/loadyers", method=RequestMethod.POST)
	public ModelAndView getcourseyears(@ModelAttribute("section") StudentClassSection section, BindingResult result,SessionStatus status,HttpServletRequest request){
		ModelAndView mv = new ModelAndView("admin/addSection");
		mv.addObject("classes",adminService.getAllClasses((User)request.getSession().getAttribute("user")));
		//mv.addObject("section",new StudentClassSection());
		mv.addObject("years", studentService.getCourseYears(section.getStclass(), (User)request.getSession().getAttribute("user")));
		return mv;
	}
	
	@RequestMapping(value="section/save", method=RequestMethod.POST)
	public ModelAndView savesection(@ModelAttribute("section") StudentClassSection section, BindingResult result,SessionStatus status,HttpServletRequest request){
		
		ModelAndView mv = new ModelAndView("admin/addSection");
		adminService.saveSection(section,(User)request.getSession().getAttribute("user"));
		mv.addObject("message", "Medium"+section.getSectionname()+" has been saved");
		mv.addObject("classes",adminService.getAllClasses((User)request.getSession().getAttribute("user")));
//		mv.addObject("section",new StudentClassSection());
		return mv;
	}
	
	@RequestMapping(value="section/edit", method=RequestMethod.GET)
	public ModelAndView editsection(@ModelAttribute("classbean")StudentClassBean classbean, BindingResult result,SessionStatus status,HttpServletRequest request){
		
		ModelAndView mv = new ModelAndView("admin/editSection");
		classbean.setClasses(adminService.getAllClasses((User)request.getSession().getAttribute("user")));
		mv.addObject("classbean", classbean);
		
//		mv.addObject("section",new StudentClassSection());
		return mv;
	}
	
	@RequestMapping(value="section/getsecdata", method=RequestMethod.POST)
	public ModelAndView getsectiondata(@ModelAttribute("classbean") StudentClassBean classbean, BindingResult result,SessionStatus status,HttpServletRequest request){
		String param = request.getParameter("param");
		ModelAndView mv = new ModelAndView("admin/viewSections");
		classbean.setClasses(adminService.getAllClasses((User)request.getSession().getAttribute("user")));
		List<StudentClassSection> sections =adminService.getAllSections(classbean.getStclass(),(User)request.getSession().getAttribute("user"),true);
		if(sections.isEmpty()){
			mv.addObject("message", "No sections found for Selected class ");
		}
		classbean.setSections(sections);
		mv.addObject("classbean", classbean);
		
		if(param.equals("edit")){
			mv.setViewName("admin/editSection");
		}
//		mv.addObject("section",new StudentClassSection());
		return mv;
	}
	
	@RequestMapping(value="section/saveedited", method=RequestMethod.POST)
	public ModelAndView saveeditedsections(@ModelAttribute("classbean") StudentClassBean classbean, BindingResult result,SessionStatus status,HttpServletRequest request){
		
		ModelAndView mv = new ModelAndView("admin/editSection");
		adminService.saveEditedSections(classbean.getSections());
		classbean.setClasses(adminService.getAllClasses((User)request.getSession().getAttribute("user")));
		mv.addObject("classbean", classbean);
		
//		mv.addObject("section",new StudentClassSection());
		return mv;
	}
	
	@RequestMapping(value="section/view", method=RequestMethod.GET)
	public ModelAndView viewsections(@ModelAttribute("classbean") StudentClassBean classbean, BindingResult result,SessionStatus status,HttpServletRequest request){
		
		ModelAndView mv = new ModelAndView("admin/viewSections");
		classbean.setClasses(adminService.getAllClasses((User)request.getSession().getAttribute("user")));
		mv.addObject("classbean", classbean);
		
//		mv.addObject("section",new StudentClassSection());
		return mv;
	}
}
