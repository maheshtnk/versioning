package com.example.versioning.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.versioning.exception.TechnicalException;
import com.example.versioning.model.AppModel;
import com.example.versioning.model.myapplication;
import com.example.versioning.service.VersionService;

import io.swagger.annotations.ApiOperation;

@RestController
public class VersionController {
	Logger logger =LoggerFactory.getLogger(VersionController.class);
	
	@Autowired
	VersionService service;
	
	@CrossOrigin
	@ApiOperation(value = "App version with sha details")
	@GetMapping(path="/appInfo",produces = "application/json")
    public AppModel getAppDetails() {
		AppModel response = null;
		try {
			logger.info("Inside getAppDetails");
			response=  service.getAppVersionDetails();
			logger.info("Response :" + response);
		}catch(TechnicalException ex) {
			logger.error("Technical Error returning the data",ex);	
		}catch(Exception ex){
			logger.error("Error processing the data",ex);
		}
			return response;
    }
	

}
