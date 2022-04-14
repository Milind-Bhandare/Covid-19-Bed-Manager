package com.hospital.service;

import java.util.List;

import com.hospital.entity.UserMaster;

public interface UserMasterService {

	public List<UserMaster> getAll();

	public UserMaster save(UserMaster userMaster);

	public String update(UserMaster userMaster);

	public String delete(String userId); // TODO: recheck id field
	
	public UserMaster findByEmailAndPassword(String email, String password);
}