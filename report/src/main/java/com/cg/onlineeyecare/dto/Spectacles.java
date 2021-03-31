package com.cg.onlineeyecare.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
/************************************************************************************
 *          @author          M Sujith
 *          Description      It is a entity class for Spectacles default constructor, parameterized
 *                           constructor along with getters and setters 
  *         Version             1.0
  *         Created Date    22-March-2020
 ************************************************************************************/

@Entity
public class Spectacles implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id //@GeneratedValue(strategy=GenerationType.AUTO)
	private int spectaclesId;
	private String spectaclesModel;
	private String spectaclesDescription;
	private double spectaclesCost;
	/************************************************************************************
	 * Method:                          Spectacles
     *Description:                      It is used to initialize the empty constructor.
     *Created By                                -M.Sujith
     *Created Date                            - 22-MARCH-2021                           
	 
	 ************************************************************************************/
	public Spectacles() {
		super();
	}

	/************************************************************************************
     * Method:                          Spectacles
	 *Description:                      It is used to initialize the parameterized constructor.
	 * @param spectaclesId                  spectacles's Id
	 * @param spectaclesModel              model of the spectacles 
	 * @param spectaclesDescription       spectacles description 
	 * @param spectaclesCost              Cost of the spectacles
	 *Created By                        - M.Sujith
	 *Created Date                      - 22-MARCH-2021                           
		 
		 ************************************************************************************/
	public Spectacles(int spectaclesId, String spectaclesModel, String spectaclesDescription, double spectaclesCost) {
		super();
		this.spectaclesId = spectaclesId;
		this.spectaclesModel = spectaclesModel;
		this.spectaclesDescription = spectaclesDescription;
		this.spectaclesCost = spectaclesCost;
	}
	/*
	 * Getters and setters for All data fields
	 * 
	 */
	public int getSpectaclesId() {
		return spectaclesId;
	}

	public void setSpectaclesId(int spectaclesId) {
		this.spectaclesId = spectaclesId;
	}

	public String getSpectaclesModel() {
		return spectaclesModel;
	}

	public void setSpectaclesModel(String spectaclesModel) {
		this.spectaclesModel = spectaclesModel;
	}

	public String getSpectaclesDescription() {
		return spectaclesDescription;
	}

	public void setSpectaclesDescription(String spectaclesDescription) {
		this.spectaclesDescription = spectaclesDescription;
	}

	public double getSpectaclesCost() {
		return spectaclesCost;
	}

	public void setSpectaclesCost(double spectaclesCost) {
		this.spectaclesCost = spectaclesCost;
	}
}
