package com.curahealthyme.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.curahealthyme.model.MedicalStaff;
import com.curahealthyme.model.Patient;
import com.curahealthyme.model.User_Logon;
import com.curahealthyme.repo.MedicalStaffRepository;
import com.curahealthyme.repo.PatientRepository;
import com.curahealthyme.repo.UserAccessRepository;
import com.curahealthyme.repo.User_LogonRepository;

import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
	
	@Autowired
	private UserAccessRepository userAccessRepo;
	@Autowired
	private PatientRepository patientRepo;
	@Autowired
	private MedicalStaffRepository medicalStaffRepo;
	@Autowired
	private User_LogonRepository userlogonRepo;
	
	@RequestMapping(value= "/")
	public String home(HttpServletRequest request, Model model) {

		if (request.getSession().getAttribute("USERNAME") == null)
		{
			return "redirect:/login";
		}
		else
		{
			String loginid = request.getSession().getAttribute("LoginId").toString();
			String userrole = request.getSession().getAttribute("userrole").toString();
			if (userrole.equals("Patient"))
			{
				System.out.println("Patient");
				Patient patient = patientRepo.findPatientByLoginId(Long.parseLong(loginid));
				model.addAttribute("user", patient);
			}
			if (userrole.equals("Doctor"))
			{
				System.out.println("Doctor");
				MedicalStaff doctor = medicalStaffRepo.findEmployeeByLoginId(Long.parseLong(loginid));
				model.addAttribute("user", doctor);
			}
			return "index";
		}
			
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
	
	@RequestMapping(value="/findfamilydoctor/{patientId}")
	public String updateCentrePage(Model model, @PathVariable("patientId") long patientId) {
		Patient patient = patientRepo.findById(patientId).get();
		model.addAttribute("patient", patient);
		long doctorAccessId = userAccessRepo.findAccessIdByRole("Doctor");
		List<Long> loginIds = userlogonRepo.findUserLoginIdsByAccess(doctorAccessId);
		List<MedicalStaff> doctors = medicalStaffRepo.findEmployeeByLoginIds(loginIds);
		model.addAttribute("doctors",doctors);
		return "findfamilydoctor";
	}
}
