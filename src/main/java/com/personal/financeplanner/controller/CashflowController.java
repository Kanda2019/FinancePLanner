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

import com.personal.financeplanner.model.Cashflow;
import com.personal.financeplanner.service.CashflowService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CashflowController {

	Logger logger = LoggerFactory.getLogger(CashflowController.class);

	@Autowired
	CashflowService cashflowService;


	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/cashflow",method=RequestMethod.GET, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Cashflow>> getAllCashflows() throws Exception {
		logger.info("Get All Cashflow :");
		try {
			List<Cashflow> cashflow = cashflowService.getAllCashflows();
			return new ResponseEntity<List<Cashflow>>(cashflow, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}	

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/cashflow",method=RequestMethod.POST, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> createCashflow(@RequestBody List<Cashflow> cashflowList) throws Exception {
		logger.info("Create Cashflow Details :");
		try {
			cashflowService.createCashflow(cashflowList);
			return new ResponseEntity<String>("Cashflow created successfully", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/cashflow/{cashflowId}",method=RequestMethod.DELETE, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<String>deleteCashflow(@PathVariable String cashflowId) throws Exception {
		logger.info("Delete Cashflow Details :");
		try {
			cashflowService.deleteCashflow(cashflowId);
			return new ResponseEntity<String>("Cashflow deleted successfully", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
