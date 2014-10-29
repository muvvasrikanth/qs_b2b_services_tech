package com.qs.services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qs.services.domain.SalesRep;
import com.qs.services.service.ProfileService;

@Controller
public class ProfileController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
	
	@Autowired
	private ProfileService service ;
	
	@RequestMapping(value = "/salesreps/{salesRepId:.+}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public SalesRep getProfile(@PathVariable String salesRepId, 
	        HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		logger.info("Call to [GET] profile with salesRepId=" + salesRepId);
		
		return service.getSalesRep(salesRepId) ;
	}
	
}
