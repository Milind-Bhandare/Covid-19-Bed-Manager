package com.hospital.service;

import java.util.List;

import com.hospital.entity.HospitalMaster;
import com.hospital.entity.PatientEnquiry;

public interface PatientEnquiryService {

	public List<PatientEnquiry> getAll();

	public String save(PatientEnquiry patientEnquiry);

	public String update(PatientEnquiry patientEnquiry);

	public String delete(String enquiryId); // TODO: recheck id field

	public List<PatientEnquiry> getByHospitalId(Integer byUserId);

	public PatientEnquiry getByEnquiryId(Integer enquiryId);

	public List<PatientEnquiry> getByPatientId(Integer patientId);
}