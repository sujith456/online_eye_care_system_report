package com.cg.onlineeyecare.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineeyecare.dto.Patient;
import com.cg.onlineeyecare.dto.Report;
import com.cg.onlineeyecare.dto.Spectacles;
import com.cg.onlineeyecare.dto.test;
import com.cg.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.cg.onlineeyecare.exceptions.ReportIdNotFoundException;
import com.cg.onlineeyecare.service.IReportService;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.Api;
/************************************************************************************
 *          @author         - M.Sujith
 *          Description     -It is a controller class that controls the data flow into model object 
 *                           and updates the view whenever data changes
 *         Version          - 1.0
 *         Created Date     -22-MARCH-2021
 ************************************************************************************/
@Api(value = "Swagger2ReportRestController")
@RestController
@RequestMapping("/v1")
public class OnlineeyecareController {
	@Autowired
	IReportService Ireportservice;
/************************************************************************************
*        Method:                      - welcome
*        Description:                 - It is used to return a welcome message
*        @returns String              - It returns Welcome to Report module
*        Created By                   - M.sujith
*        Created Date                 - 22-MARCH-2021                            
	 
	 ************************************************************************************/
	@GetMapping("/")
	public  String welcome()
	{
		return "Welcome to Report module";
	}
	/************************************************************************************
	 * Method:                          addReport
         *Description:                      It is used to add Report into Report table
         * @param report:                     Report's reference variable.
	 * @returns Report                    It returns Report with details
	 * @PostMapping:                    It  is used to handle POST type of request method
	 * @RequestBody:                    It maps the HttpRequest body to a transfer or domain object
         *Created By                        - M.sujith
         *Created Date                      - 22-MARCH-2021                            
	 
	 ************************************************************************************/
	@PostMapping("/addreport")
	public Report addReport(@RequestBody Report report)
	{
		return Ireportservice.addReport(report);
	}
	/************************************************************************************
	 * Method:                          updateReport
         *Description:                      It is used to update Report details into Report table.
         * @param report:                     Report's reference variable.
	 * @returns Report:                    It returns updated details of the existed user.
	 * @PutMapping:                    It  is used to handle PUT type of request method
	 * @RequestBody:                    It maps the HttpRequest body to a transfer or domain object
         *Created By                        - M.sujith
         *Created Date                      - 22-MARCH-2021                             
	 
	 ************************************************************************************/
	@PutMapping("/updatereport")
	public Report updateReport(@RequestBody Report report)
	{
		return Ireportservice.updateReport(report);
	}
	@DeleteMapping("/delete/{id}")
	public Report delteReport(@PathVariable int id) throws ReportIdNotFoundException
	{
		return Ireportservice.removeReport(id);
	}
	/************************************************************************************
     * Method:                          findpatientReport
     *Description:                      To display the patient report by reportId (Primary key) & patientId (Primary Key)
     *@param Id1:                        id of the report
     *@param Id2:                        id of the patient
     * @returns Report                  - if Report & Patient with Id presents it returns Report else throws PatientIdFoundNotException or ReportIdNotFoundException
     * @throws ReportIdNotFoundException -  It is raised due to invalid ReportId
     * @throws PatientIdFoundNotException - It is raised due to invalid patientId
     * @GetMapping:                     It is used to is used to handle GET type of request method.
     * @PathVariable:                   It  is used for data passed in the URI and transfer its values to parameter variables.
     *Created By                                - M.Sujith
     *Created Date                            - 22-MARCH-2021                           
	 
	 ************************************************************************************/
	@GetMapping("/report/{Id1}/patient/{Id2}")
	public Report findPatientReport(@PathVariable int Id1,@PathVariable int Id2) throws ReportIdNotFoundException, PatientIdFoundNotException
	{
		return Ireportservice.viewReport(Id1, Id2);
	}
//	@RequestMapping("/allreports")//-----My Method
//	public List<Report> listallreports()
//	{
//		return Ireportservice.viewAllReportNormal();
//	}
	/************************************************************************************
	 * Method:                          -allspectacles
         *Description:                      - To display all spectacles
	 * @returns List<Spectacles>            - It returns all the Spectacles present in database
	 * @GetMapping:                     - It is used to is used to handle GET type of request method.
         *Created By                        - M.sujith
         *Created Date                      - 22-MARCH-2021                           
	 
	 ************************************************************************************/
	@GetMapping("/allspectacles")
	public List<Spectacles> listallspec()
	{
		return Ireportservice.viewSpetacles();
	}
	/************************************************************************************
	 * Method:                          -listallreportbydate
         *Description:                      - To display all the Reports by date
         *@param date:                      - Date of Reports required.
	 * @returns List<Report>            - It returs all the Report present in database for the date
	 * @GetMapping:                     - It is used to is used to handle GET type of request method.
         * @Requestparam:                   - To extract query parameters, form parameters.Declares that a field or method parameter should be formatted as a date or time.
         * @DateTimeFormat:                  - Declares that a field or method parameter should be formatted as a date or time.
         *Created By                        - M.sujith
         *Created Date                      - 22-MARCH-2021                           
	 
	 ************************************************************************************/


	@GetMapping("/allreportsbydate")
	public List<Report> listallreportbydate(@RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date)
	{
		return Ireportservice.viewAllReport(date);
	}



}
