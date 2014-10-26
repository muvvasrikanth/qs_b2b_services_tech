package com.qs.services.dao;

import com.qs.services.domain.CatalogList;
import com.qs.services.domain.CatalogSearchCriteriaList;

public interface CatalogDao {
	
	public CatalogList getCatalogs(String brandId, String salesOrg, String distCh) ;
	
	public CatalogSearchCriteriaList getCatalogSearchCriterias(Integer catalogId) ;

}
