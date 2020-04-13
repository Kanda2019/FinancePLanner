package com.personal.financeplanner.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.personal.financeplanner.service.HomeService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	HomeService homeService;


	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/getAll",method=RequestMethod.GET, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> getOverviewData() throws Exception {
		logger.info("Get All Details :");
		try {
			String response = homeService.getOverviewData();
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}	
}
