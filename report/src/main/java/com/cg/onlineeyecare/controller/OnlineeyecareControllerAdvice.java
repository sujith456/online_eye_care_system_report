package com.cg.onlineeyecare.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.onlineeyecare.exceptions.AppointmentIdNotFoundException;
import com.cg.onlineeyecare.exceptions.DoctorIdNotFoundException;
import com.cg.onlineeyecare.exceptions.InvalidAppointmentException;
import com.cg.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.cg.onlineeyecare.exceptions.ReportIdNotFoundException;
import com.cg.onlineeyecare.exceptions.TestIdNotFoundException;
/************************************************************************************
 *          @author          M.Sujith
 *          Description      It is a controller advice class that handles the exception occurs at 
 *                           UserNotFoundException,AppointmentIdNotFoundException,DoctorIdNotFoundException, 
 *                           InvalidAppointmentException, PatientIdFoundNotException,ReportIdNotFoundException, 
 *                           TestIdNotFoundException class
 *         Version          - 1.0
 *         Created Date     -22-MARCH-2021
 ************************************************************************************/
@RestControllerAdvice
public class OnlineeyecareControllerAdvice {
	/************************************************************************************
	 * Method:                          onlineeyecare
     *Description:                      It is used to return the exception message and its HTTP status
	 * @returns Response entity         It returns the exception message and its HTTP status.
	 * @param exception                       It is parent class of exception
     *Created By                                - M.Sujith
     *Created Date                            - 22-MARCH-2021                           
	 
	 ************************************************************************************/
	@ExceptionHandler({AppointmentIdNotFoundException.class, DoctorIdNotFoundException.class, InvalidAppointmentException.class,PatientIdFoundNotException.class,ReportIdNotFoundException.class,TestIdNotFoundException.class})
	public ResponseEntity<String> onlineeyecare(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

}
