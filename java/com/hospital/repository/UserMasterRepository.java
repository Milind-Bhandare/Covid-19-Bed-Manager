package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entity.UserMaster;

//TODO: change primary key datatype

public interface UserMasterRepository extends JpaRepository<UserMaster, String>{

	UserMaster findByEmailAndPassword(String email, String password);

}