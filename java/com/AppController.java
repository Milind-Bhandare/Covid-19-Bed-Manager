package com;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hospital.entity.Enquiry;
import com.hospital.entity.HospitalMaster;
import com.hospital.entity.PatientEnquiry;
import com.hospital.entity.PatientMaster;
import com.hospital.entity.UserMaster;
import com.hospital.service.HospitalMasterService;
import com.hospital.service.PatientEnquiryService;
import com.hospital.service.PatientMasterService;
import com.hospital.service.UserMasterService;

@Controller
public class AppController {

	@Autowired
	private UserMasterService userMasterService;
	
	@Autowired
	private HospitalMasterService hospitalMasterService;
	
	@Autowired
	private PatientMasterService patientMasterService;

	@Autowired
	private PatientEnquiryService patientEnquiryService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		
		return "index";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();	
		return "redirect:/";
	}
	
	
	@RequestMapping("/patientDashboard")
	public String patientDashboard(Model model) {		
		return "patient_dashboard";
	}
	
	@RequestMapping("/search-hospital")
	public String searchHospital(Model model) {
		model.addAttribute("hospitals", hospitalMasterService.getAll());
		return "search-hospital";
	}
	
	@RequestMapping("/hospitalDashboard")
	public String hospitalDashboard(Model model) {		
		return "hospital_dashboard";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public String login(@ModelAttribute UserMaster userMaster, Model model, HttpServletRequest request) {
		
		UserMaster user = userMasterService.findByEmailAndPassword(userMaster.getEmail(), userMaster.getPassword());
		
		if (user != null) {
			request.getSession().setAttribute("user", user);
			if (user.getUserType().equals("P")) {
				return "redirect:/patientDashboard";
			} else {
				return "redirect:/hospitalDashboard";
			}
		}
		model.addAttribute("errorMsg", "Invalid User Name or Password.");	
		return "index";
	}
			
	@RequestMapping(method = RequestMethod.POST, value = "/hospitalRegister")
	public String registerHospital(@ModelAttribute HospitalMaster hospitalMaster, Model model) {
		
		UserMaster user = new UserMaster();
		user.setEmail(hospitalMaster.getEmail());
		user.setPassword(hospitalMaster.getPassword());
		user.setUserType("H");
		user = userMasterService.save(user);
		
		hospitalMaster.setUserId(user.getUserId());
		hospitalMaster.setOccupiedNormalBeds("0");
		hospitalMaster.setOccupiedOxygenBeds("0");
		hospitalMaster.setOccupiedIcuBeds("0");
		hospitalMasterService.save(hospitalMaster);
		model.addAttribute("successMsg", "Hospital Regestration Successfull, Please login.");
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/patientRegister")
	public String registerPatient(@ModelAttribute PatientMaster patientMaster,  Model model) {
		
		UserMaster user = new UserMaster();
		user.setEmail(patientMaster.getEmail());
		user.setPassword(patientMaster.getPassword());
		user.setUserType("P");
		user = userMasterService.save(user);
		
		patientMaster.setUserId(user.getUserId());
		patientMasterService.save(patientMaster);
		model.addAttribute("successMsg", "Patient Regestration Successfull, Please login.");
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/update-bed")
	public String registerPatient(@ModelAttribute HospitalMaster hospitalMaster,  Model model) {
		HospitalMaster dbHospitalMaster = hospitalMasterService.getByHospitalId(hospitalMaster.getHospitalId());
		dbHospitalMaster.setTotalNormalBeds(hospitalMaster.getTotalNormalBeds());
		dbHospitalMaster.setOccupiedNormalBeds(hospitalMaster.getOccupiedNormalBeds());
		dbHospitalMaster.setTotalOxygenBeds(hospitalMaster.getTotalOxygenBeds());
		dbHospitalMaster.setOccupiedOxygenBeds(hospitalMaster.getOccupiedOxygenBeds());
		dbHospitalMaster.setTotalIcuBeds(hospitalMaster.getTotalIcuBeds());
		dbHospitalMaster.setOccupiedIcuBeds(hospitalMaster.getOccupiedIcuBeds());
		hospitalMasterService.save(dbHospitalMaster);
		model.addAttribute("successMsg", "Bed Updated Successfully.");
		model.addAttribute("hospital", dbHospitalMaster);
		return "bed-management";
	}
	
	
	@RequestMapping("/bed-management.html")
	public String viewBedManagement(Model model, HttpServletRequest request) {
		UserMaster user = (UserMaster) request.getSession().getAttribute("user");
		if (user == null) {
			return "index";
		}
		model.addAttribute("hospital", hospitalMasterService.getByUserId(user.getUserId()));
		return "bed-management";
	}
	
	@RequestMapping("/submit-enquiry")
	public String submitEnquiry(@ModelAttribute PatientEnquiry patientEnquiry, Model model, HttpServletRequest request) {
		UserMaster user = (UserMaster) request.getSession().getAttribute("user");
		if (user == null) {
			return "index";
		}
		patientEnquiry.setDateOfEnquiry(new Date().toString());
		patientEnquiry.setPatientId(patientMasterService.getByUserId(user.getUserId()).getPatientId());
		patientEnquiry.setStatus("open");
		patientEnquiryService.save(patientEnquiry);
		
		model.addAttribute("hospitals", hospitalMasterService.getAll());
		model.addAttribute("successMsg", "Enquiry submitted.");
		return "search-hospital";
	}
	
	@RequestMapping("/patient-enquiry")
	public String patientEnquiry(Model model, HttpServletRequest request) {
		UserMaster user = (UserMaster) request.getSession().getAttribute("user");
		if (user == null) {
			return "index";
		}
		
		List<PatientEnquiry> enquires = patientEnquiryService.getByHospitalId(hospitalMasterService.getByUserId(user.getUserId()).getHospitalId());
		
		List<Enquiry> hospitalEnquires = new ArrayList<>(); 
		for (PatientEnquiry enq : enquires) {
			Enquiry enquiry = new Enquiry();
			PatientMaster patient = patientMasterService.getByPatientId(enq.getPatientId());
			enquiry.setEnquiryId(enq.getEnquiryId());	
			enquiry.setPatientName(patient.getPatientName());
			enquiry.setAddress(patient.getAddress());
			enquiry.setCity(patient.getCity());
			enquiry.setState(patient.getState());
			enquiry.setCountry(patient.getCountry());
			enquiry.setContactNumber(patient.getContactNumber());
			enquiry.setGender(patient.getGender());
			enquiry.setDateOfEnquiry(enq.getDateOfEnquiry());
			enquiry.setSymptomsDetail(enq.getSymtomsDetail());
			hospitalEnquires.add(enquiry);
		}
		
		model.addAttribute("enquires", hospitalEnquires);
		return "patient-enquiry";
	}
	
	@RequestMapping("/close-enquiry")
	public String closeEnquiry(@ModelAttribute PatientEnquiry patientEnquiry, Model model, HttpServletRequest request) {
		
		patientEnquiry = patientEnquiryService.getByEnquiryId(patientEnquiry.getEnquiryId());
		patientEnquiry.setStatus("close");
		patientEnquiryService.update(patientEnquiry);
 		
		UserMaster user = (UserMaster) request.getSession().getAttribute("user");
		if (user == null) {
			return "index";
		}
		
		List<PatientEnquiry> enquires = patientEnquiryService.getByHospitalId(hospitalMasterService.getByUserId(user.getUserId()).getHospitalId());
		
		List<Enquiry> hospitalEnquires = new ArrayList<>(); 
		for (PatientEnquiry enq : enquires) {
			Enquiry enquiry = new Enquiry();
			PatientMaster patient = patientMasterService.getByPatientId(enq.getPatientId());
			enquiry.setEnquiryId(enq.getEnquiryId());
			enquiry.setPatientName(patient.getPatientName());
			enquiry.setAddress(patient.getAddress());
			enquiry.setCity(patient.getCity());
			enquiry.setState(patient.getState());
			enquiry.setCountry(patient.getCountry());
			enquiry.setContactNumber(patient.getContactNumber());
			enquiry.setGender(patient.getGender());
			enquiry.setDateOfEnquiry(enq.getDateOfEnquiry());
			enquiry.setSymptomsDetail(enq.getSymtomsDetail());
			hospitalEnquires.add(enquiry);
		}
		
		model.addAttribute("enquires", hospitalEnquires);
		model.addAttribute("successMsg", "Enquiry closed Successfully.");
		return "patient-enquiry";
	}

	@RequestMapping("/my-enquiry")
	public String patientMyEnquiry(Model model, HttpServletRequest request) {
		UserMaster user = (UserMaster) request.getSession().getAttribute("user");
		if (user == null) {
			return "index";
		}
		
		List<PatientEnquiry> enquires = patientEnquiryService.getByPatientId(patientMasterService.getByUserId(user.getUserId()).getPatientId());
		
		List<Enquiry> hospitalEnquires = new ArrayList<>(); 
		for (PatientEnquiry enq : enquires) {
			Enquiry enquiry = new Enquiry();
			HospitalMaster hospital = hospitalMasterService.getByHospitalId(enq.getHospitalId());
			enquiry.setEnquiryId(enq.getEnquiryId());	
			enquiry.setHospitalName(hospital.getHospitalName());
			enquiry.setAddress(hospital.getAddress());
			enquiry.setCity(hospital.getCity());
			enquiry.setState(hospital.getState());
			enquiry.setCountry(hospital.getCountry());
			enquiry.setContactNumber(hospital.getContactNumber());
			enquiry.setDateOfEnquiry(enq.getDateOfEnquiry());
			enquiry.setSymptomsDetail(enq.getSymtomsDetail());
			enquiry.setStatus(enq.getStatus());
			hospitalEnquires.add(enquiry);
		}
		
		model.addAttribute("enquires", hospitalEnquires);
		return "my-enquiry";
	}
}
