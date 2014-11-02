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

import com.qs.services.domain.DataResult;
import com.qs.services.domain.SalesRep;
import com.qs.services.service.ProfileService;
import com.qs.services.util.ServiceUtil;

@Controller
public class ProfileController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
	
	@Autowired
	private ProfileService service ;
	
	@RequestMapping(value = "/salesreps/{salesRepId:.+}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public DataResult getProfile(@PathVariable String salesRepId, 
	        HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String auth = request.getHeader("x-auth") ;
		if(auth == null){
			logger.warn("Authentication header missing");
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null ;
		} else { 
			String[] authTokens = auth.split(":") ;
			if(authTokens == null || authTokens.length != 2 || ! "mobile_user".equals(authTokens[0]) || ! "Quiksilver1".equals(authTokens[1])){
				logger.warn("Authentication header (" + auth + ") was bad authentication failed") ;
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
				return null ;
			}
		}
		
		logger.info("Call to [GET] profile with salesRepId=" + salesRepId);
		
		SalesRep result = service.getSalesRep(salesRepId);
		return ServiceUtil.successResult(result);
	}
	
}
