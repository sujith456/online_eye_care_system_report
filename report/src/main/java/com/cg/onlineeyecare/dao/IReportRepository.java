package com.cg.onlineeyecare.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlineeyecare.dto.Patient;
import com.cg.onlineeyecare.dto.Report;
import com.cg.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.cg.onlineeyecare.exceptions.ReportIdNotFoundException;
import com.cg.onlineeyecare.dto.Spectacles;
/************************************************************************************
 *          @author          M.Sujith
 *          Description      It is a Report repository interface that extends jpa repository 
 *                           that contains inbuilt methods for various operations
  *         Version             1.0
  *         Created Date    22-MARCH-2021
 ************************************************************************************/
@Repository
public interface IReportRepository extends  JpaRepository<Report,Integer>{
	/************************************************************************************
	 * Method:                          findAllSpectacles
     *Description:                      To get all the Spectacles 
     *returns List<Spectacles>         It returns all the Spectacles present in database
     *Created By                       - M.Sujith
     *Created Date                     - 22-MARCH-2021                           
	 ************************************************************************************/
	@Query("SELECT Spec FROM Spectacles Spec")
	List<Spectacles> findAllSpectacles();

}
