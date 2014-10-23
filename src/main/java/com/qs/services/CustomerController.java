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
import org.springframework.web.bind.annotation.ResponseBody;

import com.qs.services.domain.CustomerList;
import com.qs.services.service.CustomerService;
import com.qs.services.service.SecurityService;

@Controller
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService service ;
	
	@Autowired
	private SecurityService securityService ;
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public CustomerList getCustomers(
			@RequestParam(value="salesRepId", required=false, defaultValue="") String salesRepId, 
	        HttpServletRequest request, HttpServletResponse response){
		
		//FIXME uncomment
//		String xauth = request.getHeader("x-auth") ;
//		String[] xatokens = xauth.split(":") ;
//		if(! securityService.authenticate(xatokens[0], xatokens[1])){
//			try {
//				response.sendError(HttpServletResponse.SC_FORBIDDEN);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		logger.info("Call to [GET] customer with salesRepId=" + salesRepId);
		
		try{
			CustomerList result = service.getCustomers(salesRepId) ;
			return result;
		} catch (Exception ex){
        	logger.error(ex.getMessage(), ex);
			try {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR) ;
            } catch (IOException e1) {
            	logger.error(e1.getMessage(), e1);
            }
		}
		return null;
	}
	
	
}
