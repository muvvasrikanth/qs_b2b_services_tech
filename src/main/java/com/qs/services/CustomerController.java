package com.qs.services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qs.services.service.CustomerService;
import com.qs.services.service.SecurityService;

@Controller
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService service ;
	
	@Autowired
	private SecurityService securityService ;
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String getCustomers(@RequestParam(value="salesRepId", required=false, defaultValue="") String salesRepId, HttpServletRequest request, HttpServletResponse response){
		
		String xauth = request.getHeader("x-auth") ;
		String[] xatokens = xauth.split(":") ;
		if(! securityService.authenticate(xatokens[0], xatokens[1])){
			try {
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//TODO: Finish the code to get customers for the sales rep
		logger.info("Call to [GET] customer with salesRepId=" + salesRepId);
		
		String result = null ;
		
//		try{
//			String result = service.getCustomers("somesalesrepid") ;
//		} catch (Exception e){
//			response.sendError() ;
//		}
		
		return result ;
	}
	
	
}
