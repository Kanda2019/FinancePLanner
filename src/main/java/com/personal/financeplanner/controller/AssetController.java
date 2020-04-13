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

import com.personal.financeplanner.model.Asset;
import com.personal.financeplanner.service.AssetService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AssetController {

	Logger logger = LoggerFactory.getLogger(AssetController.class);

	@Autowired
	AssetService assetService;


	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/assets",method=RequestMethod.GET, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Asset>> getAssetDetails() throws Exception {
		logger.info("Get Asset Details :");
		try {
			List<Asset> asset = assetService.getAssetDetails();
			return new ResponseEntity<List<Asset>>(asset, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/assets",method=RequestMethod.POST, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> createAssets(@RequestBody List<Asset> assetList) throws Exception {
		logger.info("Create Asset Details :");
		try {
			assetService.createAssets(assetList);
			return new ResponseEntity<String>("Assets created successfully", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/assets/{assetId}",method=RequestMethod.DELETE, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<String>deleteAssets(@PathVariable String assetId) throws Exception {
		logger.info("Delete Asset Details :");
		try {
			assetService.deleteAssets(assetId);
			return new ResponseEntity<String>("Assets deleted successfully", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
