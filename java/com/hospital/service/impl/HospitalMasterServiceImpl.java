package com.hospital.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hospital.entity.HospitalMaster;
import com.hospital.repository.HospitalMasterRepository;
import com.hospital.service.HospitalMasterService;

@Service
public class HospitalMasterServiceImpl implements HospitalMasterService {

	static final Logger logger = LoggerFactory.getLogger(HospitalMasterServiceImpl.class);
	private HospitalMasterRepository hospitalMasterRepository;

	public HospitalMasterServiceImpl(HospitalMasterRepository hospitalMasterRepository) {
		super();
		this.hospitalMasterRepository = hospitalMasterRepository;
	}

	@Override
	public List<HospitalMaster> getAll() {
		logger.info("Fetching data...");
		return hospitalMasterRepository.findAll();
	}

	@Override
	public String save(HospitalMaster hospitalMaster) {
		String result = "";
		try {
			logger.info("Saving record...");
			logger.debug("Printing details Before Save : ["+hospitalMaster+"]");
			
			hospitalMasterRepository.save(hospitalMaster);
			
			logger.debug("Printing details After Save : ["+hospitalMaster+"]");
			logger.info("Data Saved successfully !");
			result = "Saved successfully!..";
		} catch (Exception e) {
			logger.error("Exception while saving ",e);
			result = "Problem in saving record : ["+e.getMessage()+"]";
		}
		return result;
	}

	@Override
	public String update(HospitalMaster hospitalMaster) {
		String result = "";
		try {
			logger.info("Updating record...");
			logger.debug("Printing details Before Update : ["+hospitalMaster+"]");
			
			hospitalMasterRepository.save(hospitalMaster);
			
			logger.debug("Printing details After Update : ["+hospitalMaster+"]");
			logger.info("Data Updated successfully !");
			result = "Updated successfully!..";
		} catch (Exception e) {
			logger.error("Exception while Updating ",e);
			result = "Problem in updating record : ["+e.getMessage()+"]";
		}
		return result;
	}

	@Override
	public String delete(String hospitalId) { // TODO: recheck id field
		String result = "";
		try {
			logger.info("Deleting record...");
			logger.debug("Printing ID Before Delete : ["+hospitalId+"]");
			
			hospitalMasterRepository.deleteById(hospitalId); // TODO: recheck id field
			
			logger.info("Data Deleted successfully !");
			result = "Deleted successfully!..";
		} catch (Exception e) {
			logger.error("Exception while Deleting ",e);
			result = "Problem in deleting record : ["+e.getMessage()+"]";
		}
		return result;
	}

	@Override
	public HospitalMaster getByUserId(Integer userId) {
		return hospitalMasterRepository.findByUserId(userId);
	}

	@Override
	public HospitalMaster getByHospitalId(Integer hospitalId) {
		// TODO Auto-generated method stub
		return hospitalMasterRepository.findByHospitalId(hospitalId);
	}

}