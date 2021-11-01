package com.curahealthyme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.curahealthyme.repo.PatientRepository;

@Controller
public class HomeController {
	
	@RequestMapping(value= "/")
	public String home() {
		return "index";
	}
	@RequestMapping(value= "/aboutus")
	public String about() {
		return "aboutus";
	}
	@RequestMapping(value= "/contactus")
	public String contact() {
		return "contactus";
	}
	@RequestMapping(value= "/news")
	public String news() {
		return "news";
	}
	
	@RequestMapping(value= "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value= "/register")
	public String register() {
		return "register";
	}
}
