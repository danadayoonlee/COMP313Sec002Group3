package com.curahealthyme.s3utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.curahealthyme.model.PatientDocument;
import com.curahealthyme.repo.MedicalStaffRepository;
import com.curahealthyme.repo.PatientDocumentRepository;
import com.curahealthyme.repo.PatientRepository;

@Controller
public class AWSS3Controller {
	@Autowired
	private S3Util s3Util;
	@Autowired
	private PatientDocumentRepository patientDocRepo;
	@Autowired
	private PatientRepository patientRepo;
	@Autowired
	private MedicalStaffRepository medicalStaffRepo;
	
	@PostMapping("upload")
	public ModelAndView uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("patientId") long patientId
			, @RequestParam("doctorId") long doctorId, @RequestParam("documentType") String documentType) {
		System.out.println("Upload-" + file);
		try {
			PatientDocument doc = new PatientDocument();
			doc.setPatientId(patientId);
			doc.setDoctorId(doctorId);
			doc.setDocumentType(documentType);
			doc.setFileName(file.getOriginalFilename());
			doc.setFileKey(file.getOriginalFilename());
			doc.setDatePosted(new Date(System.currentTimeMillis()));
			doc.setDoctorName(medicalStaffRepo.findByMedicalStaffId(doctorId).getEmployeeName());
			doc.setPatientName(patientRepo.findByPatientId(patientId).getName());
			patientDocRepo.save(doc);
			File fileObj = convertMultiPartToFile(file);
			String key = file.getOriginalFilename();
			s3Util.uploadFile(key, fileObj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/viewmedicalhistory/" + patientId);		
	}
	
	@GetMapping("downloadfile/{fileName}")
	public ResponseEntity<byte[]> downloadFile(@PathVariable("fileName") String fileName) {
		System.out.println("Download-" + fileName);
		byte[] content = null;
		try {
			String key = fileName;
			content= s3Util.downloadFile(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" +fileName + "\"").body(content);
		
	}
	public void viewFile(@PathVariable("fileName") String filename) throws IOException {
    }
	@GetMapping("viewfile/{fileName}")
	public ModelAndView viewFileFile(@PathVariable("fileName") String fileName) {
		String Url ="";
		System.out.println("Download-" + fileName);
		try {
			String key = fileName;
			Url = s3Util.getFIleUrl(key);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:"+Url);
	}
	
	@PostMapping("delete")
	public void deleteFile(@RequestParam("fileName") String fileName) {
		System.out.println("Delete-" + fileName);
		try {
			String key = fileName;
			s3Util.deleteFile(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private File convertMultiPartToFile(MultipartFile file) throws IOException {
	    File convFile = new File(file.getOriginalFilename());
	    FileOutputStream fos = new FileOutputStream(convFile);
	    fos.write(file.getBytes());
	    fos.close();
	    return convFile;
	}
}
