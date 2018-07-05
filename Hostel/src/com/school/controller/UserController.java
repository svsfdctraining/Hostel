package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.school.bean.UserBean;
import com.school.service.UserService;
import com.school.service.UtilityService;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UtilityService utilityService;
	
	@RequestMapping(value="welcome", method=RequestMethod.GET)
	public ModelAndView welcome(){
				
		ModelAndView mv = new ModelAndView("user/addUser");
		mv.addObject("orgs", userService.getOrganizations());
		mv.addObject("roles",utilityService.getAllRoles() );
		mv.addObject("user", new UserBean());
		return mv;
	
	}

	@RequestMapping(value="save", method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user")UserBean user, BindingResult result){
		user.getUser().setUserPassword(user.getPassword2());
		userService.addUser(user.getUser());
		ModelAndView mv = new ModelAndView("user/addUser");
		mv.addObject("message", "User saved successfully..");
		return mv;
	}
	
	@RequestMapping(value="view",method=RequestMethod.GET)
	public ModelAndView viewusers(){
		
		ModelAndView mv = new ModelAndView("user/viewusers");
		mv.addObject("users", userService.getAllUsers());
		return mv;
	}
	
	@RequestMapping(value="edit", method=RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute("user")UserBean user,BindingResult result){
		
		ModelAndView mv = new ModelAndView("user/edituser");
		mv.addObject("user", new UserBean());
		/*ModelAndView mv = new ModelAndView("user/edituser");
		UserBean u = userService.getUser(user.getUserName());
		if(u == null){
			mv.addObject("message", true);	
		}
			mv.addObject("user", u);*/
		
		return mv;
	}

	
	
}
