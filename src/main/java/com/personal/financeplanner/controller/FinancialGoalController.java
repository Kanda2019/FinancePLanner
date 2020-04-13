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

import com.personal.financeplanner.model.FinancialGoal;
import com.personal.financeplanner.service.FinancialGoalService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FinancialGoalController {

	Logger logger = LoggerFactory.getLogger(FinancialGoalController.class);

	@Autowired
	FinancialGoalService financialGoalService;


	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/financialgoals",method=RequestMethod.GET, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<FinancialGoal>> getFinancialgoals() throws Exception {
		logger.info("Get All Financialgoals :");
		try {
			List<FinancialGoal> financialGoal = financialGoalService.getFinancialgoals();
			return new ResponseEntity<List<FinancialGoal>>(financialGoal, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}	

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/financialgoals",method=RequestMethod.POST, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> createFinancialGoal(@RequestBody List<FinancialGoal> financialGoalList) throws Exception {
		logger.info("Create Financialgoals :");
		try {
			financialGoalService.createFinancialgoals(financialGoalList);
			return new ResponseEntity<String>("Financialgoals created successfully", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/financialgoals/{goalId}",method=RequestMethod.DELETE, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<String>deleteFinancialGoal(@PathVariable String goalId) throws Exception {
		logger.info("Delete Financialgoal :");
		try {
			financialGoalService.deleteFinancialgoals(goalId);
			return new ResponseEntity<String>("Financialgoal deleted successfully", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
