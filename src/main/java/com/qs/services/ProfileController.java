package com.qs.services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qs.services.domain.DataResult;
import com.qs.services.domain.SalesRep;
import com.qs.services.service.ProfileService;
import com.qs.services.util.ServiceUtil;

@Controller
public class ProfileController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
	
	@Autowired
	private ProfileService service ;
	
	@RequestMapping(value = "/salesreps", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public DataResult getProfile(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String salesRepId = request.getParameter("salesRepId") ;
		DataResult result = null ;
		if(salesRepId != null){
			logger.info("Call to [GET] profile with salesRepId=" + salesRepId);
			SalesRep salesRep = service.getSalesRep(salesRepId);
			result = ServiceUtil.successResult(salesRep);
		} else {
			result = ServiceUtil.errorResult(HttpStatus.BAD_REQUEST, "Sales Rep Id must be provided") ;
		}
		
		logger.info("Result of call to get the profile for (" + salesRepId + ") : " + result.getData());
		return result ;
	}
	
}
