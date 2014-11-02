package com.qs.services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.qs.services.service.SecurityService;

public class BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@Autowired
	private SecurityService securityService ;
	
	protected void authenticate(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		String auth = request.getHeader("x-auth") ;
		if(auth == null){
			logger.warn("Authentication header missing");
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		} else { 
			String[] authTokens = auth.split(":") ;
			if(authTokens == null || authTokens.length != 2 || ! "mobile_user".equals(authTokens[0]) || ! "Quiksilver1".equals(authTokens[1])){
				logger.warn("Authentication header (" + auth + ") was bad authentication failed") ;
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			}
		}
	}

}
