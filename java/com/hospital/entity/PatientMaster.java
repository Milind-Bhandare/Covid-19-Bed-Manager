package com.hospital.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * patient_master:
 */
 
//TODO: add @Id field
 
@Entity
@Table(name = "patient_master")


public class PatientMaster implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PATIENT_ID", nullable = false, length = 16)
	private Integer patientId;
	
	@Column(name = "USER_ID", length = 16)
	private Integer userId;
	
	@Column(name = "PATIENT_NAME", nullable = false, length = 64)
	private String patientName;
	
	@Column(name = "GENDER", length = 8)
	private String gender;
	
	@Column(name = "CONTACT_NUMBER", nullable = false, length = 12)
	private String contactNumber;
	
	@Column(name = "CITY", nullable = false, length = 20)
	private String city;
	
	@Column(name = "STATE", length = 20)
	private String state;
	
	@Column(name = "ADDRESS", length = 50)
	private String address;

	@Column(name = "COUNTRY", length = 20)
	private String country;
	
	@Column(name = "PIN_CODE", length = 8)
	private String pinCode;

	@Transient
	private String email;
	
	@Transient
	private String password;
	
	
	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}