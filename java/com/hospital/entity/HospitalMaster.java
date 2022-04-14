package com.hospital.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * hospital_master:
 */
 
//TODO: add @Id field
 
@Entity
@Table(name = "hospital_master")


public class HospitalMaster implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HOSPITAL_ID", nullable = false, length = 16)
	private Integer hospitalId;
	
	@Column(name = "USER_ID", nullable = false, length = 16)
	private Integer userId;
	
	@Column(name = "HOSPITAL_NAME", nullable = false, length = 64)
	private String hospitalName;
	
	@Column(name = "CITY", nullable = false, length = 20)
	private String city;
	
	@Column(name = "STATE", length = 20)
	private String state;
	
	@Column(name = "COUNTRY", length = 20)
	private String country;
	
	@Column(name = "PIN_CODE", length = 8)
	private String pinCode;
	
	@Column(name = "CONTACT_NUMBER", nullable = false, length = 12)
	private String contactNumber;
	
	@Column(name = "ADDRESS", nullable = false, length = 50)
	private String address;

	@Column(name = "IS_COVID", length = 1)
	private String isCovid;
	
	@Column(name = "TOTAL_NORMAL_BEDS", nullable = false, length = 4)
	private String totalNormalBeds;
	
	@Column(name = "OCCUPIED_NORMAL_BEDS", nullable = false, length = 4)
	private String occupiedNormalBeds;
	
	@Column(name = "TOTAL_OXYGEN_BEDS", nullable = false, length = 4)
	private String totalOxygenBeds;
	
	@Column(name = "OCCUPIED_OXYGEN_BEDS", nullable = false, length = 4)
	private String occupiedOxygenBeds;
	
	@Column(name = "TOTAL_ICU_BEDS", nullable = false, length = 4)
	private String totalIcuBeds;
	
	@Column(name = "OCCUPIED_ICU_BEDS", nullable = false, length = 4)
	private String occupiedIcuBeds;

	@Transient
	private String email;
	
	@Transient
	private String password;
	
	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getIsCovid() {
		return isCovid;
	}

	public void setIsCovid(String isCovid) {
		this.isCovid = isCovid;
	}

	public String getTotalNormalBeds() {
		return totalNormalBeds;
	}

	public void setTotalNormalBeds(String totalNormalBeds) {
		this.totalNormalBeds = totalNormalBeds;
	}

	public String getOccupiedNormalBeds() {
		return occupiedNormalBeds;
	}

	public void setOccupiedNormalBeds(String occupiedNormalBeds) {
		this.occupiedNormalBeds = occupiedNormalBeds;
	}

	public String getTotalOxygenBeds() {
		return totalOxygenBeds;
	}

	public void setTotalOxygenBeds(String totalOxygenBeds) {
		this.totalOxygenBeds = totalOxygenBeds;
	}

	public String getOccupiedOxygenBeds() {
		return occupiedOxygenBeds;
	}

	public void setOccupiedOxygenBeds(String occupiedOxygenBeds) {
		this.occupiedOxygenBeds = occupiedOxygenBeds;
	}

	public String getTotalIcuBeds() {
		return totalIcuBeds;
	}

	public void setTotalIcuBeds(String totalIcuBeds) {
		this.totalIcuBeds = totalIcuBeds;
	}

	public String getOccupiedIcuBeds() {
		return occupiedIcuBeds;
	}

	public void setOccupiedIcuBeds(String occupiedIcuBeds) {
		this.occupiedIcuBeds = occupiedIcuBeds;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}