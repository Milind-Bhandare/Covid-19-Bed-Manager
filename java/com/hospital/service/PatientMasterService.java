package com.hospital.service;

import java.util.List;

import com.hospital.entity.PatientMaster;

public interface PatientMasterService {

	public List<PatientMaster> getAll();

	public String save(PatientMaster patientMaster);

	public String update(PatientMaster patientMaster);

	public String delete(String patientId); // TODO: recheck id field

	public PatientMaster getByUserId(Integer userId);

	public PatientMaster getByPatientId(Integer patientId);
}