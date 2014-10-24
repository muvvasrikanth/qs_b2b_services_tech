package com.qs.services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.qs.services.service.SecurityService;

public class BaseController {
	
	@Autowired
	private SecurityService securityService ;
	
	protected void authenticate(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		String xauth = request.getParameter("x-auth") ;
		String[] xatokens = xauth.split(":") ;
		if(! securityService.authenticate(xatokens[0], xatokens[1])){
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
		}
	}

}
