package com.cg.onlineeyecare.service;

import java.time.LocalDate;

/************************************************************************************
 *          @author          M Sujith
 *          Description      It is a service class that provides the services for adding anew report, 
                                        update, delete, view all reports, view report by date.
  *         Version             1.0
  *         Created Date    02-APR-2020
 ************************************************************************************/

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineeyecare.dao.IReportRepository;
import com.cg.onlineeyecare.dto.Patient;
import com.cg.onlineeyecare.dto.Report;
import com.cg.onlineeyecare.dto.Spectacles;
import com.cg.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.cg.onlineeyecare.exceptions.ReportIdNotFoundException;
@Service
public class IReportServiceimpl implements IReportService {
	@Autowired
	private IReportRepository Ireportrepository;

	/************************************************************************************
	 * Method:                          addReport
     *Description:                      It is used to add report into Report table
     * @param report:                     Report's reference variable.
	 * @returns Report                    It returns report with details
     *Created By                      - M.Sujith
     *Created Date                    - 22-MARCH-2021                           
	 
	 ************************************************************************************/
	@Override
	public Report addReport(Report report) {
		// TODO Auto-generated method stub
		return Ireportrepository.saveAndFlush(report);
	}
	/************************************************************************************
	 * Method:                          updateReport
     *Description:                      It is used to update report details into Report table.
     * @param report:                     report's reference variable.
	 * @returns Report                    It returns updated details of the existed report.
     *Created By                      - M.Sujith
     *Created Date                    - 22-MARCH-2021                           
	 
	 ************************************************************************************/
	@Override
	public Report updateReport(Report report) {
		// TODO Auto-generated method stub
		return Ireportrepository.saveAndFlush(report);
	}
	/************************************************************************************
	 * Method:                          removeReport
     *Description:                      It is used to remove report
     *@param report:                      report's reference variable.
	 * @returns Report                    It returns the report that has been deleted
	 * @throws ReportIdNotFoundException: It is raised due to invalid report.
     *Created By                      - M.Sujith
     *Created Date                    - 22-MARCH-2021                           
	 
	 ************************************************************************************/
	@Override
	public Report removeReport(int reportId) throws ReportIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Report> result=Ireportrepository.findById(reportId);
		if(result.isPresent())
		{
			Ireportrepository.deleteById(reportId);
			return result.get();
		}
		else
		{
			throw new ReportIdNotFoundException("please enter valid report id");
		}
	}

	/************************************************************************************
	 * Method:                          viewSpectacles
     *Description:                      To display all the spectacles
	 * @returns List<Spectacles>            - It returns all the spectacles present in database
     *Created By                      - M.Sujith
     *Created Date                     - 22-MARCH-2021                           
	 
	 ************************************************************************************/
	@Override
	public List<Spectacles> viewSpetacles() {
		// TODO Auto-generated method stub
		return Ireportrepository.findAllSpectacles();
	}
	/************************************************************************************
	 * Method:                          viewAllReport
     *Description:                      To display all the report's
     *@param date:                      date of the  reference variable.
	 * @returns List<Report>            - It returns all the reports present in database
     *Created By                      - M.Sujith
     *Created Date                     - 22-MARCH-2021                           
	 
	 ************************************************************************************/
	@Override
	public List<Report> viewAllReport(LocalDate date) {
		// TODO Auto-generated method stub
		return Ireportrepository.findAll().stream().filter(report->(date.compareTo(report.getDateOfReport().toLocalDate())==0)).collect(Collectors.toList());
	}
	/************************************************************************************
	 * Method:                             viewReport
     *Description:                        To display report of that reportId & patientId
     *@param reportId:                    report's Id.
     *@param patientId:                   patient's Id.
	 *@returns Report:                   -It return the report present in database
	 *@throws ReportIdNotFoundException:  It is raised due to invalid reportId.
	 *@throws ReportIdNotFoundException:  It is raised due to invalid patirntId.

     *Created By                      - M.Sujith
     *Created Date                     - 22-MARCH-2021                           
	 
	 ************************************************************************************/
	@Override
	public Report viewReport(int reportId, int patientId) throws ReportIdNotFoundException, PatientIdFoundNotException {
		// TODO Auto-generated method stub
		Optional<Report> result1=Ireportrepository.findById(reportId);
		Patient result2=Ireportrepository.findById(reportId).get().getPatientId();
		if(result1.isPresent())
		{
			if(result2.getPatientId()==patientId)
			{
				return result1.get();
			}
			else
			{
				throw new PatientIdFoundNotException("Please enter valid patient id!");
			}
		}
		else
		{
			throw new ReportIdNotFoundException("Please enter valid report id!");
		}

	}

}
