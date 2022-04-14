package com.hospital.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * patient_enquiry:
 */
 
//TODO: add @Id field
 
@Entity
@Table(name = "patient_enquiry")


public class PatientEnquiry implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ENQUIRY_ID", nullable = false, length = 16)
	private Integer enquiryId;
	
	@Column(name = "PATIENT_ID", length = 16)
	private Integer patientId;
	
	@Column(name = "HOSPITAL_ID", length = 16)
	private Integer hospitalId;
	
	@Column(name = "DATE_OF_ENQUIRY", nullable = false)
	private String dateOfEnquiry;
	
	@Column(name = "SYMTOMS_DETAIL", nullable = false, length = 512)
	private String symtomsDetail;
	
	@Column(name = "STATUS", length = 5)
	private String status;

	public Integer getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(Integer enquiryId) {
		this.enquiryId = enquiryId;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getDateOfEnquiry() {
		return dateOfEnquiry;
	}

	public void setDateOfEnquiry(String dateOfEnquiry) {
		this.dateOfEnquiry = dateOfEnquiry;
	}

	public String getSymtomsDetail() {
		return symtomsDetail;
	}

	public void setSymtomsDetail(String symtomsDetail) {
		this.symtomsDetail = symtomsDetail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	
}