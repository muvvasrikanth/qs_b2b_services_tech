package com.qs.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qs.services.dao.SalesRepDao;
import com.qs.services.domain.SalesRep;
import com.qs.services.service.ProfileService;

@Service("ProfileService")
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private SalesRepDao dao ;

	@Override
	public SalesRep getSalesRep(String salesRepId) {
		return dao.getProfile(salesRepId);
	}

}
