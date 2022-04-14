package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entity.HospitalMaster;


//TODO: change primary key datatype

public interface HospitalMasterRepository extends JpaRepository<HospitalMaster, String>{

	HospitalMaster findByUserId(Integer userId);

	HospitalMaster findByHospitalId(Integer hospitalId);

}