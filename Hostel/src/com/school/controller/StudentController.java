package com.school.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.school.pojo.Organization;
import com.school.pojo.Student;
import com.school.pojo.StudentClass;
import com.school.pojo.User;
import com.school.service.AdminService;
import com.school.service.StudentService;
import com.school.service.UtilityService;
import com.school.validator.StudentValidator;

@Controller
@RequestMapping("student")
@SessionAttributes("studentbean")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private UtilityService utilityService;
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public ModelAndView welcome(Model model,HttpServletRequest request){
		
		StudentBean studentbean = new StudentBean();
		User user=(User)request.getSession().getAttribute("user");
		int year = Calendar.getInstance().get(Calendar.YEAR);
		studentbean.setStudent(new Student());
		studentbean.getStudent().setAcademicyear(year+"-"+(year+1));
		ModelAndView mv = new ModelAndView("student/addStudent");
		studentbean.setClasses(adminService.getAllClasses(user));
		studentbean.setMediums(adminService.getAllMediums(user));
		studentbean.setHostels(utilityService.getHostels(String.valueOf(user.getOrgId())));
		studentbean.getStudent().setAdmissionNo(studentService.getAdmissionNo(user));
		studentbean.getStudent().setJoinedDate(new Date());
		model.addAttribute("studentbean", studentbean);
		return mv;
	}
	
	@RequestMapping(value="/load", method=RequestMethod.POST)
	public ModelAndView loaddetails(@ModelAttribute("studentbean") StudentBean studentbean,BindingResult result,HttpServletRequest request){
		ModelAndView mv = new ModelAndView("student/addStudent");
		String param = request.getParameter("param");
		User user = (User)request.getSession().getAttribute("user");
		if(param.equals("years")){
			studentbean.setStudyingYears(studentService.getCourseYears(studentbean.getStudent().getStclass(),user));
		}
		if(param.equals("sections")){
			studentbean.setPrevclasses(studentService.getPrevclasses(studentbean));
			studentbean.getStudent().setSection(null);
			studentbean.getStudent().setMedium(null);
			studentbean.setSections(adminService.getAllSections(studentbean.getStudent().getStclass(),user,false));
			StudentClass sc = studentService.getclassfee(studentbean.getStudent().getStclass(),user);
			studentbean.getStudent().setCollegeFee( new Long(sc.getClassCollegeFee()));
			studentbean.getStudent().setHostelFee(new Long(sc.getClassHostelFee()));
		}
		if(param.equals("searchsections")){
			mv.setViewName("student/studentSearch");
			
			return mv;
		}
		if(param.equals("rollnum")){
			
			studentbean.getStudent().setRollNo(studentService.getStudentRollNum(studentbean,(User)request.getSession().getAttribute("user")));
			if("edit".equals(request.getParameter("operation"))){
				mv.setViewName("student/editStudent");
				return mv;
			}
		}
		return mv;
	}

	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute("studentbean") StudentBean studentbean,BindingResult result,HttpServletRequest request){
		
		ModelAndView mv = new ModelAndView("student/addStudent");
		new StudentValidator().validate(studentbean, result);
		if(result.hasErrors()){
		 mv = new ModelAndView("student/addStudent");
		mv.addObject("message", "Student Record has Errors");	
			return mv;
		}
		
		studentService.saveStudent(studentbean,(User)request.getSession().getAttribute("user"));
		mv.addObject("message","Student has been added successfully..");
		return mv;
	}

	@RequestMapping(value="upload",method=RequestMethod.POST)
	public ModelAndView upload(@ModelAttribute("studentbean") StudentBean studentbean,BindingResult result){
		return new ModelAndView("student/uploadimage");
	}
	
	@RequestMapping(value="uploadphoto", method=RequestMethod.POST)
	public ModelAndView uploadphoto(@ModelAttribute("studentbean") StudentBean studentbean,BindingResult result,HttpServletRequest request){
		ModelAndView mv = new ModelAndView("student/addStudent");
		String path = studentService.saveDocument(studentbean,(User)request.getSession().getAttribute("user"));
		if("photo".equals(studentbean.getUploadtype()))
		studentbean.setPhotopath(path);
		if("edit".equals(studentbean.getAction())){
			mv.setViewName("student/editStudent");
		}
		return mv;
		
	}
	@RequestMapping(value="search", method=RequestMethod.GET)
	public ModelAndView searchstudents(Model model,HttpServletRequest request){
		StudentBean studentbean = new StudentBean();
		studentbean.setOperation(request.getParameter("operation"));
		ModelAndView mv = new ModelAndView("student/studentSearch");
		User user=(User)request.getSession().getAttribute("user");
		studentbean.setAcademicyears(studentService.getAcademicyears((User)request.getSession().getAttribute("user"),(Organization)request.getSession().getAttribute("organization")));
		studentbean.setClasses(adminService.getAllClasses(user));
		studentbean.setMediums(adminService.getAllMediums(user));
		model.addAttribute("studentbean", studentbean);
		return mv;
		
	}
	
	@RequestMapping(value="searchresults", method=RequestMethod.POST)
	public ModelAndView searchresults(@ModelAttribute("studentbean") StudentBean studentbean,BindingResult result,HttpServletRequest request){
		ModelAndView mv = new ModelAndView("student/studentSearch");
		studentbean.setResults(studentService.getSearchResults(studentbean,(User)request.getSession().getAttribute("user")));
		return mv;
		
	}
	
	@RequestMapping(value="vieworedit", method=RequestMethod.POST)
	public ModelAndView updateorview(@ModelAttribute("studentbean") StudentBean studentbean,BindingResult result,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		User user=(User)request.getSession().getAttribute("user");
		studentbean.setStudent(studentService.getStudent(studentbean.getStudentSeq()));
		if(studentbean.getStudent().getPhotoid() != null){
		studentbean.setPhotopath(studentService.getDocumentPath(new Long(studentbean.getStudent().getPhotoid())));
		}
		if("search".equals(studentbean.getOperation()) || "InActive".equalsIgnoreCase(studentbean.getStudent().getStatus())){
			mv.setViewName("student/viewStudent");
			return mv;
		}
		studentbean.setStudyingYears(studentService.getCourseYears(studentbean.getStudent().getStclass(),user));
		studentbean.setSections(adminService.getAllSections(studentbean.getStudent().getStclass(),user,false));
		mv.setViewName("student/editStudent");
		return mv;
		
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ModelAndView updateStudent(@ModelAttribute("studentbean") StudentBean studentbean,BindingResult result,HttpServletRequest request){
		
		ModelAndView mv = new ModelAndView("student/editStudent");
		new StudentValidator().validate(studentbean, result);
		if(result.hasErrors()){
			return new ModelAndView("student/editStudent");
		}
		
		studentService.saveStudent(studentbean,(User)request.getSession().getAttribute("user"));
		
		return mv;
	}
	
	@RequestMapping(value="import", method=RequestMethod.GET)
	public ModelAndView importdata(Model model,HttpServletRequest request,HttpServletResponse response){
		
		ModelAndView mv = new ModelAndView("student/fileupload");
		StudentBean studentbean = new StudentBean();
		studentbean.setAcademicyears(studentService.getAcademicyears((User)request.getSession().getAttribute("user"),(Organization)request.getSession().getAttribute("organization")));
		model.addAttribute("studentbean", studentbean);
		
		return mv;
	}
	
	@RequestMapping(value="uploadfile", method=RequestMethod.POST)
	public ModelAndView updload(@ModelAttribute("studentbean") StudentBean studentbean,BindingResult result,HttpServletRequest request){
		
		ModelAndView mv = new ModelAndView("student/fileupload");
		try{
		studentService.uploadFile(studentbean,(User)request.getSession().getAttribute("user"));
		if(!studentbean.isUploadstatus()){
			mv.addObject("message", "Data Upload Failed");
			return mv;
		}
//		studentService.saveUploadedData(studentbean.getUploadresults());
		mv.addObject("message", "Data uploaded successfully");
		}catch (Exception e) {
			mv.addObject("message", "Data Upload Failed");
			return mv;
		}
		
		return mv;
	}
	
	@RequestMapping(value="studentexport",method=RequestMethod.GET)
	public ModelAndView downloadStudents(Model model,HttpServletRequest request,HttpServletResponse response){
		
		StudentBean studentbean = new StudentBean();
		User user=(User)request.getSession().getAttribute("user");
		int year = Calendar.getInstance().get(Calendar.YEAR);
		studentbean.setStudent(new Student());
		studentbean.getStudent().setAcademicyear(year+"-"+(year+1));
		ModelAndView mv = new ModelAndView("student/downloadStudents");
		studentbean.setClasses(adminService.getAllClasses(user));
		studentbean.setMediums(adminService.getAllMediums(user));
		studentbean.setAcademicyears(studentService.getAcademicyears((User)request.getSession().getAttribute("user"),(Organization)request.getSession().getAttribute("organization")));
		studentbean.setSections(adminService.getAllSections(null, (User)request.getSession().getAttribute("user"),true));
		
		model.addAttribute("studentbean", studentbean);
		return mv;
	}
	
	@RequestMapping(value="downloadandexport",method=RequestMethod.POST)
	public void downloadandexport(@ModelAttribute("studentbean") StudentBean studentbean,BindingResult result,HttpServletRequest request,HttpServletResponse response){
		
		String path = studentService.downloadStudents(studentbean,(User)request.getSession().getAttribute("user"));
		  
        // construct the complete absolute path of the file
        File downloadFile = new File(path);
        FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(downloadFile);
			 // get MIME type of the file
	        String mimeType = "application/octet-stream";
	        // set content attributes for the response
	        response.setContentType(mimeType);
	        response.setContentLength((int) downloadFile.length());
	 
	        // set headers for the response
	        String headerKey = "Content-Disposition";
	        String headerValue = String.format("attachment; filename=\"%s\"",
	                downloadFile.getName());
	        response.setHeader(headerKey, headerValue);
	 
	        // get output stream of the response
	        OutputStream outStream = response.getOutputStream();
	 
	        byte[] buffer = new byte[409600];
	        int bytesRead = -1;
	 
	        // write bytes read from the input stream into the output stream
	        while ((bytesRead = inputStream.read(buffer)) != -1) {
	            outStream.write(buffer, 0, bytesRead);
	        }
	 
	        inputStream.close();
	        outStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	@RequestMapping(value="download",method=RequestMethod.POST)
	public void downloadFile(Model model,HttpServletRequest request,HttpServletResponse response){
		String documentid=request.getParameter("documentid");
		String path = studentService.getDocumentPath(new Long(documentid));
		  
        // construct the complete absolute path of the file
        File downloadFile = new File(path);
        FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(downloadFile);
			 // get MIME type of the file
	        String mimeType = "application/octet-stream";
	        // set content attributes for the response
	        response.setContentType(mimeType);
	        response.setContentLength((int) downloadFile.length());
	 
	        // set headers for the response
	        String headerKey = "Content-Disposition";
	        String headerValue = String.format("attachment; filename=\"%s\"",
	                downloadFile.getName());
	        response.setHeader(headerKey, headerValue);
	 
	        // get output stream of the response
	        OutputStream outStream = response.getOutputStream();
	 
	        byte[] buffer = new byte[409600];
	        int bytesRead = -1;
	 
	        // write bytes read from the input stream into the output stream
	        while ((bytesRead = inputStream.read(buffer)) != -1) {
	            outStream.write(buffer, 0, bytesRead);
	        }
	 
	        inputStream.close();
	        outStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
		
	
	
	
}
