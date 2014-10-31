package com.qs.services.dao;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.qs.services.domain.CatalogList;
import com.qs.services.domain.CatalogSearchCriteriaList;
import com.qs.services.domain.SalesAreaList;

public interface CatalogDao {
	
	public CatalogList getCatalogs(String brandId, String salesOrg, String distCh) ;
	
	public CatalogList getCatalogs(SalesAreaList salesAreaList) throws JsonGenerationException, JsonMappingException, IOException ;
	
	public CatalogSearchCriteriaList getCatalogSearchCriterias(Integer catalogId) ;

}
