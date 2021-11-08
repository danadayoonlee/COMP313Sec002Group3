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
import com.curahealthyme.model.Patient_Doctor_Join;
import com.curahealthyme.model.Patient_Medical_History;
import com.curahealthyme.model.User_Logon;
import com.curahealthyme.repo.MedicalStaffRepository;
import com.curahealthyme.repo.PatientRepository;
import com.curahealthyme.repo.Patient_Doctor_JoinRepository;
import com.curahealthyme.repo.Patient_Medical_HistoryRepository;
import com.curahealthyme.repo.UserAccessRepository;
import com.curahealthyme.repo.User_LogonRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
	@Autowired
	private Patient_Doctor_JoinRepository joinRepo;
	@Autowired
	private Patient_Medical_HistoryRepository patientDataRepo;
	
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
				long id = joinRepo.getFamilyDoctorId(patient.getPatientId()) == null ? 0 : joinRepo.getFamilyDoctorId(patient.getPatientId()).getDoctorId();
				if (id != 0)
				{
					String familydoctor = medicalStaffRepo.findById(id).getEmployeeName();
					model.addAttribute("familydoctor",familydoctor);
				}
				return "index";
			}
			if (userrole.equals("Doctor"))
			{
				System.out.println("Doctor");
				MedicalStaff doctor = medicalStaffRepo.findEmployeeByLoginId(Long.parseLong(loginid));
				model.addAttribute("user", doctor);
				return "medicalstaffhome";
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
		
		Patient patient = patientRepo.findById(patientId);
		model.addAttribute("patient", patient);
		long doctorAccessId = userAccessRepo.findAccessIdByRole("Doctor");
		List<Long> loginIds = userlogonRepo.findUserLoginIdsByAccess(doctorAccessId);
		List<MedicalStaff> doctors = medicalStaffRepo.findEmployeeByLoginIds(loginIds);
		model.addAttribute("doctors",doctors);
		return "findfamilydoctor";
	}
	@RequestMapping(value="/setfamilydoctor/{patientId}", method = RequestMethod.POST)
	public String UpateFamilyDoctor(Model model, @PathVariable("patientId") long patientId, @RequestParam("familydoctor") String doctorId) {
		Patient_Doctor_Join joinExist =joinRepo.getFamilyDoctorId(patientId);
		if (joinExist != null)
		{
			joinExist.setDoctorId(Long.parseLong(doctorId));
			joinRepo.save(joinExist);
		} else {
			Patient_Doctor_Join join = new Patient_Doctor_Join();
			join.setPatientId(patientId);
			join.setDoctorId(Long.parseLong(doctorId));
			joinRepo.save(join);
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/viewmedicalhistory/{patientId}")
	public String GetPatientMedicalHistory(Model model, @PathVariable("patientId") long patientId)
	{
		long joinId =joinRepo.getFamilyDoctorId(patientId).getId();

		Patient patient = patientRepo.findById(patientId);
		model.addAttribute("patient", patient);
		List<Patient_Medical_History> patientdata =  patientDataRepo.getPatientMedicalHistory(joinId);
		model.addAttribute("medicalhistory", patientdata);
		long id = joinRepo.getFamilyDoctorId(patient.getPatientId()) == null ? 0 : joinRepo.getFamilyDoctorId(patient.getPatientId()).getDoctorId();
		if (id != 0)
		{
			String familydoctor = medicalStaffRepo.findById(id).getEmployeeName();
			model.addAttribute("familydoctor",familydoctor);
		}
		return "viewpatientmedicalinfolist";
	}
	
	@RequestMapping(value="/viewallpatients")
	public String GetAllPatients(Model model)
	{
		List<Patient> patients = (List<Patient>) patientRepo.findAll();
		model.addAttribute("patients", patients);
		return "patientlist";
	}
	
	@RequestMapping(value="/viewmypatients/{employeeId}")
	public String GetPatientsByDoctor(Model model,@PathVariable("employeeId") long employeeId)
	{
		List<Long> patientIds =joinRepo.getDataByDoctor(employeeId);

		List<Patient> patients = (List<Patient>) patientRepo.findByIds(patientIds);
		model.addAttribute("patients", patients);
		return "patientlist";
	}
}
