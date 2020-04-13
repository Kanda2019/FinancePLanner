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

import com.personal.financeplanner.model.Investment;
import com.personal.financeplanner.service.InvestmentService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InvestmentController {

	Logger logger = LoggerFactory.getLogger(InvestmentController.class);

	@Autowired
	InvestmentService investmentService;


	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/investment",method=RequestMethod.GET, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Investment>> getAllInvestments() throws Exception {
		logger.info("Get All investment :");
		try {
			List<Investment> investment = investmentService.getAllInvestments();
			return new ResponseEntity<List<Investment>>(investment, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}	

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/investment",method=RequestMethod.POST, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> createInvestmentDetails(@RequestBody List<Investment> investmentList) throws Exception {
		logger.info("Create Investment Details :");
		try {
			investmentService.createInvestmentDetails(investmentList);
			return new ResponseEntity<String>("Investment created successfully", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/investment/{investmentId}",method=RequestMethod.DELETE, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<String>deleteInvestmentDetails(@PathVariable String investmentId) throws Exception {
		logger.info("Delete Investment Details :");
		try {
			investmentService.deleteInvestmentDetails(investmentId);
			return new ResponseEntity<String>("Investment deleted successfully", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
