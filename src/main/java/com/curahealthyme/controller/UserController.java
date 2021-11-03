package com.curahealthyme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.curahealthyme.model.Patient;
import com.curahealthyme.model.User_Logon;
import com.curahealthyme.repo.PatientRepository;
import com.curahealthyme.repo.User_LogonRepository;

@Controller
public class UserController {
	@Autowired
	private PatientRepository patientRepo;

	@Autowired
	private User_LogonRepository userlogonRepo;

	@RequestMapping(value = "/success")
	public String success() {
		return "success";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registeruser(Patient patient, @RequestParam("username") String username,
			@RequestParam("password") String pwd, @RequestParam("confirmpwd") String confirmpwd, Model model) {
		System.out.println(patient.Name);
		if (!pwd.equals(confirmpwd)) {
			model.addAttribute("errorMsg", "Your password and confirmation password do not match.");
			return "register";
		} else {
			User_Logon userlogon = new User_Logon();
			userlogon.Username = username;
			userlogon.Password = pwd;
			userlogon.setUserAccessId(6);
			userlogonRepo.save(userlogon);
			patient.setLoginId(userlogon.getId());
			patientRepo.save(patient);
			return "redirect:/success";
		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginuser(@RequestParam("username") String username, @RequestParam("password") String pwd, Model model) {
		if (userlogonRepo.findByUsername(username, pwd) != null)
		{
			return "redirect:/";
		} else {
			model.addAttribute("errorMsg","Invalid username and/or Password!");
			return "login";
		}
		

	}

}
