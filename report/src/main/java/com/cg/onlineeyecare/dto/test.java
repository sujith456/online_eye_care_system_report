package com.cg.onlineeyecare.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
/************************************************************************************
 *          @author          M Sujith
 *          Description      It is a entity class for Test default constructor, parameterized
 *                           constructor along with getters and setters 
  *         Version             1.0
  *         Created Date    20-March-2020
 ************************************************************************************/

@Entity
public class test implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id //@GeneratedValue(strategy=GenerationType.AUTO)
	private int testId;
	private String testName;
	private String testType;
	private String testDescription;
	private double testCost;

	/**
	 * 
	 */
	public test() {
		super();
	}

	/**
	 * @param testId
	 * @param testName
	 * @param testType
	 * @param testDescription
	 * @param testCost
	 */
	public test(int testId, String testName, String testType, String testDescription, double testCost) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.testType = testType;
		this.testDescription = testDescription;
		this.testCost = testCost;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getTestDescription() {
		return testDescription;
	}

	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}

	public double getTestCost() {
		return testCost;
	}

	public void setTestCost(double testCost) {
		this.testCost = testCost;
	}

	@Override
	public String toString() {
		return "test [testId=" + testId + ", testName=" + testName + ", testType=" + testType + ", testDescription="
				+ testDescription + ", testCost=" + testCost + "]";
	}
}
