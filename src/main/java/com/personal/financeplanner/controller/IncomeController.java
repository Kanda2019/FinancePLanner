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

import com.personal.financeplanner.model.Income;
import com.personal.financeplanner.service.IncomeService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IncomeController {

	Logger logger = LoggerFactory.getLogger(IncomeController.class);

	@Autowired
	IncomeService incomeService;


	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/incomedetails",method=RequestMethod.GET, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Income>> getIncomeDetails() throws Exception {
		logger.info("getIncomeDetails ::::::::::");
		try {
			List<Income> income = incomeService.getIncomeDetails();
			return new ResponseEntity<List<Income>>(income, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/incomedetails",method=RequestMethod.POST, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> createIncomeDetails(@RequestBody List<Income> incomeList) throws Exception {
		logger.info("Create Income Details :");
		try {
			incomeService.createIncomeDetails(incomeList);
			return new ResponseEntity<String>("Income created successfully", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/incomedetails/{incomeId}",method=RequestMethod.DELETE, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<String>deleteIncomeDetails(@PathVariable String incomeId) throws Exception {
		logger.info("Delete Income Details :");
		try {
			incomeService.deleteIncomeDetails(incomeId);
			return new ResponseEntity<String>("Income deleted successfully", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
