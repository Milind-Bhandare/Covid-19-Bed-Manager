package com.hospital.service;

import java.util.List;

import com.hospital.entity.HospitalMaster;

public interface HospitalMasterService {

	public List<HospitalMaster> getAll();

	public String save(HospitalMaster hospitalMaster);

	public String update(HospitalMaster hospitalMaster);

	public String delete(String hospitalId); // TODO: recheck id field

	public HospitalMaster getByUserId(Integer userId);

	public HospitalMaster getByHospitalId(Integer hospitalId);
}