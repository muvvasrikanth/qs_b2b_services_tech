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

import com.qs.services.domain.CustomerList;
import com.qs.services.domain.DataResult;
import com.qs.services.service.CustomerService;
import com.qs.services.service.SecurityService;
import com.qs.services.util.ServiceUtil;

@Controller
public class CustomerController{
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService service ;
	
	@Autowired
	private SecurityService securityService ;
	
	@RequestMapping(value = "/customers/salesrep/{salesRepId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public DataResult getCustomers(@PathVariable String salesRepId, 
	        HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		if(logger.isInfoEnabled()){logger.info("Call to [GET] customer with salesRepId=" + salesRepId);}
		
		CustomerList result = service.getCustomers(salesRepId);
		return ServiceUtil.successResult(result);
	}
	
	
}
