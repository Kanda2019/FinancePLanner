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

import com.personal.financeplanner.model.Insurance;
import com.personal.financeplanner.service.InsuranceService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InsuranceController {

	Logger logger = LoggerFactory.getLogger(InsuranceController.class);

	@Autowired
	InsuranceService insuranceService;


	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/insurance",method=RequestMethod.GET, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Insurance>> getInsuranceDetails() throws Exception {
		logger.info("Get All insurance :");
		try {
			List<Insurance> insurance = insuranceService.getInsuranceDetails();
			return new ResponseEntity<List<Insurance>>(insurance, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}	

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/insurance",method=RequestMethod.POST, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> createInsuranceDetails(@RequestBody List<Insurance> insuranceList) throws Exception {
		logger.info("Create insurance Details :");
		try {
			insuranceService.createInsuranceDetails(insuranceList);
			return new ResponseEntity<String>("insurance created successfully", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/insurance/{insuranceId}",method=RequestMethod.DELETE, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<String>deleteInsuranceDetails(@PathVariable String insuranceId) throws Exception {
		logger.info("Delete insurance Details :");
		try {
			insuranceService.deleteInsuranceDetails(insuranceId);
			return new ResponseEntity<String>("insurance deleted successfully", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
