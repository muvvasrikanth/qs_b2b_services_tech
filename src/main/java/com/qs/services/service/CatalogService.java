package com.qs.services.service;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.qs.services.domain.CatalogList;
import com.qs.services.domain.CatalogSearchCriteriaList;

public interface CatalogService {

	public CatalogList getCatalogs(String salesRepId) throws JsonGenerationException, JsonMappingException, IOException ;
	
	public CatalogSearchCriteriaList getCatalogSearchCriteria(Integer catalogId) ;
	
}
