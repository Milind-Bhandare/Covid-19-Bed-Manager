package com.hospital.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * user_master:
 */
 
 
@Entity
@Table(name = "user_master")

public class UserMaster implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false)
	private Integer userId;
	
	@Column(name = "email", nullable = false, length = 50)
	private String email;
	
	@Column(name = "password", length = 50)
	private String password;
	
	@Column(name = "user_type", length = 50)
	private String userType;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
}