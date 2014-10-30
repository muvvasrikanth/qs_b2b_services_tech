package com.qs.services.dao;

import com.qs.services.domain.CatalogList;
import com.qs.services.domain.CatalogSearchCriteriaList;
import com.qs.services.domain.SalesAreaList;

public interface CatalogDao {
	
	public CatalogList getCatalogs(String brandId, String salesOrg, String distCh) ;
	
	public CatalogList getCatalogs(SalesAreaList salesAreaList) ;
	
	public CatalogSearchCriteriaList getCatalogSearchCriterias(Integer catalogId) ;

}
