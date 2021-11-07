package com.curahealthyme.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.curahealthyme.model.Patient;
import com.curahealthyme.model.User_Logon;
import com.curahealthyme.repo.UserAccessRepository;

@Controller
public class HomeController {
	
	@Autowired
	private UserAccessRepository userAccessRepo;
	
	@RequestMapping(value= "/")
	public String home(HttpServletRequest request) {
		if (request.getSession().getAttribute("USERNAME") == null)
			return "redirect:/login";
		else
			return "index";
	}
	@RequestMapping(value= "/aboutus")
	public String about(HttpServletRequest request) {
		if (request.getSession().getAttribute("USERNAME") == null)
			return "redirect:/login";
		else
		return "aboutus";
	}
	@RequestMapping(value= "/contactus")
	public String contact(HttpServletRequest request) {
		if (request.getSession().getAttribute("USERNAME") == null)
			return "redirect:/login";
		else
		return "contactus";
	}
	@RequestMapping(value= "/news")
	public String news(HttpServletRequest request) {
		if (request.getSession().getAttribute("USERNAME") == null)
			return "redirect:/login";
		else
		return "news";
	}
	
	@RequestMapping(value= "/login")
	public String login(Model model) {
		model.addAttribute("errorMsg","");
		return "login";
	}
	
	@RequestMapping(value= "/register")
	public String register(Model model) {
		model.addAttribute("patient", new Patient());
		model.addAttribute("userlogon", new User_Logon());
		model.addAttribute("confirmpwd", "");
		model.addAttribute("errorMsg", "");
		model.addAttribute("userAccess", userAccessRepo.findAll());
		return "register";
	}
}
