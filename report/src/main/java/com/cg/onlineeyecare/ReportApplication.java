package com.cg.onlineeyecare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.onlineeyecare.dto.Report;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication
public class ReportApplication {

	public static void main(String[] args) {
	SpringApplication.run(ReportApplication.class,args);
	}

}