package com.cg.onlineeyecare.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
/************************************************************************************
 *          @author          M Sujith
 *          Description      It is a entity class for Patients default constructor, parameterized
 *                           constructor along with getters and setters 
  *         Version             1.0
  *         Created Date    20-March-2020
 ************************************************************************************/

@Entity
public class Patient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id  //@GeneratedValue(strategy=GenerationType.AUTO)
	private int patientId;
	private String patientName;
	private int patientAge;
	private long patientMobile;
	private String patientEmail;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate patientDOB;
	private String patientUserName;
	private String patientPassword;
	private String address;

	/**
	 * 
	 */
	public Patient() {
		super();
	}

	/**
	 * @param patientId
	 * @param patientName
	 * @param patientAge
	 * @param patientMobile
	 * @param patientEmail
	 * @param patientDOB
	 * @param patientUserName
	 * @param patientPassword
	 * @param address
	 */
	public Patient(int patientId, String patientName, int patientAge, long patientMobile, String patientEmail,
			LocalDate patientDOB, String patientUserName, String patientPassword, String address) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientMobile = patientMobile;
		this.patientEmail = patientEmail;
		this.patientDOB = patientDOB;
		this.patientUserName = patientUserName;
		this.patientPassword = patientPassword;
		this.address = address;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public long getPatientMobile() {
		return patientMobile;
	}

	public void setPatientMobile(long patientMobile) {
		this.patientMobile = patientMobile;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public LocalDate getPatientDOB() {
		return patientDOB;
	}

	public void setPatientDOB(LocalDate patientDOB) {
		this.patientDOB = patientDOB;
	}

	public String getPatientUserName() {
		return patientUserName;
	}

	public void setPatientUserName(String patientUserName) {
		this.patientUserName = patientUserName;
	}

	public String getPatientPassword() {
		return patientPassword;
	}

	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientAge=" + patientAge
				+ ", patientMobile=" + patientMobile + ", patientEmail=" + patientEmail + ", patientDOB=" + patientDOB
				+ ", patientUserName=" + patientUserName + ", patientPassword=" + patientPassword + ", address="
				+ address + "]";
	}
}
