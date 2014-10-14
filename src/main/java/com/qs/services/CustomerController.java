package com.qs.services;

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

@Controller
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService service ;
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String getCustomers(@RequestParam(value="salesRepId", required=false, defaultValue="") String salesRepId, HttpServletRequest request, HttpServletResponse response){
		//TODO: Finish the code to get customers for the sales rep
		logger.info("Call to [GET] customer with salesRepId=" + salesRepId);
		return null ;
	}
	
	
}
