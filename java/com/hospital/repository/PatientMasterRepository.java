package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entity.PatientMaster;


//TODO: change primary key datatype

public interface PatientMasterRepository extends JpaRepository<PatientMaster, String>{

	PatientMaster findByUserId(Integer userId);

	PatientMaster findByPatientId(Integer patientId);

}