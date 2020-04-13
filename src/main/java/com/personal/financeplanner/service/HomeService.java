package com.personal.financeplanner.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

	Logger logger = LoggerFactory.getLogger(HomeService.class);

	public String getOverviewData() {
		String response = "Home page to display the Overview of the Investments and Savings";
		return response;
	}

}
