package com.school.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.school.pojo.Organization;
import com.school.pojo.User;
import com.school.service.LoginService;

@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	private LoginService loginService;;

	@RequestMapping(value = "welcome", method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("user", new User());
		return mv;
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("user") User user, BindingResult result, SessionStatus status,
			HttpServletRequest request) {

		ValidationUtils.rejectIfEmpty(result, "email", "email.required");
		ValidationUtils.rejectIfEmpty(result, "userPassword", "password.required");
		if (result.hasErrors()) {
			return new ModelAndView("login");
		}
		ModelAndView mv = new ModelAndView();
	User user1 = loginService.login(user);
		if (user1 == null) {
			mv.addObject("message", "Invalid Username/Password");
			mv.setViewName("login");
			return mv;
		}

		Organization organization = loginService.validatelogin(user1);
		if (organization == null) {
			mv.addObject("message", "Orgnization is Inactive. Please contact Administator");
			mv.setViewName("login");
			return mv;
		}

		request.getSession().setAttribute("organization", organization);
		request.getSession().setAttribute("user", user1);

		//request.getSession().setAttribute("user", user);
		status.setComplete();
		
		mv.setViewName("home");
		return mv;

	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public @ResponseBody String validateModel(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = new User();
		user.setEmail(email);
		user.setUserPassword(password);
		// return loginService.validatelogin(user);
		return null;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(@ModelAttribute("user") User user, BindingResult result, SessionStatus status,
			HttpServletRequest request) {

		status.setComplete();
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("organization");
		request.getSession().invalidate();
		return new ModelAndView("login");

	}
}
