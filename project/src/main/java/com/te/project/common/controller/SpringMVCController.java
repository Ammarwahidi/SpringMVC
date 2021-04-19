package com.te.project.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.te.project.common.dto.UserBean;

@Controller
public class SpringMVCController {
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView getHomePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("homepage");
		return modelAndView;

	}

	@RequestMapping(path = "/form", method = RequestMethod.GET)
	public ModelAndView getform() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("form");
		return modelAndView;

	}

	public ModelAndView getData(ModelAndView modelAndView, HttpServletRequest httpServletRequest) {
		String name = httpServletRequest.getParameter("name");
		modelAndView.addObject("username");
//		httpServletRequest.setAttribute("username", name);
		modelAndView.setViewName("newHome");
		return modelAndView;

	}

	@GetMapping("/login")
	public String getlogin() {
		return "login";

	}

	@PostMapping("/login1")
	public String getFormData(HttpServletRequest httpServletRequest, ModelMap modelMap) {
		// get form data using request
		String username = httpServletRequest.getParameter("username");
		int password = Integer.parseInt(httpServletRequest.getParameter("password"));

		modelMap.addAttribute("username", username);
		modelMap.addAttribute("password", password);

		return "userDetails";

	}

	@PostMapping("/login2")
	public String name(ModelMap modelMap, int password, String username) {
		modelMap.addAttribute("username", username);
		modelMap.addAttribute("password", password);

		return "userDetails";

	}

	@PostMapping("/login3")
	public String getDataUsingBean(ModelMap modelMap, UserBean bean) {
		modelMap.addAttribute("username", bean.getUsername());
		modelMap.addAttribute("password", bean.getPassword());
		return "userDetails";

	}

	@PostMapping("/login4")
	public String getDatarequest(ModelMap modelMap, @RequestParam(name = "") String username,
			@RequestParam(name = "pwd") int password) {
		modelMap.addAttribute("username", username);
		modelMap.addAttribute("password", password);
		return "userDetails";
	}

}
