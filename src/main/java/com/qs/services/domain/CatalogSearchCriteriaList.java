package com.qs.services.domain;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class CatalogSearchCriteriaList {

	@JsonProperty("ET_CATALOGSEARCHCRITERIAS")
	private List <CatalogSearchCriteria> catalogSearchCriterias = new ArrayList <CatalogSearchCriteria> () ;

	public List<CatalogSearchCriteria> getCatalogSearchCriterias() {
		return catalogSearchCriterias;
	}

	public void setCatalogSearchCriterias(
			List<CatalogSearchCriteria> catalogSearchCriterias) {
		this.catalogSearchCriterias = catalogSearchCriterias;
	}
	
	
}
