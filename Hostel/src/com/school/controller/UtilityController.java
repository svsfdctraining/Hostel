package com.school.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.school.bean.HostelBean;
import com.school.bean.StudentClassBean;
import com.school.pojo.Caste;
import com.school.pojo.Hostel;
import com.school.pojo.Organization;
import com.school.pojo.Religion;
import com.school.pojo.UserRole;
import com.school.service.UtilityService;
import com.school.util.OrganizaionUtility;

@Controller
@RequestMapping("util")
public class UtilityController {

	@Autowired
	private UtilityService utilityService;

	@RequestMapping(value = "addcaste", method = RequestMethod.GET)
	public ModelAndView welcome(@ModelAttribute("caste") Caste caste,
			BindingResult result) {

		ModelAndView mv = new ModelAndView("util/addCaste");
//		mv.addObject("castes", utilityService.getAllCastes());
		return mv;
	}

	@RequestMapping(value = "savecaste", method = RequestMethod.POST)
	public ModelAndView saveCaste(@ModelAttribute("caste") Caste caste,
			BindingResult result) {

		boolean flag=utilityService.saveCaste(caste);
		ModelAndView mv = new ModelAndView("util/addCaste");
		if(flag){
		mv.addObject("message", "Caste Added Successfully..");
		}else{
			mv.addObject("message", "Caste "+caste.getCastename()+" Already Exist");
		}
		caste = new Caste();
		mv.addObject("castes", utilityService.getAllCastes());
		return mv;
	}

	@RequestMapping(value = "/castevalidate", method = RequestMethod.POST)
	public @ResponseBody
	String validateCaste(HttpServletRequest request) {
		String caste = request.getParameter("caste");
		return utilityService.validateCaste(caste);
	}

	@RequestMapping(value = "addreligion", method = RequestMethod.GET)
	public ModelAndView addReligion(
			@ModelAttribute("religion") Religion religion, BindingResult result) {

		ModelAndView mv = new ModelAndView("util/addReligion");
		mv.addObject("religions", utilityService.getAllReligions());
		return mv;
	}

	@RequestMapping(value = "savereligion", method = RequestMethod.POST)
	public ModelAndView saveReligion(
			@ModelAttribute("religion") Religion religion, BindingResult result) {

		boolean flag=utilityService.saveReligion(religion);
		ModelAndView mv = new ModelAndView("util/addReligion");
		if(flag){
			mv.addObject("message", "Religion Added Successfully..");	
		}else{
			mv.addObject("message", "Religion "+religion.getReligionname()+" Already Exists.");
		}
		religion = new Religion();
		mv.addObject("religions", utilityService.getAllReligions());
		return mv;
	}
	@RequestMapping(value="addHostel", method=RequestMethod.GET)
	public ModelAndView addhostel(@ModelAttribute("hostel") Hostel hostel,
			BindingResult result){
		ModelAndView mv = new ModelAndView("admin/addHostel");
		mv.addObject("hostel",new Hostel());
		mv.addObject("organizations", utilityService.getAllOrganizations(null));
		return mv;
	}
	
	@RequestMapping(value="savehostel", method=RequestMethod.POST)
	public ModelAndView savehostel(@ModelAttribute("hostel") Hostel hostel,
			BindingResult result){
		ModelAndView mv = new ModelAndView("admin/addHostel");
		mv.addObject("message","Hostel added successfully");
		mv.addObject("organizations", utilityService.getAllOrganizations(null));
		utilityService.saveHostel(hostel);
		return mv;
	}
	@RequestMapping(value="load", method=RequestMethod.POST)
	public ModelAndView load(@ModelAttribute("hostelbean") HostelBean hostelbean,
			BindingResult result, HttpServletRequest request){
		String param = request.getParameter("param");
		ModelAndView mv = null;
		if(param.equals("loadhostels")){
			mv = new ModelAndView("admin/viewhostels");
			mv.addObject("hostels",utilityService.getHostels(request.getParameter("orgId")));
			mv.addObject("status", "read");
		}
		if(param.equals("edithostel")){
			mv = new ModelAndView("admin/editHostel");
			mv.addObject("hostel", utilityService.getHostel(request.getParameter("hostelname")));
		}
		mv.addObject("organizations", utilityService.getAllOrganizations(null));
		mv.addObject("hostelbean", hostelbean);
		return mv;
	}
	
	@RequestMapping(value="viewhostel", method=RequestMethod.GET)
	public ModelAndView viewhostel(@ModelAttribute("hostelbean") HostelBean hostelbean,
			BindingResult result, HttpServletRequest request){
		ModelAndView mv = new ModelAndView("admin/viewhostels");
		mv.addObject("organizations", utilityService.getAllOrganizations(null));
		return mv;
	}
	@RequestMapping(value = "addorganization", method = RequestMethod.GET)
	public ModelAndView addOrganization(@ModelAttribute("organization") Organization organization,
			BindingResult result, HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("util/addOrganization");
		String param = request.getParameter("param");
		
		mv.addObject("stasuses", OrganizaionUtility.getOrgStatus());
		if (param != null && param.equals("edit")) {
			organization = utilityService.getOrganization(organization);
			mv.setViewName("util/editorganization");
			mv.addObject("organization", organization);
			//return mv;
		}
		mv.addObject("years", OrganizaionUtility.getIntYears());
		return mv;
	}

	@RequestMapping(value = "saveorganization", method = RequestMethod.POST)
	public ModelAndView saveOrganization(
			@ModelAttribute("organization") Organization organization,
			BindingResult result) {
		utilityService.saveOrganization(organization);
		ModelAndView mv = new ModelAndView("util/organizationview");
		mv.addObject("organizations",utilityService.getAllOrganizations(organization));
		return mv;
	}
	
	@RequestMapping(value = "viewall", method = RequestMethod.GET)
	public ModelAndView viewOrganization(@ModelAttribute("organization") Organization organization,
			BindingResult result, HttpServletRequest request) {
		String param = request.getParameter("param");
		ModelAndView mv = new ModelAndView("util/organizationview");
		if (param != null && param.equals("all")) {
			mv.addObject("status", "all");
			mv.addObject("organizations",utilityService.getAllOrganizations(organization));
		}
		if (param != null && param.equals("search")) {
			mv.addObject("status", "search");
		}
		if (param != null && param.equals("edit")) {
			mv.addObject("status", "edit");
				
		}
		mv.addObject("organizations",utilityService.getAllOrganizations(organization));
		return mv;
	}

	@RequestMapping(value = "addrole", method = RequestMethod.GET)
	public ModelAndView addRole(@ModelAttribute("userRole") UserRole userRole,
			BindingResult result, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("util/addRole");
		mv.addObject("stasuses", OrganizaionUtility.getOrgStatus());
		return mv;
	}

	@RequestMapping(value = "saverole", method = RequestMethod.POST)
	public ModelAndView saveRole(@ModelAttribute("userRole") UserRole userRole,
			BindingResult result, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("util/addRole");
		boolean flag = utilityService.saveRole(userRole);
		mv.addObject("userRole", new UserRole());
		mv.addObject("stasuses", OrganizaionUtility.getOrgStatus());
		if(flag){
		mv.addObject("message", "Role has been added successfully..");
		}else{
			mv.addObject("message", "Role "+userRole.getRoleName()+" Already exists..");
		}
		userRole = new UserRole();
		return mv;
	}

	@RequestMapping(value = "showroles", method = RequestMethod.GET)
	public ModelAndView showAllRoles(@ModelAttribute("userRole") UserRole userRole,BindingResult result,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("util/viewRoles");
		mv.addObject("roles", utilityService.getAllRoles());
		return mv;
	}
	
	@RequestMapping(value = "editroles", method = RequestMethod.GET)
	public ModelAndView editRoles(@ModelAttribute("classbean") StudentClassBean classbean,BindingResult result,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("util/editroles");
		classbean.setUserroles(utilityService.getAllRoles());
		mv.addObject("classbean", classbean);
		return mv;
	}
	
	@RequestMapping(value = "saveeditedroles", method = RequestMethod.POST)
	public ModelAndView saveeditRoles(@ModelAttribute("classbean") StudentClassBean classbean,BindingResult result,
			HttpServletRequest request) {
		
		utilityService.saveEditedRoles(classbean.getUserroles());
		ModelAndView mv = new ModelAndView("util/viewRoles");
		mv.addObject("roles", utilityService.getAllRoles());
		return mv;
	}
	

}
