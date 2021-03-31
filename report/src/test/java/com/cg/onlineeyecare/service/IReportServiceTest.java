package com.cg.onlineeyecare.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineeyecare.dto.Patient;
import com.cg.onlineeyecare.dto.Report;
import com.cg.onlineeyecare.dto.test;
import com.cg.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.cg.onlineeyecare.exceptions.ReportIdNotFoundException;
import com.cg.onlineeyecare.service.IReportService;
import com.cg.onlineeyecare.service.IReportServiceimpl;
@SpringBootTest
class IReportServiceTest {
	@Autowired
	private IReportServiceimpl iReportService;
	@Test
	void addReportTest() throws ReportIdNotFoundException, PatientIdFoundNotException
	{
		Report newReport=new Report(9205,LocalDateTime.now(),"think that is covid-19","20m","10m","50m",
				new test(555,"covid-19 test","RT-pcr","it searches for covid",2000),new Patient(455,"sujith",25,955300,"sujith@hm",LocalDate.now(),"sujith@456",
						"sujith123","kolimi_Street"));
//		assertEquals("Report [reportId=9205, dateOfReport=2021-03-22T12:09:48.285062100, descriptionOfReport=think that is covid-19, "
//				+ "visualAcuity=20m, visualAcuityNear=10m, visualAcuityDistance=50m, typeOfTest=test [testId=555, testName=covid-19 test, "
//				+ "testType=RT-pcr, testDescription=it searches for covid, testCost=2000.0], patientId=Patient [patientId=455, patientName=sujith, "
//				+ "patientAge=25, patientMobile=955300, patientEmail=sujith@hm, patientDOB=2021-03-22, patientUserName=sujith@456, "
//				+ "patientPassword=sujith123, address=kolimi_Street]]",newReport.toString());
		assertEquals(9205,iReportService.addReport(newReport).getReportId());
	}
	@Test
	void updateTest()
	{
		Report newReport=new Report(9205,LocalDateTime.now(),"think that is covid-19 that this is conformed","20m","10m","50m",
				new test(555,"covid-19 test","RT-pcr","it searches for covid",2000),
				new Patient(455,"sujith",25,955300,"sujith@hm",LocalDate.now(),"sujith@456","sujith123","kolimi_Street"));
		assertEquals("think that is covid-19 that this is conformed",iReportService.updateReport(newReport).getDescriptionOfReport());
	}
	@Test
	void viewReportsTest() throws ReportIdNotFoundException, PatientIdFoundNotException
	{
		assertEquals("think that is covid-19 that this is conformed",iReportService.viewReport(9205,455).getDescriptionOfReport());
	}
	@Test
	void viewallReportsTest()
	{
		LocalDate date= LocalDate.now(); //.get(0).getVisualAcuity()
		Report tempReport=iReportService.viewAllReport(date).stream().reduce((first, second) -> second).orElse(null);
		assertEquals("20m",tempReport.getVisualAcuity());
	}
	@Test 
	void removeReportTest() throws ReportIdNotFoundException, PatientIdFoundNotException
	{
		assertEquals(9205,iReportService.removeReport(9205).getReportId());
		
	}
	@Test
	void viewSpectales()
	{
		assertEquals(777,iReportService.viewSpetacles().get(0).getSpectaclesId());
	}

}
