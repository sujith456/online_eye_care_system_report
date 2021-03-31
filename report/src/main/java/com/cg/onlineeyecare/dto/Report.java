package com.cg.onlineeyecare.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.onlineeyecare.dto.Patient;
import com.cg.onlineeyecare.dto.test;
import com.fasterxml.jackson.annotation.JsonFormat;
/************************************************************************************
 *          @author          M Sujith
 *          Description      It is a entity class for Reports
  *         Version             1.0
  *         Created Date    20-March-2020
 ************************************************************************************/



@Entity
	public class Report implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Id //@GeneratedValue(strategy=GenerationType.AUTO)
		private int reportId;
		
		private LocalDateTime dateOfReport;
		private String descriptionOfReport;
		private String visualAcuity;
		private String visualAcuityNear;
		private String visualAcuityDistance;
		/************************************************************************************
		 * Method:                          User
	     *Description:                      It is used to initialize the empty constructor.
	     *Created By                                -M.Sujith
	     *Created Date                            - 22-MARCH-2021                           
		 
		 ************************************************************************************/
		public Report() {
			super();
		}
		/************************************************************************************
     * Method:                          Report
	 *Description:                      It is used to initialize the parameterized constructor.
	 * @param reportId                  report's Id
	 * @param dateOfReport              date of the report 
	 * @param descriptionOfReport       report description 
	 * @param visualAcuity                  
	 * @param visualAcuityNear
	 * @param visualAcuityDistance
	 * @param typeOfTest
	 * @param patientId
	 *Created By                        - M.Sujith
	 *Created Date                      - 22-MARCH-2021                           
		 
		 ************************************************************************************/

		public Report(int reportId, LocalDateTime dateOfReport, String descriptionOfReport, String visualAcuity,
					String visualAcuityNear, String visualAcuityDistance, test typeOfTest, Patient patientId) {
				super();
				this.reportId = reportId;
				this.dateOfReport = dateOfReport;
				this.descriptionOfReport = descriptionOfReport;
				this.visualAcuity = visualAcuity;
				this.visualAcuityNear = visualAcuityNear;
				this.visualAcuityDistance = visualAcuityDistance;
				this.typeOfTest = typeOfTest;
				this.patientId = patientId;
			}
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "test_id", nullable=false)
	private test typeOfTest;

	@ManyToOne(cascade = CascadeType.MERGE)
	//CascadeType.MERGE--this is to update the patient details if it updated
	@JoinColumn(name = "patient_id", nullable=false)
	private Patient patientId;

	/*
	 * Getters and setters for All data fields
	 * 
	 */
	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public LocalDateTime getDateOfReport() {
		return dateOfReport;
	}

	public void setDateOfReport(LocalDateTime dateOfReport) {
		this.dateOfReport = dateOfReport;
	}

	public String getDescriptionOfReport() {
		return descriptionOfReport;
	}

	public void setDescriptionOfReport(String descriptionOfReport) {
		this.descriptionOfReport = descriptionOfReport;
	}

	public String getVisualAcuity() {
		return visualAcuity;
	}

	public void setVisualAcuity(String visualAcuity) {
		this.visualAcuity = visualAcuity;
	}

	public String getVisualAcuityNear() {
		return visualAcuityNear;
	}

	public void setVisualAcuityNear(String visualAcuityNear) {
		this.visualAcuityNear = visualAcuityNear;
	}

	public String getVisualAcuityDistance() {
		return visualAcuityDistance;
	}

	public void setVisualAcuityDistance(String visualAcuityDistance) {
		this.visualAcuityDistance = visualAcuityDistance;
	}




	public test getTypeOfTest() {
		return typeOfTest;
	}
	public void setTypeOfTest(test typeOfTest) {
		this.typeOfTest = typeOfTest;
	}
	public Patient getPatientId() {
		return patientId;
	}

	public void setPatientId(Patient patientId) {
		this.patientId = patientId;
	}

	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", dateOfReport=" + dateOfReport + ", descriptionOfReport="
				+ descriptionOfReport + ", visualAcuity=" + visualAcuity + ", visualAcuityNear=" + visualAcuityNear
				+ ", visualAcuityDistance=" + visualAcuityDistance + ", typeOfTest=" + typeOfTest + ", patientId="
				+ patientId + "]";
	}



}
