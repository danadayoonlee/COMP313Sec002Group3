package com.curahealthyme.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "/")
	public String home(HttpServletRequest request, Model model) {

		if (request.getSession().getAttribute("USERNAME") == null) {
			return "redirect:/login";
		} else {
			String loginid = request.getSession().getAttribute("LoginId").toString();
			String userrole = request.getSession().getAttribute("userrole").toString();
			if (userrole.equals("Patient")) {
				System.out.println("Patient");
				Patient patient = patientRepo.findPatientByLoginId(Long.parseLong(loginid));
				model.addAttribute("user", patient);
				long id = joinRepo.getFamilyDoctorId(patient.getPatientId()) == null ? 0
						: joinRepo.getFamilyDoctorId(patient.getPatientId()).getDoctorId();
				if (id != 0) {
					String familydoctor = medicalStaffRepo.findByMedicalStaffId(id).getEmployeeName();
					model.addAttribute("familydoctor", familydoctor);
				}
				return "index";
			}
			if (userrole.equals("Doctor")) {
				System.out.println("Doctor");
				MedicalStaff doctor = medicalStaffRepo.findEmployeeByLoginId(Long.parseLong(loginid));
				model.addAttribute("user", doctor);
				return "medicalstaffhome";
			}
			return "index";

		}

	}

	@RequestMapping(value = "/aboutus")
	public String about(HttpServletRequest request) {
		if (request.getSession().getAttribute("USERNAME") == null)
			return "redirect:/login";
		else
			return "aboutus";
	}

	@RequestMapping(value = "/contactus")
	public String contact(HttpServletRequest request) {
		if (request.getSession().getAttribute("USERNAME") == null)
			return "redirect:/login";
		else
			return "contactus";
	}

	@RequestMapping(value = "/news")
	public String news(HttpServletRequest request) {
		if (request.getSession().getAttribute("USERNAME") == null)
			return "redirect:/login";
		else
			return "news";
	}

	@RequestMapping(value = "/login")
	public String login(Model model) {
		model.addAttribute("errorMsg", "");
		return "login";
	}

	@RequestMapping(value = "/register")
	public String register(Model model) {
		model.addAttribute("patient", new Patient());
		model.addAttribute("userlogon", new User_Logon());
		model.addAttribute("confirmpwd", "");
		model.addAttribute("errorMsg", "");
		model.addAttribute("userAccess", userAccessRepo.findAll());
		return "register";
	}

	@RequestMapping(value = "/findfamilydoctor/{patientId}")
	public String updateCentrePage(Model model, @PathVariable("patientId") long patientId) {

		Patient patient = patientRepo.findByPatientId(patientId);
		model.addAttribute("patient", patient);
		long doctorAccessId = userAccessRepo.findAccessIdByRole("Doctor");
		List<Long> loginIds = userlogonRepo.findUserLoginIdsByAccess(doctorAccessId);
		List<MedicalStaff> doctors = medicalStaffRepo.findEmployeeByLoginIds(loginIds);
		model.addAttribute("doctors", doctors);
		return "findfamilydoctor";
	}

	@RequestMapping(value = "/setfamilydoctor/{patientId}", method = RequestMethod.POST)
	public String UpateFamilyDoctor(Model model, @PathVariable("patientId") long patientId,
			@RequestParam("familydoctor") String doctorId) {
		Patient_Doctor_Join joinExist = joinRepo.getFamilyDoctorId(patientId);
		if (joinExist != null) {
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

	@RequestMapping(value = "/viewmedicalhistory/{patientId}")
	public String GetPatientMedicalHistory(Model model, @PathVariable("patientId") long patientId) {
		long joinId = joinRepo.getFamilyDoctorId(patientId).getId();

		Patient patient = patientRepo.findByPatientId(patientId);
		model.addAttribute("patient", patient);
		List<Patient_Medical_History> patientdata = patientDataRepo.getPatientMedicalHistory(joinId);
		model.addAttribute("medicalhistory", patientdata);
		long id = joinRepo.getFamilyDoctorId(patient.getPatientId()) == null ? 0
				: joinRepo.getFamilyDoctorId(patient.getPatientId()).getDoctorId();
		if (id != 0) {
			String familydoctor = medicalStaffRepo.findByMedicalStaffId(id).getEmployeeName();
			model.addAttribute("familydoctor", familydoctor);
		}
		return "viewpatientmedicalinfolist";
	}

	@RequestMapping(value = "/viewallpatients")
	public String GetAllPatients(Model model) {
		List<Patient> patients = (List<Patient>) patientRepo.findAll();
		model.addAttribute("patients", patients);
		return "patientlist";
	}

	@RequestMapping(value = "/viewmypatients/{employeeId}")
	public String GetPatientsByDoctor(Model model, @PathVariable("employeeId") long employeeId) {
		List<Long> patientIds = joinRepo.getDataByDoctor(employeeId);
		List<Patient> patients = (List<Patient>) patientRepo.findByIds(patientIds);
		model.addAttribute("patients", patients);
		return "patientlist";
	}

	@RequestMapping(value = "/addpatientmedicaldata/{patientId}")
	public String AddPatientMedicalPage(Model model, HttpServletRequest request,
			@PathVariable("patientId") long patientId) {
		String loginid = request.getSession().getAttribute("LoginId").toString();
		MedicalStaff doctor = medicalStaffRepo.findEmployeeByLoginId(Long.parseLong(loginid));
		Patient_Medical_History data = new Patient_Medical_History();
		data.JoinId = joinRepo.getJoinIdBypatientdoctorId(doctor.getEmployeeId(), patientId);
		Patient patient = patientRepo.findByPatientId(patientId);
		model.addAttribute("patient", patient);
		model.addAttribute("patientmedicalinfo", data);
		String familydoctor = medicalStaffRepo.findByMedicalStaffId(doctor.getEmployeeId()).getEmployeeName();
		model.addAttribute("familydoctor", familydoctor);
		return "addpatientmedicaldata";

	}

	@RequestMapping(value = "/addpatientdata/{patientId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView AddPatientMedicalInfoData(Model model, HttpServletRequest request,
			@RequestParam("reasonforvisit") String reasonForVisit, @RequestParam("problems") String problems,
			@RequestParam("medications") String medications, @RequestParam("allergies") String allergies,
			@RequestParam("treatment") String treatment, @RequestParam("servicedue") String servicedue,
			@RequestParam("visitlocation") String visitlocation, @RequestParam("followup") Date followup,
			@PathVariable("patientId") long patientId) {
		
		long joinId = joinRepo.getFamilyDoctorId(patientId).getId();
		String loginid = request.getSession().getAttribute("LoginId").toString();
		long doctorId = medicalStaffRepo.findEmployeeByLoginId(Long.parseLong(loginid)).getEmployeeId();
		Patient_Medical_History data = new Patient_Medical_History();
		data.setReasonForVisit(reasonForVisit);
		data.setProblems(problems);
		data.setMedications(medications);
		data.setAllergies(allergies);
		data.setServicesDue(servicedue);
		data.setLocationOfVisit(visitlocation);
		data.setTreatment(treatment);
		data.setFollowUp(followup);
		data.setDateVisited(new Date(System.currentTimeMillis()));
		data.setDoctorId(doctorId);
		data.setJoinId(joinId);
		patientDataRepo.save(data);
		return new ModelAndView("redirect:/viewmedicalhistory/" + patientId);
	}
	@RequestMapping(value="/viewpatientmedicaldetail/{id}/patient/{patientId}")
	public String ViewPatientMedicalVisitDetail(Model model, @PathVariable("id") long id, @PathVariable("patientId") long patientId)
	{
		Patient_Medical_History data = patientDataRepo.findByMedicalDataId(id);
		model.addAttribute("medicaldata",data);
		Patient patient = patientRepo.findByPatientId(patientId);
		model.addAttribute("patient", patient);
		String name = medicalStaffRepo.findByMedicalStaffId(data.getDoctorId()).getEmployeeName();
		model.addAttribute("doctor", name);
		String familydoctor = medicalStaffRepo.findByMedicalStaffId(joinRepo.getFamilyDoctorId(patientId).getDoctorId()).getEmployeeName();
		model.addAttribute("familydoctor", familydoctor);
		return "patientmedicaldetailpage";
		
	}
}
