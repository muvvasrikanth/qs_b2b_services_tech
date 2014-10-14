package com.qs.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qs.services.domain.CustomerList;
import com.qs.services.sao.CustomerSao;
import com.qs.services.service.CustomerService;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerSao sao ;

	@Override
	public CustomerList getCustomers(String salesRepId) {
		// TODO Auto-generated method stub
		return null;
	}

}
