package com.example.versioning.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Service;


import com.example.versioning.exception.TechnicalException;
import com.example.versioning.model.AppModel;
import com.example.versioning.model.myapplication;
import com.example.versioning.constants.VersionConstants;
/**
 * Executes the request and sends out the data
 * 
 **/
@Service
public class VersionService {
	Logger logger = LoggerFactory.getLogger(VersionService.class);
	
	@Autowired
	AppModel appinfo;
	
	@Autowired
	myapplication myapplication;
	
	@Autowired
	BuildProperties buildProperties;
	
	 @Value("${git.commit.id}")
	 private String commitId;
	
	
	/**
	 * @param NA
	 * @return version,lastcommitsha,desc
	 */
	public AppModel getAppVersionDetails() throws TechnicalException {
		List lst = new ArrayList();
		try {
			myapplication.setAppVersion(buildProperties.getVersion());
			myapplication.setLastcommitsha(commitId);
			myapplication.setDescription(VersionConstants.Desc);
			lst.add(myapplication);
			appinfo.setmyapplication(lst);
		} catch (Exception ex) {
			throw new TechnicalException("Error processing..");
		}
		return appinfo;
	}
	


}
