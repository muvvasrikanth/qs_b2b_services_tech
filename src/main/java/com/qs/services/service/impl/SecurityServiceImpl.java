package com.qs.services.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qs.services.service.SecurityService;

@Service("SecurityService")
public class SecurityServiceImpl implements SecurityService {
	
	@Autowired
	private RestTemplate template ;
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class) ;

	@Override
	public Boolean authenticate(String userId, String password) {
		logger.info("Inside SecurityService.authenticate(...) : userId=" + userId + " password=" + password) ;
		
		return true ;
	}

}
