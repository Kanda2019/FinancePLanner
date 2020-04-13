package com.personal.financeplanner.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.personal.financeplanner.model.LoginRequest;

@RestController
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="auth/login",method=RequestMethod.POST,
			produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<Map<String,Object>> getStockById(LoginRequest loginRequest)
			throws Exception {
		try {
			loginRequest.getUserName();
			return new ResponseEntity<Map<String,Object>>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
	}	

}
