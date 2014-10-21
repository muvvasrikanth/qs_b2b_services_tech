package com.qs.services.sao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.qs.services.domain.CustomerList;
import com.qs.services.sao.CustomerSao;

@Component("CustomerSao")
public class CustomerSaoImpl implements CustomerSao {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerSaoImpl.class) ;
	
	@Autowired
	private RestTemplate restTemplate ;
	
	@Override
	public CustomerList getCustomers(String salesRepId) {
		// TODO Auto-generated method stub
		return null;
	}

}
