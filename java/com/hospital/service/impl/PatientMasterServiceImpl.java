package com.hospital.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hospital.entity.PatientMaster;
import com.hospital.repository.PatientMasterRepository;
import com.hospital.service.PatientMasterService;

@Service
public class PatientMasterServiceImpl implements PatientMasterService {

	static final Logger logger = LoggerFactory.getLogger(PatientMasterServiceImpl.class);
	private PatientMasterRepository patientMasterRepository;

	public PatientMasterServiceImpl(PatientMasterRepository patientMasterRepository) {
		super();
		this.patientMasterRepository = patientMasterRepository;
	}

	@Override
	public List<PatientMaster> getAll() {
		logger.info("Fetching data...");
		return patientMasterRepository.findAll();
	}

	@Override
	public String save(PatientMaster patientMaster) {
		String result = "";
		try {
			logger.info("Saving record...");
			logger.debug("Printing details Before Save : ["+patientMaster+"]");
			
			patientMasterRepository.save(patientMaster);
			
			logger.debug("Printing details After Save : ["+patientMaster+"]");
			logger.info("Data Saved successfully !");
			result = "Saved successfully!..";
		} catch (Exception e) {
			logger.error("Exception while saving ",e);
			result = "Problem in saving record : ["+e.getMessage()+"]";
		}
		return result;
	}

	@Override
	public String update(PatientMaster patientMaster) {
		String result = "";
		try {
			logger.info("Updating record...");
			logger.debug("Printing details Before Update : ["+patientMaster+"]");
			
			patientMasterRepository.save(patientMaster);
			
			logger.debug("Printing details After Update : ["+patientMaster+"]");
			logger.info("Data Updated successfully !");
			result = "Updated successfully!..";
		} catch (Exception e) {
			logger.error("Exception while Updating ",e);
			result = "Problem in updating record : ["+e.getMessage()+"]";
		}
		return result;
	}

	@Override
	public String delete(String patientId) { // TODO: recheck id field
		String result = "";
		try {
			logger.info("Deleting record...");
			logger.debug("Printing ID Before Delete : ["+patientId+"]");
			
			patientMasterRepository.deleteById(patientId); // TODO: recheck id field
			
			logger.info("Data Deleted successfully !");
			result = "Deleted successfully!..";
		} catch (Exception e) {
			logger.error("Exception while Deleting ",e);
			result = "Problem in deleting record : ["+e.getMessage()+"]";
		}
		return result;
	}

	@Override
	public PatientMaster getByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return patientMasterRepository.findByUserId(userId);
	}

	@Override
	public PatientMaster getByPatientId(Integer patientId) {
		// TODO Auto-generated method stub
		return patientMasterRepository.findByPatientId(patientId);
	}

}