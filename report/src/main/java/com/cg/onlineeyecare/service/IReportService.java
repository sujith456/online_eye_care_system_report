package com.cg.onlineeyecare.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.onlineeyecare.dto.Report;
import com.cg.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.cg.onlineeyecare.exceptions.ReportIdNotFoundException;
import com.cg.onlineeyecare.dto.Spectacles;
/************************************************************************************
 *          @author          M. Sujith
 *          Description      It is a Report service interface that describes the abstract methods
 *                           used in its implementation class.
 *         Version             1.0
 *         Created Date    22-MARCH-2021
 ************************************************************************************/
public interface IReportService {
	Report addReport(Report report);

	Report updateReport(Report report);

	Report removeReport(int reportId)throws ReportIdNotFoundException;

	Report viewReport(int reportId, int patientId)throws ReportIdNotFoundException,PatientIdFoundNotException;

	List<Report> viewAllReport(LocalDate date);

	List<Spectacles>  viewSpetacles();


}
