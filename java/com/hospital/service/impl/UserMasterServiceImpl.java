package com.hospital.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hospital.entity.UserMaster;
import com.hospital.repository.UserMasterRepository;
import com.hospital.service.UserMasterService;

@Service
public class UserMasterServiceImpl implements UserMasterService {

	static final Logger logger = LoggerFactory.getLogger(UserMasterServiceImpl.class);
	private UserMasterRepository userMasterRepository;

	public UserMasterServiceImpl(UserMasterRepository userMasterRepository) {
		super();
		this.userMasterRepository = userMasterRepository;
	}

	@Override
	public List<UserMaster> getAll() {
		logger.info("Fetching data...");
		return userMasterRepository.findAll();
	}

	@Override
	public UserMaster save(UserMaster userMaster) {
		String result = "";
		try {
			logger.info("Saving record...");
			logger.debug("Printing details Before Save : ["+userMaster+"]");
			
			userMaster = userMasterRepository.save(userMaster);
			
			logger.debug("Printing details After Save : ["+userMaster+"]");
			logger.info("Data Saved successfully !");
			result = "Saved successfully!..";
		} catch (Exception e) {
			logger.error("Exception while saving ",e);
			result = "Problem in saving record : ["+e.getMessage()+"]";
		}
		return userMaster;
	}

	@Override
	public String update(UserMaster userMaster) {
		String result = "";
		try {
			logger.info("Updating record...");
			logger.debug("Printing details Before Update : ["+userMaster+"]");
			
			userMasterRepository.save(userMaster);
			
			logger.debug("Printing details After Update : ["+userMaster+"]");
			logger.info("Data Updated successfully !");
			result = "Updated successfully!..";
		} catch (Exception e) {
			logger.error("Exception while Updating ",e);
			result = "Problem in updating record : ["+e.getMessage()+"]";
		}
		return result;
	}

	@Override
	public String delete(String userId) { // TODO: recheck id field
		String result = "";
		try {
			logger.info("Deleting record...");
			logger.debug("Printing ID Before Delete : ["+userId+"]");
			
			userMasterRepository.deleteById(userId); // TODO: recheck id field
			
			logger.info("Data Deleted successfully !");
			result = "Deleted successfully!..";
		} catch (Exception e) {
			logger.error("Exception while Deleting ",e);
			result = "Problem in deleting record : ["+e.getMessage()+"]";
		}
		return result;
	}

	@Override
	public UserMaster findByEmailAndPassword(String email, String password) {
		return userMasterRepository.findByEmailAndPassword(email, password);
	}

}