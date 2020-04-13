package com.personal.financeplanner.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.personal.financeplanner.model.FinancialPlan;
import com.personal.financeplanner.service.FinancialPlanService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FinancialPlanController {

	Logger logger = LoggerFactory.getLogger(FinancialPlanController.class);

	@Autowired
	FinancialPlanService financialPlanService;


	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/financialplan",method=RequestMethod.GET, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<FinancialPlan>> getFinancialPlans() throws Exception {
		logger.info("Get All FinancialPlans :");
		try {
			List<FinancialPlan> financialPlan = financialPlanService.getFinancialPlans();
			return new ResponseEntity<List<FinancialPlan>>(financialPlan, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/financialplan",method=RequestMethod.POST, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> createFinancialPlan(@RequestBody List<FinancialPlan> financialPlanList) throws Exception {
		logger.info("Create FinancialPlan :");
		try {
			financialPlanService.createFinancialPlan(financialPlanList);
			return new ResponseEntity<String>("FinancialPlan created successfully", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/financialplan/{planId}",method=RequestMethod.DELETE, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<String>deleteFinancialplan(@PathVariable String planId) throws Exception {
		logger.info("Delete FinancialPlan :");
		try {
			financialPlanService.deleteFinancialplan(planId);
			return new ResponseEntity<String>("FinancialPlan deleted successfully", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
