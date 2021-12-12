package com.curahealthyme.controller;


import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.curahealthyme.model.Disease;
import com.curahealthyme.model.MedicalStaff;
import com.curahealthyme.model.Notification;
import com.curahealthyme.model.Patient;
import com.curahealthyme.model.PatientDocument;
import com.curahealthyme.model.Patient_Doctor_Join;
import com.curahealthyme.model.Patient_Medical_History;
import com.curahealthyme.model.User_Logon;
import com.curahealthyme.repo.DiseaseRepository;
import com.curahealthyme.repo.MedicalStaffRepository;
import com.curahealthyme.repo.PatientDocumentRepository;
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
	@Autowired
	private PatientDocumentRepository patientDocumentRepo;
	@Autowired
	private DiseaseRepository diseaseRepository;
	
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

	@RequestMapping(value="/viewallpatients")
	public String GetAllPatients(Model model)
	{
		List<Patient> patients = (List<Patient>) patientRepo.findAll();
		List<Patient_Medical_History> histories = patientDataRepo.findAll();
		
		model.addAttribute("histrySize",histories.size()>0 ? "" : "none");
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

	
	@RequestMapping(value="/uploaddocument/{patientId}")
	public String UploadDocumentPage(HttpServletRequest request, Model model, @PathVariable("patientId") long patientId)
	{
		String loginid = request.getSession().getAttribute("LoginId").toString();
		MedicalStaff doctor = medicalStaffRepo.findEmployeeByLoginId(Long.parseLong(loginid));
		model.addAttribute("doctor", doctor.getEmployeeId());
		Patient patient = patientRepo.findByPatientId(patientId);
		model.addAttribute("patient", patient);
		return "uploaddocument";
	}
	@RequestMapping(value="/uploadeddocuments")
	public String UploadedDocumentsPage(Model model)
	{
		List<PatientDocument> docs = (List<PatientDocument>) patientDocumentRepo.findAll();
		model.addAttribute("documents", docs);
		return "viewpatientdocuments";
		
	}
	@RequestMapping(value="/viewtestrequisitions/{patientId}")
	public String ViewTestRequisition(Model model, @PathVariable("patientId") long patientId)
	{
		List<PatientDocument> docs = patientDocumentRepo.findDocumentsByType(patientId, "test-requisition");
		model.addAttribute("documents", docs);
		return "viewpatientdocuments";
	}
	@RequestMapping(value="/viewtestresults/{patientId}")
	public String ViewTestResults(Model model, @PathVariable("patientId") long patientId)
	{
		List<PatientDocument> docs = patientDocumentRepo.findDocumentsByType(patientId, "test-result");
		model.addAttribute("documents", docs);
		return "viewpatientdocuments";
	}
	@RequestMapping(value="/viewpatientprescriptions/{patientId}")
	public String ViewPatientPrescriptions(Model model, @PathVariable("patientId") long patientId)
	{
		List<PatientDocument> docs = patientDocumentRepo.findDocumentsByType(patientId, "prescription");
		model.addAttribute("documents", docs);
		return "viewpatientdocuments";
	}

	@RequestMapping(value="/history/{employeeId}")
	public String addPatientMedicalData(Model model,@PathVariable("employeeId") long employeeId) 
	{
		Patient_Medical_History patientdata =  patientDataRepo.findByJoinId(employeeId);
		
		if(patientdata == null) {
			
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String s = sdf.format(d);
			
			List<Disease> diseases = diseaseRepository.findAll();
			model.addAttribute("patientmedicalinfo", new Patient_Medical_History());
			model.addAttribute("patient",patientRepo.findById(employeeId));
			model.addAttribute("date",s);
			model.addAttribute("diseases",diseases);
			
			return "addpatientmedicaldata";
		}
		else {
			
			patientdata.setDateVisited(patientdata.getDateVisited().isEmpty() ? "" : patientdata.getDateVisited().substring(0, 10));
			patientdata.setFollowUp(patientdata.getFollowUp().isEmpty() ? "" : patientdata.getFollowUp().substring(0,10));
			
			List<Disease> diseases = diseaseRepository.findAll();
			model.addAttribute("patientmedicalinfo", patientdata);
			model.addAttribute("patient",patientRepo.findById(employeeId));
			model.addAttribute("diseases",diseases);
			
			return "updatepatientmedicaldata";
		}
	}
	
	
	@RequestMapping(value="/addpatientdata/{patientId}", method = RequestMethod.POST)
	public String UpatePatientHistry(Patient_Medical_History history, Model model, @PathVariable("patientId") long patientId) {
		Patient_Medical_History joinExist =patientDataRepo.findByJoinId(patientId);
		if (joinExist != null)
		{
			
			joinExist.setAllergies(history.getAllergies());
			joinExist.setDateVisited(history.getDateVisited().toString());
			joinExist.setFollowUp(history.getFollowUp().toString());
			joinExist.setLocationOfVisit(history.getLocationOfVisit());
			joinExist.setMedications(history.getMedications());
			joinExist.setProblems(history.getProblems());
			joinExist.setReasonForVisit(history.getReasonForVisit());
			joinExist.setServicesDue(history.getServicesDue());
			joinExist.setTreatment(history.getTreatment());
			
			patientDataRepo.save(joinExist);
		} else {
			Patient_Medical_History join = new Patient_Medical_History();
	
			Disease disease = diseaseRepository.getById(history.getDiseaseId());
			
			join.setAllergies(history.getAllergies());
			join.setDateVisited(history.getDateVisited().toString());
			join.setFollowUp(history.getFollowUp().toString());
			join.setLocationOfVisit(history.getLocationOfVisit());
			join.setMedications(history.getMedications());
			join.setProblems(history.getProblems());
			join.setReasonForVisit(history.getReasonForVisit());
			join.setServicesDue(history.getServicesDue());
			join.setTreatment(history.getTreatment());
			join.setDiseaseId(disease.getDiseaseId());
			join.setJoinId(patientId);
			
			patientDataRepo.save(join);
		}
		return "redirect:/viewallpatients";
	}
	
	@RequestMapping(value="/historyview/{employeeId}")
	public String addPatientMedicalViewData(Model model,@PathVariable("employeeId") long employeeId)
	{
		Patient_Medical_History patientdata =  patientDataRepo.findByJoinId(employeeId);
		
		patientdata.setDateVisited(patientdata.getDateVisited().isEmpty() ? "" : patientdata.getDateVisited().substring(0, 10));
		patientdata.setFollowUp(patientdata.getFollowUp().isEmpty() ? "" : patientdata.getFollowUp().substring(0,10));
		
		List<Disease> diseases = diseaseRepository.findAll();
		model.addAttribute("patientmedicalinfo", patientdata);
		model.addAttribute("patient",patientRepo.findById(employeeId));
		model.addAttribute("diseases",diseases);
		return "addpatientmedicaldataview";
	}
	
	@RequestMapping(value="/notification")
	public String GetNotification(Model model) throws ParseException
	{
		Date d = new Date();
		List<Patient_Medical_History> patients = patientDataRepo.findAll();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String s = sdf.format(d);
		List<Notification> data = new ArrayList<>();
		for(Patient_Medical_History p : patients) {
			data.add(new Notification(patientRepo.findById(p.getJoinId()).getName(),
					p.getFollowUp().substring(0, 10),sdf.parse(s).equals(sdf.parse(p.getFollowUp())) ? "Need Check Up":"Don't Need Check Up"));
		}
		
		model.addAttribute("patients", data);
		return "notification";
	}
}
