package com.qs.services.service;

import com.qs.services.domain.CatalogList;
import com.qs.services.domain.CatalogSearchCriteriaList;

public interface CatalogService {

	public CatalogList getCatalogs(String salesRepId) ;
	
	public CatalogSearchCriteriaList getCatalogSearchCriteria(Integer catalogId) ;
	
}
