package com.qs.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qs.services.dao.CatalogDao;
import com.qs.services.domain.CatalogList;
import com.qs.services.service.CatalogService;

@Service("CatalogService")
public class CatalogServiceImpl implements CatalogService {
	
	@Autowired
	private CatalogDao dao ;

	@Override
	public CatalogList getCatalogs(String salesRepId) {
		return dao.getCatalogs(salesRepId);
	}

}
