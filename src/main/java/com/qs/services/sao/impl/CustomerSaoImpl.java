package com.qs.services.sao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.qs.services.domain.CustomerList;
import com.qs.services.sao.CustomerSao;

@Component("CustomerSao")
public class CustomerSaoImpl implements CustomerSao {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerSaoImpl.class) ;
	
    @Value("${sap_service_url:127.0.0.1}")
    private String sapServiceUrl;
    
	@Autowired
	private RestTemplate restTemplate ;
	
	@Override
	public CustomerList getCustomers(String salesRepId) {

	    CustomerList result = restTemplate.getForObject(sapServiceUrl + "/CONNECT_MOBILE/RepCustomers?sap-client=300", CustomerList.class);
	    
//        ObjectReader or = new ObjectMapper().reader();
        
		return result;
	}

}
