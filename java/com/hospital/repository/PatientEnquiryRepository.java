package com.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entity.PatientEnquiry;


//TODO: change primary key datatype

public interface PatientEnquiryRepository extends JpaRepository<PatientEnquiry, String>{

	List<PatientEnquiry> findAllByHospitalIdAndStatus(Integer hospitalId, String status);

	PatientEnquiry findByEnquiryId(Integer enquiryId);

	List<PatientEnquiry> findAllByPatientId(Integer patientId);

}