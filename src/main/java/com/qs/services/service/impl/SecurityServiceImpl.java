package com.qs.services.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.qs.services.service.SecurityService;

@Service("SecurityService")
public class SecurityServiceImpl implements SecurityService {
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class) ;

	@Override
	public Boolean authenticate(String userId, String password) {
		// TODO Auto-generated method stub
		logger.info("Inside SecurityService.authenticate(...) : userId=" + userId + " password=" + password) ;
		return null;
	}

}
