package com.hospital.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hospital.entity.HospitalMaster;
import com.hospital.entity.PatientEnquiry;
import com.hospital.repository.PatientEnquiryRepository;
import com.hospital.service.PatientEnquiryService;

@Service
public class PatientEnquiryServiceImpl implements PatientEnquiryService {

	static final Logger logger = LoggerFactory.getLogger(PatientEnquiryServiceImpl.class);
	private PatientEnquiryRepository patientEnquiryRepository;

	public PatientEnquiryServiceImpl(PatientEnquiryRepository patientEnquiryRepository) {
		super();
		this.patientEnquiryRepository = patientEnquiryRepository;
	}

	@Override
	public List<PatientEnquiry> getAll() {
		logger.info("Fetching data...");
		return patientEnquiryRepository.findAll();
	}

	@Override
	public String save(PatientEnquiry patientEnquiry) {
		String result = "";
		try {
			logger.info("Saving record...");
			logger.debug("Printing details Before Save : ["+patientEnquiry+"]");
			
			patientEnquiryRepository.save(patientEnquiry);
			
			logger.debug("Printing details After Save : ["+patientEnquiry+"]");
			logger.info("Data Saved successfully !");
			result = "Saved successfully!..";
		} catch (Exception e) {
			logger.error("Exception while saving ",e);
			result = "Problem in saving record : ["+e.getMessage()+"]";
		}
		return result;
	}

	@Override
	public String update(PatientEnquiry patientEnquiry) {
		String result = "";
		try {
			logger.info("Updating record...");
			logger.debug("Printing details Before Update : ["+patientEnquiry+"]");
			
			patientEnquiryRepository.save(patientEnquiry);
			
			logger.debug("Printing details After Update : ["+patientEnquiry+"]");
			logger.info("Data Updated successfully !");
			result = "Updated successfully!..";
		} catch (Exception e) {
			logger.error("Exception while Updating ",e);
			result = "Problem in updating record : ["+e.getMessage()+"]";
		}
		return result;
	}

	@Override
	public String delete(String enquiryId) { // TODO: recheck id field
		String result = "";
		try {
			logger.info("Deleting record...");
			logger.debug("Printing ID Before Delete : ["+enquiryId+"]");
			
			patientEnquiryRepository.deleteById(enquiryId); // TODO: recheck id field
			
			logger.info("Data Deleted successfully !");
			result = "Deleted successfully!..";
		} catch (Exception e) {
			logger.error("Exception while Deleting ",e);
			result = "Problem in deleting record : ["+e.getMessage()+"]";
		}
		return result;
	}

	@Override
	public List<PatientEnquiry> getByHospitalId(Integer hospitalId) {
		// TODO Auto-generated method stub
		return patientEnquiryRepository.findAllByHospitalIdAndStatus(hospitalId, "open");
	}

	@Override
	public PatientEnquiry getByEnquiryId(Integer enquiryId) {
		// TODO Auto-generated method stub
		return patientEnquiryRepository.findByEnquiryId(enquiryId);
	}

	@Override
	public List<PatientEnquiry> getByPatientId(Integer patientId) {
		// TODO Auto-generated method stub
		return patientEnquiryRepository.findAllByPatientId(patientId);
	}

}